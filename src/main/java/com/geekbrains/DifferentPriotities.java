package com.geekbrains;

public class DifferentPriotities {

    @BeforeSuite
    public static  void methodStart (){
        System.out.println("Before suit method");
    }

    @Test(priotity = 7)
    public static void method1 (){
        System.out.println("Test method1 with priority 7");
    }

    @Test(priotity = 2)
    public static void method2(){
        System.out.println("Test method2 with priority 2");
    }

    @Test(priotity = 5)
    public static void method3(){
        System.out.println("Test method3 with priority 5");
    }

    @Test(priotity = 1)
    public static void method4(){
        System.out.println("Test method4 with priority 1");
    }

    @Test(priotity = 3)
    public static void method5(){
        System.out.println("Test method5 with priority 3");
    }

    @AfterSuite
    public static void methodEnd(){
        System.out.println("After suite method");
    }
}
