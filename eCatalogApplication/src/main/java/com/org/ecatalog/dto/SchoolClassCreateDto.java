package com.org.ecatalog.dto;

import com.org.ecatalog.entity.ClassLevel;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SchoolClassCreateDto {

    private Integer startYear;

    private String name;

    private ClassLevel classLevel;
}
