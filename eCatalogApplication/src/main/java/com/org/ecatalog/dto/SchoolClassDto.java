package com.org.ecatalog.dto;

import com.org.ecatalog.entity.ClassLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Builder
public class SchoolClassDto {

    private Long id;

    private Integer startYear;

    private String name;

    private ClassLevel classLevel;

    private String normalizedSchoolClassName;

    public SchoolClassDto(Long id, Integer startYear, String name, ClassLevel classLevel, String normalizedSchoolClassName) {
        this.id = id;
        this.startYear = startYear;
        this.name = name;
        this.classLevel = classLevel;
        this.normalizedSchoolClassName = getNormalizedName();
    }

    private String getNormalizedName() {
        LocalDate now = LocalDate.now();
        Integer currentYear = now.getYear();

        Integer yearDifference = currentYear - startYear;

        if (yearDifference <= 4) {

            switch (classLevel) {
                case PRIMARY:
                    return "a-" + (yearDifference) + "-a " + name;
                case MIDDLE_SCHOOL:
                    return "a-" + (yearDifference + 4) + "-a " + name;
                case HIGH_SCHOOL:
                    return "a-" + (yearDifference + 8) + "-a " + name;
            }
        } else {
            int finishYear = startYear + 4;
            String text = "Promotia " + startYear + " - " + finishYear + " ciclu ";
            switch (classLevel) {
                case PRIMARY:
                    return text + " primar clasa " + name;
                case MIDDLE_SCHOOL:
                    return text + " gimnazial clasa " + name;
                case HIGH_SCHOOL:
                    return text + " liceal clasa " + name;
            }
        }
        return "";
    }

}