package com.geekbrains;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
        try {
            System.out.println("\nTest class with methods of equal priorities");
            start(SamePriorities.class);
            System.out.println("\nTest class with methods of different priorities");
            start(DifferentPriotities.class);
            System.out.println("\nTest class with multiple BeforeSuite annotated methods");
            start(MultipleBeforeSuite.class);
            System.out.println("\nTest class with multiple AfterSuite annotated methods");
            start(MultipleAfterSuite.class);
        } catch (IllegalAccessException | InvocationTargetException | RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class className) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = className.getDeclaredMethods();
        ArrayList<Annotation> beforeSuite = new ArrayList<>();
        ArrayList<Annotation> afterSuite = new ArrayList<>();
        for (Method method : methods) {
            Annotation beforeSuiteAnnotation = method.getAnnotation(BeforeSuite.class);
            Annotation afterSuiteAnnotation = method.getAnnotation(AfterSuite.class);
            if (beforeSuiteAnnotation != null) {
                beforeSuite.add(beforeSuiteAnnotation);
            }
            if (afterSuiteAnnotation != null) {
                afterSuite.add(method.getAnnotation(AfterSuite.class));
            }
        }
        if (beforeSuite.size() <= 1 && afterSuite.size() <= 1) {
            int i = 1;
            for (Method method : methods) {
                if (method.getAnnotation(BeforeSuite.class) != null) {
                    method.invoke(className);
                }
            }
            for (int j = 1; j <= 10; j++) {
                for (Method method : methods) {
                    Test testAnnotation = method.getAnnotation(Test.class);
                    if (testAnnotation != null) {
                        if (testAnnotation.priotity() == j) {
                            method.invoke(className);
                        }
                    }
                }
            }
            for (Method method : methods) {
                if (method.getAnnotation(AfterSuite.class) != null) {
                    method.invoke(className);
                }
            }
        } else {
            throw new RuntimeException("There are multiple BeforeSuite/AfterSuite methods");
        }
    }
}
