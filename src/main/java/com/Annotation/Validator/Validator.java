package com.Annotation.Validator;

import java.lang.reflect.Field;

public class Validator{
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                Object value = field.get(obj);

                if (value == null) {
                    NotNull annotation = field.getAnnotation(NotNull.class);
                    throw new RuntimeException(annotation.message());
                }
            }
        }
    }
}