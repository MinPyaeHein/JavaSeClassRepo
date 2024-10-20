package com.jdbc_v3.Util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtil {
    public static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            // Add all declared fields of the current class
            for (Field field : clazz.getDeclaredFields()) {
                fields.add(field);
            }
            // Move to the superclass
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

}
