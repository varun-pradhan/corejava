package org.example;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;

public class Solution{
    public static void main(String []argh){
        // Now calling fact(33) to demonstrate the BigInteger fix.
//        System.out.println("Factorial of 33 is: " + fact(33));
        System.out.println(countZeros((int)(0342),0));
//        System.out.println(countZeros(3002,0));
        System.out.println(countZeros(-300200,0));
        /*
        reverse_number(4281);
        System.out.println(sum);
        System.out.println(reverse(4281));

         System.out.println(Math.log10(4321456)+1);
         You can test other methods here as well, for example:
         System.out.println("Sum to 5 is: " + sum_to_n(5));
         BigInteger input = new BigInteger("8329894539");
         System.out.println("Sum of digits for " + input + " is: " + sum_of_digits(input));
        */

    }
    static int sum = 0;
    private static void reverse_number(int n){
        if( n == 0) return ;
        int lastDigit = n%10;
        int remainingDigit = n/10;
        sum = sum * 10 + lastDigit ;
        reverse_number(remainingDigit);
    }

    private static boolean integerPalindrome(int input){
        return input == reverse(input);
    }

    private static int reverse(int n){
//        if(n == 0) return ;
        int digits = (int)(Math.log10(n));
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n%10 == n) return n;
        int rem = n%10;
        return rem * (int)(Math.pow(10, digits)) + helper( n/10, digits-1) ;
    }

    private static double myPow( double x, int n)
    {
        double ans = 1.0;
        long exp = n;
        if(exp < 0)    exp = -1 * exp;
        while( exp > 0){
            if( exp%2 == 0){    // exp is odd
                x =  x * x;         // square the base
                exp /= 2;       // half the exponent
            }else{
                ans = ans * x;
                exp -= 1;
            }
        }
        if(n<0) ans = (double)(1.0)/(double)(ans);
        return ans;
    }

    private static int countZeros(int n, int count){
//        int rem =  n%10 ;

        if( n% 10 == n) return count;

        if (n % 10 == 0) {
                return countZeros(n / 10, ++count);
            } else {
                return countZeros(n / 10, count);
            }
//        }
//        return count;

    }

//        System.out.println(myPow(2,10));
//        System.out.println(sum_to_n(5));

    private static BigInteger sum_of_digits( BigInteger n){
        if( n.equals(BigInteger.ZERO)){
            return BigInteger.ZERO;
        }
        BigInteger lastDigit = n.remainder(BigInteger.TEN);
        BigInteger remainingNumber = n.divide(BigInteger.TEN);
        return lastDigit.add(sum_of_digits(remainingNumber));
    }

    private static int sum_to_n(int n){
        if( n== 1){
            return 1;
        }
        return n + sum_to_n( n-1);
    }

    /**
     * Calculates the factorial of a number using BigInteger to prevent overflow.
     * @param n The non-negative integer.
     * @return The factorial of n as a BigInteger.
     */
    private static BigInteger fact(int n) {
        // Base case: 0! or 1! is 1.
        if (n <= 1) {
            return BigInteger.ONE;
        }
        // Recursive Step: n * (n-1)!
        // We convert the current number 'n' to a BigInteger to multiply it
        // with the result of the recursive call.
        return BigInteger.valueOf(n).multiply(fact(n - 1));
    }

    private static void func(int i) {
        if ( i ==0) return;
        func(i-1);
        System.out.println(i);

    }
}