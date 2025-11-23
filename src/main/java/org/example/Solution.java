package org.example;

import java.util.Scanner;

import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String []argh){

//        StringBuffer stringBuffer = new StringBuffer("Ji Maalak");
//        StringBuilder stringBuilder = new StringBuilder("Hello world");
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int a,b,n;
        for(int i=0;i<t;i++){
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
                int sum = a +(b * (int) Math.pow(2,0)) ;;
            for(int j=1;j<n;j++){
                System.out.print(sum+" ");
                        sum += (b * (int) Math.pow(2,j)) ;//a + Math.pow(b,0);

            }
            sum = 0;
            System.out.println();
        }

        in.close();
    }
}