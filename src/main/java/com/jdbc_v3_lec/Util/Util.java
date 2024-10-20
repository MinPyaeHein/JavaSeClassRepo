package com.jdbc_v3_lec.Util;

import com.jdbc_v3.Annotation.Column;
import com.jdbc_v3.Annotation.Id;
import com.jdbc_v3.Util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> getAllFields(Class<?> classType) {
         List<String> list = new ArrayList<String>();

        while (classType != null) {
            // Add all declared fields of the current class
            for (Field field : classType.getDeclaredFields()) {
              list.add(field.getName());
            }
            // Move to the superclass
            classType = classType.getSuperclass();
        }
        return list;
    }
    public static List<String> getAllColumnField(Class<?> classType) {
        List<String> list = new ArrayList<String>();

        while (classType != null) {
            // Add all declared fields of the current class
            for (Field field : classType.getDeclaredFields()) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    list.add(column.name());
                }
            }
            // Move to the superclass
            classType = classType.getSuperclass();
        }
        return list;
    }

    public static List<String> getAllIdField(Class<?> classType) {
        List<String> list = new ArrayList<String>();

        while (classType != null) {
            for (Field field : classType.getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    Id id = field.getAnnotation(Id.class);
                    list.add(id.name());
                }
            }
            classType = classType.getSuperclass();
        }
        return list;
    }
    public static Object[] getColumnFieldValues(Object t) {
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
    public static  Object[] getIdFieldValues(Object t) {
        List<Field> fields = ReflectionUtil.getAllFields(t.getClass());

        List<Object> values = new ArrayList<>();
        try {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Id.class)) {
                    field.setAccessible(true);
                    values.add(field.get(t));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return values.toArray();
    }
    public static Object[] getFieldValues(Object t) {
        List<Object> combinedList = new ArrayList<>();
        combinedList.addAll(Arrays.asList(getColumnFieldValues(t)));
        combinedList.addAll(Arrays.asList(getIdFieldValues(t)));
        return combinedList.toArray();
    }
}
