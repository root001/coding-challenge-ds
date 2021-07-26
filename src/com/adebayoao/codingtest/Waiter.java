package com.adebayoao.codingtest;

import java.util.Scanner;
import java.util.Stack;

public class Waiter {

    private static Stack<Integer> plateStack = new Stack<>();
    private static Stack<Integer> divisibleStack = new Stack<>();
    private static Stack<Integer> nonDivisibleStack = new Stack<>();

        private static int[] generatePrimeNos(int Q, int arrPrime[]) {
            int index = 0;
            int flag = 1;
            if (Q == 1) {
                arrPrime[index++] = 2;
                return arrPrime;
            }
            for (int i = 2; Q > 0; i++) {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        flag = 0;
                        break;
                    }
                }
                if (flag != 0) {
                    arrPrime[index++] = i;
                    Q--;
                }
                flag = 1;
            }
            return arrPrime;
        }

        private static void getStacks( int N, int Q){
            int primeArr[] = new int[Q];
            primeArr = generatePrimeNos(Q, primeArr);
            int arrElement;
            for (int i = 0; i < Q; i++) {
                while (!plateStack.isEmpty()) {
                    arrElement = plateStack.pop();
                    if (arrElement % primeArr[i] == 0) {
                        divisibleStack.push(arrElement);
                    } else {
                        nonDivisibleStack.push(arrElement);
                    }
                }
                plateStack = nonDivisibleStack;
                nonDivisibleStack = new Stack<>();
                while (!divisibleStack.isEmpty()) {
                    System.out.println(divisibleStack.pop());
                }
            }
            while (!plateStack.isEmpty()) {
                System.out.println(plateStack.pop());
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int q = sc.nextInt();
            for (int i = 0; i < n; i++) {
                plateStack.push(sc.nextInt());
            }
            Waiter.getStacks( n,  q);
        }

}
