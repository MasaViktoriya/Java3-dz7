package com.geekbrains;

public class MultipleAfterSuite {
    @BeforeSuite
    public static void methodStart (){
        System.out.println("Before suit method");
    }

    @Test
    public static void method1 (){
        System.out.println("Test method1  with priority 1");
    }

    @AfterSuite
    public static void method2(){
        System.out.println("Test method2");
    }

    @Test
    public static void method3(){
        System.out.println("Test method3 with priority 1");
    }

    @Test
    public static void method4(){
        System.out.println("Test method4 with priority 1");
    }

    @AfterSuite
    public static void methodEnd(){
        System.out.println("After suite method");
    }
}
