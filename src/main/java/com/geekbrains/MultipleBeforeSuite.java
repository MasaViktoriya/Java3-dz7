package com.geekbrains;

public class MultipleBeforeSuite {

    @BeforeSuite
    public static void methodStart (){
        System.out.println("Before suit method");
    }

    @BeforeSuite
    public static void method1 (){
        System.out.println("Test method1");
    }

    @Test(priotity = 3)
    public static void method2(){
        System.out.println("Test method2");
    }

    @Test(priotity = 3)
    public static void method3(){
        System.out.println("Test method3");
    }

    @BeforeSuite
    public static void method4(){
        System.out.println("Test method4");
    }

    @AfterSuite
    public static void methodEnd(){
        System.out.println("After suite method");
    }
}
