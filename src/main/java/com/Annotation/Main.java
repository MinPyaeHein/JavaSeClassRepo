package com.Annotation;

import com.Annotation.logWriter.AnnotationProcessor;
import com.Annotation.logWriter.Calculator;

public class Main {

    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        AnnotationProcessor.processAnnotations(calculator);
    }
}
