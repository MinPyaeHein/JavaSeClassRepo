package com.jdbc_v3.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Annotation to define table mapping
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String name();
}

