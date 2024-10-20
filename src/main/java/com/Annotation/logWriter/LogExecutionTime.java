package com.Annotation.logWriter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // Annotation is available at runtime
@Target(ElementType.METHOD)          // Annotation can only be applied to methods
public @interface LogExecutionTime {
}
