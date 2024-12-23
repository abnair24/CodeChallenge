package com.abn.scalar.dsa.day4;

// Find all the factors of Number n in optimized way

public class FactorOfNumber {

    public int factorsOfNumber(int n) {

        int count = 0;

        if(n <= 0) {
            return 0;
        }

        if( n == 1)  {
            return 1;
        }

        if(n == 2) {
            return 2;
        }


//        for(int i = 1; i <= (n/i); i++) {
//            if(n % i == 0) {
//                if( i * i == n) {
//                    count ++;
//                } else {
//                    count += 2;
//                }
//            }
//        }

        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                if( i * i == n) {
                    count ++;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        FactorOfNumber factorOfNumber = new FactorOfNumber();
        System.out.println(factorOfNumber.factorsOfNumber(10));
        System.out.println(factorOfNumber.factorsOfNumber(1));
        System.out.println(factorOfNumber.factorsOfNumber(2));
        System.out.println(factorOfNumber.factorsOfNumber(24));
        System.out.println(factorOfNumber.factorsOfNumber(25));

    }
}
