package com.example.victorbeil.myapplication2.util;

public class Calculator {

   public static int calculate(int z, int n ){
       return calc(z,n);
   }

   // not static
   public double calculate(int z, double y){
       return 1.0;
   }


   private static int calc(int z,int n){
        if (z * n != 0) {
            int rest;
            int ggt = Math.abs(z);
            int divisor = Math.abs(n);
            do {
                rest = ggt % divisor;
                ggt = divisor;
                divisor = rest;
            } while (rest > 0);
            z /= ggt;
            n /= ggt;
        }
        return 0;
    }


}
