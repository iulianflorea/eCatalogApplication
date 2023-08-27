package com.org.ecatalog.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolClassInvalidException extends Exception{

    public SchoolClassInvalidException(List<String> errors) {
        super(errors.stream().collect(Collectors.joining()));
    }
}
