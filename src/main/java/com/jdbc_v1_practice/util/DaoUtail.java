package com.jdbc_v1_practice.util;

import com.jdbc_v1_practice.annotation.Column;
import com.jdbc_v1_practice.annotation.Id;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DaoUtail {
    public static List<Field> getFieldsFromObj(Object obj,Boolean need,String... fields){
        List<Field> filteredFields = new ArrayList<Field>();
        for (Field field: obj.getClass().getDeclaredFields()){
            List<String> listFields= List.of(fields);

            Id idAnnotation = field.getAnnotation(Id.class);
            Column columnAnnotation = field.getAnnotation(Column.class);

            // Determine the field name to use based on the annotation type
            String fieldName = null;
            if (idAnnotation != null) {
                fieldName = idAnnotation.name();
            } else if (columnAnnotation != null) {
                fieldName = columnAnnotation.name();
            }
            if(need){
                if(listFields.contains(fieldName)){
                    filteredFields.add(field);
                }
            }else{
                if(!listFields.contains(fieldName)){
                    filteredFields.add(field);
                }
            }
        }
        return filteredFields;
    }
}
