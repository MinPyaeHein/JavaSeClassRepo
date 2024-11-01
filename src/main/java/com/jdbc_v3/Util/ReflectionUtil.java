package com.jdbc_v3.Util;

import com.jdbc_v3.Annotation.Column;

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
    public static Object[] getFieldValues(Object t) {
        List<Field> fields = ReflectionUtil.getAllFields(t.getClass());

        List<Object> values = new ArrayList<>();
        try {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    values.add(field.get(t));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return values.toArray();
    }
    public static String getFieldColumName(Field field) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                return column.name();
            }
     return null;
    }


}
