package com.jdbc_v3.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Annotation to define primary key
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    String name();
}
