package com.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@interface MyAnnotation{}

@MyAnnotation
public class TestType {

    @MyAnnotation
    private  int type;
    @SuppressWarnings({"checked", "deprecation"})
    public static void main(String[] args) {

        DeprecatedTest test=new DeprecatedTest();
        test.Display();

      }
    @Deprecated
    public static void display(@MyAnnotation String type) {
        System.out.println("hello world");

    }
}
class DeprecatedTest
{
    @Deprecated
    public void Display()
    {
        System.out.println("Deprecatedtest display()");
    }
}