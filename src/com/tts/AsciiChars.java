package com.tts;

public class AsciiChars {

    public static void printNumbers()

    {
        System.out.println("Valid Numeric Inputs");
        for (int i=48; i<= 57; i++){
            System.out.print((char)i);
        }
        System.out.println();
    }

    public static void printLowerCase()
    {
        System.out.println("print valid lowercase alphabetic input");
        for(int i=97; i<=122; i++){
            System.out.print((char)i);
        }
        System.out.println();
    }

    public static void printUpperCase()
    {
        System.out.println("print valid uppercase alphabetic input");
        for(int i=65; i<=90; i++){
            System.out.print((char)i);
        }
        System.out.println();
    }
}

