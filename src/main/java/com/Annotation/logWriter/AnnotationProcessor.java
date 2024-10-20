package com.Annotation.logWriter;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void processAnnotations(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            // Check if the method has the @LogExecutionTime annotation
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.currentTimeMillis();

                // Invoke the method
                method.setAccessible(true);
                method.invoke(obj, 2, 3);  // Example: invoke with parameters 2 and 3

                long endTime = System.currentTimeMillis();
                System.out.println("Execution time for " + method.getName() + ": " + (endTime - startTime) + "ms");
            }
        }
    }
}
