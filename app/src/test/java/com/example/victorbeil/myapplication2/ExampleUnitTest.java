package com.example.victorbeil.myapplication2;

import com.example.victorbeil.myapplication2.util.Calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCalculator() {
        System.out.println("test");

        Assert.assertTrue( 0 == Calculator.calculate(1, 2));
    }

   /* public double calc(int z, int n) {
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
        return 0;
        } return 0;

    }*/
}
