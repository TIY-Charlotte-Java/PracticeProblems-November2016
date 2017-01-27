package com.theironyard.charlotte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static int[] mergeSort(int[] unsortedArray) {
        if (unsortedArray.length == 1) {
            return unsortedArray;
        }

        int[] unsortedLeft = Arrays.copyOfRange(unsortedArray, 0, unsortedArray.length / 2);
        int[] unsortedRight = Arrays.copyOfRange(unsortedArray, unsortedArray.length / 2, unsortedArray.length);

        return merge(mergeSort(unsortedLeft), mergeSort(unsortedRight));
    }

    private static int[] merge(int[] sortedLeft, int[] sortedRight) {
        int[] results = new int[sortedLeft.length + sortedRight.length];

        int leftIdx = 0, rightIdx = 0;

        for (int i = 0;i < results.length;i++) {
            if (rightIdx == sortedRight.length ||
                (leftIdx < sortedLeft.length && sortedLeft[leftIdx] <= sortedRight[rightIdx])) {
                results[i] = sortedLeft[leftIdx++];
            } else {
                results[i] = sortedRight[rightIdx++];
            }
        }

        return results;
    }

    public static boolean overlaps(LocalDateTime beginStartTime, LocalDateTime beginEndTime, LocalDateTime endStartTime, LocalDateTime endEndTime) {
        return
           !((beginStartTime.isBefore(endStartTime) && beginEndTime.isBefore(endStartTime)) ||
            (beginStartTime.isAfter(endEndTime) && beginEndTime.isAfter(endEndTime)));
    }


    public static void baconLottery() {
        Lottery l = new Lottery();

        l.guess("Ben", 15);
        l.guess("Stephen", 20);
        l.guess("Grace", 7);
        l.guess("BenB", 13);
        l.guess("Sam", 24);
        l.guess("Joe", 17);
        l.guess("Emileen", 22);
        l.guess("Kelsey", 21);

        l.playLottery();
    }


    public static int[] masterMind(int[] actual, int[] guess) {
        actual = Arrays.copyOf(actual, actual.length);

        int[] results = new int[actual.length];

        for (int i = 0;i < results.length;i++) {
            if (actual[i] == guess[i]) {
                results[i] = 2;
                actual[i] = 0;
            }
        }

        for (int i = 0;i < results.length;i++) {
            int actualIndex = findIndexOfValue(actual, guess[i]);

            if (actualIndex > -1 && actual[actualIndex] > 0) {
                results[i] = 1;
                actual[actualIndex] = 0;
            }
        }

        return results;
    }


    private static int findIndexOfValue(int[] array, int value) {
        for (int i = 0;i < array.length;i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static int[] climb(int start, int length) {
        int[] results = new int[length];

        for (int i = 0;i < length;i++) {
            start += i;
            results[i] = start;
        }

        return results;
    }

    public static int cherokee(int startingPopulation, double growthRate, int weeks) {
        return (int)(startingPopulation * Math.pow(1 + growthRate, weeks));
    }

    public static Color heat(int heatIndex) {

        double heatPercentage = (double)heatIndex / 100;

        if (heatIndex < 0 || heatIndex > 100) {
            throw new IllegalArgumentException("Invalid Heat Index!");
        }

        return new Color((int)(heatPercentage * 255), 0, (int)((1 - heatPercentage)*255));
    }


    public static int rosebud(String input) {
        int result = 0;

        Pattern p = Pattern.compile("rosebud(!+)1");
        Matcher m = p.matcher(input);

        if (m.matches()) {
            result = m.group(1).length();
        }

        return result;
    }

    public static boolean narcissistic(int input) {
        return true;
    }

    public static int sevenCount(String input) {
        return (int)input
                .chars()
                .mapToObj(i -> (char)i)
                .filter(c -> c == '7')
                .count();
    }

    private static int daysNemoSurvives() {
        int fishCount = 10;
        int days = 20;

        for (int i = 1;i <= days;i++) {
            // try to catch a fish
            if (Math.random() <= .10) {
                fishCount++;
            }

            // eat a fish
            fishCount--;

            // we ate a nonexistent fish
            if (fishCount < 0) {
                return i;
            }
        }

        return days;
    }

    public static double simulateNemo() {
        int survivesCount = 0;
        int trials = 100000;

        Integer[] nemoData = new Integer[trials];

        for (int i = 0;i < trials;i++) {
            nemoData[i] = daysNemoSurvives();
        }

        // find the average (and print)
        int sum = Arrays.stream(nemoData).collect(Collectors.summingInt(i -> i));
        double average = sum / (double)nemoData.length;

        System.out.println("The average days survived is: " + average);

        Double[] deviations = Arrays.stream(nemoData).map(i -> Math.pow(i - average, 2)).toArray(Double[]::new);

        double averageDeviation = Arrays.stream(deviations).collect(Collectors.averagingDouble(d -> d));

        System.out.println("The standard deviation for survival is: " + Math.sqrt(averageDeviation));

        return survivesCount / (double)(trials / 100);
    }

    public static String headerliner(String input) {
        input = input.trim().toLowerCase();

        String[] words = input.split(" ");

        for (int i = 0;i < words.length;i++) {
            // if there are extra whitespace characters, they will
            // show up in the array. ignore them.
            if (!words[i].equals("")) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            }
        }

        return String.join(" ", words);
    }

    public static int desirable(String input) {
        int desirableCount = 0;

        for (int i = 0;i < input.length();i++) {
            if (input.charAt(i) == 'H') {
                int beginning = i - 2 < 0 ? 0 : i - 2;
                int end = i + 2 >= input.length() ? input.length() : i + 2;

                if (input.substring(beginning, end).contains("R")) {
                    desirableCount++;
                }
            }
        }

        return desirableCount;
    }

    public static String reverse(String input) {
        char[] chars = input.toCharArray();

        char temp;

        for (int i = 0;i < chars.length / 2;i++) {
            int idx = i;
            int mirror = (chars.length - 1) - i;

            temp = chars[idx];
            chars[idx] = chars[mirror];
            chars[mirror] = temp;
        }

        return new String(chars);
    }

    public static int longx(String input) {
        int count = 0, maxCount = 0;

        for (char c : input.toCharArray()) {
            if (c == 'x') {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    public static Color blend(Color[] colors) {
        int redSum = 0, greenSum = 0, blueSum = 0;

        for (Color c : colors) {
            redSum += c.red;
            greenSum += c.green;
            blueSum += c.blue;
        }

        return new Color(redSum / colors.length, greenSum / colors.length, blueSum / colors.length);
    }

    public static double monteCarloPi(int trials) {
        double successes = 0;

        for (int i = 0; i < trials;i++) {
            double x = Math.random();
            double y = Math.random();
            double z = Math.sqrt(x * x + y * y);

            if (z <= 1.00) {
                successes++;
            }
        }
        double results = 4 * (successes / trials);
        System.out.println(results);

        return results;
    }

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
//        System.out.println(isPalindrome("A Santa at Nasa"));
//        System.out.println(isPalindrome("Avid diva"));
//        System.out.println(isPalindrome("Anna"));
//
//        System.out.println(isPalindrome("Tub"));
//        System.out.println(isPalindrome("This is not a palindrome"));
//        System.out.println(isPalindrome("Believe it"));

//        System.out.println(
//                blend(
//                        new Color[] {
//                                new Color(255, 0, 0),
//                                new Color(0, 0, 255)
//                        }
//                )
//        );
            System.out.println(5 >> 2);

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

//    public static int maxBlock(String word) {
//        String[] letters = word.split("")
//    }
}
