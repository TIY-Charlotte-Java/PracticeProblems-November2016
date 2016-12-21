package com.theironyard.charlotte;

import java.util.ArrayList;
import java.util.function.Function;

public class Main {

    public static double flipper(int trials) {
        int successes = 0;

        Function<Double, Boolean> trialFunc =
                (percentage) -> Math.random() <= percentage;


        for (int i = 0; i < trials;i++) {
            if (trialFunc.apply(.8) &&
                trialFunc.apply(.8) &&
                trialFunc.apply(.8)) {
                successes++;
            }
        }

        return (double)successes/trials;
    }

    public static int capitalized(String input) {
        int capsCount = 0;

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capsCount++;
            }
        }

        return capsCount;
    }



    public static int silver(int[] numbers) {
        Integer largest = null, secondLargest = null;

        for (int num : numbers) {
            if (largest == null || num > largest) {
                secondLargest = largest;
                largest = num;
            }
        }

        return secondLargest;
    }


    public static int boost(int input) {
        ArrayList<String> ints = new ArrayList<>();

        while (input > 0) {
            int lastDigit = input % 10;

            ints.add(Integer.toString((lastDigit + 1) % 10));

            input /= 10;
        }

        // 152 -> 2, 5, 1
//        Collections.reverse(ints);

        StringBuilder sb = new StringBuilder();

        for (int i = ints.size() - 1;i >= 0;i--) {
            sb.append(ints.get(i));
        }

        return Integer.valueOf(sb.toString());
    }

    public static boolean balanced(String word, char letter) {
        int match = 0, notMatch = 0;
        char[] chars = word.toCharArray();

        for (char c : chars) {
            if (c == letter) {
                match++;
            } else {
                notMatch++;
            }
        }

        return match == notMatch;
    }


    public static boolean isPalindrome(String argument) {
        // ignore argument's spaces
        argument = argument.replace(" ",  "");

        // and capitalization.
        argument = argument.toLowerCase();

        StringBuilder sb = new StringBuilder(argument).reverse();

        return argument.equals(sb.toString());
    }

    public static Integer[] divisible(int[] values, int[] divis) {
        ArrayList<Integer> divisibles = new ArrayList<>();

        int leastCommonMultiple = 1;

        for (int d : divis) {
            leastCommonMultiple *= d;
        }

        for (int v : values) {
            if (v % leastCommonMultiple == 0) {
                divisibles.add(v);
            }
        }

        return divisibles.toArray(new Integer[0]);
    }

    public static boolean divisibleByAll(int[] values, int test) {
        for (int v : values) {
            if (test % v != 0) {
                return false;
            }
        }

        return true;
    }

    public static int gimme(int[] args) {
        return args[(int)(Math.random()) * args.length];
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A Santa at Nasa"));
        System.out.println(isPalindrome("Avid diva"));
        System.out.println(isPalindrome("Anna"));

        System.out.println(isPalindrome("Tub"));
        System.out.println(isPalindrome("This is not a palindrome"));
        System.out.println(isPalindrome("Believe it"));


//        changeForMoney(24.76);

    }

//    public static boolean isPalindrome(String input) {
//        input = input.replace(" ", "").toLowerCase();
//
//        if (input.isEmpty()) {
//            return true;
//        }
//
//        System.out.println(input);
//
//        return input.charAt(0) == input.charAt(input.length() - 1) &&
//                isPalindrome(input.substring(1, input.length() - 1));
//
//    }

//    public static boolean isPalindrome(String input) {
//        input = input.replace(" ", "").toLowerCase();
//
//        for (int i = 0;i < input.length() / 2;i++) {
//            if (input.charAt(i) != input.charAt(input.length() - 1- i)) {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    public static boolean isPalindrome(String input) {
//        input = input.replace(" ", "").toLowerCase();
//
//        StringBuilder sb = new StringBuilder(input);
//        String first = sb.substring(0, sb.length() / 2);
//        StringBuilder second = new StringBuilder(sb.substring(sb.length() / 2));
//
//        return second.reverse().toString().equals(first);
//    }

    public static void changeForMoney(double money) {
        money *= 100;

        int dollar = 100;
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        int dollars = (int)(money / dollar);
        money -= dollars * dollar;

        int quarters = (int)(money / quarter);
        money -= quarters * quarter;

        int dimes = (int)(money / dime);
        money -= dimes * dime;

        int nickels = (int)(money / nickel);
        money -= nickels * nickel;

        int pennies = (int)(money / penny);

        System.out.printf("You have %d dollars, %d quarters, %d dimes, %d nickels and %d pennies.\n",
                dollars, quarters, dimes, nickels, pennies);


    }

}
