package com.jdbc_v3.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Annotation to define column mapping
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String name();
}
