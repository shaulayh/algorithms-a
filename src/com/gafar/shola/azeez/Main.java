package com.gafar.shola.azeez;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int[] arrays = new int[]{25, 4, 3, 8, 9, 390, 32, 3};

        // selectionSort(arrays);
        bubbleSort(arrays);
        System.out.println(Arrays.toString(arrays));

        System.out.println(factorial(4));

        System.out.println(hasPairWithSum(new int[]{1, 2, 6, 1, 3}, 9));

        System.out.println(Arrays.toString(addOneToArray(new int[]{9, 9, 9})));

        int y = areaOfOverlap(new Rectangle(new Point(2, 1), new Point(5, 5)),
                new Rectangle(new Point(3, 2), new Point(5, 7)));
        System.out.println(y);

        System.out.println(numberOfPossibleWay("128", 3));

        System.out.println(Arrays.
                toString(moreCloseToSum(new int[]{2, 7, 9}, new int[]{1, 3, 5}, 11)));

    }


    private static void swap(int[] arrays, int first, int last) {
        int temp = arrays[first];
        arrays[first] = arrays[last];
        arrays[last] = temp;
    }


    private static void selectionSort(int[] arrays) {
        int min_index;
        for (int i = 0; i < arrays.length - 1; i++) {
            min_index = 1;
            for (int j = 1; j < arrays.length; j++) {
                if (arrays[min_index] > arrays[j]) {
                    min_index = j;
                }
            }
            swap(arrays, i, min_index);
        }
    }

    private static void bubbleSort(int[] arrays) {


        for (int j = 0; j < arrays.length - 1; j++) {
            for (int i = 0; i < arrays.length - 1; i++) {
                if (arrays[i + 1] < arrays[i]) {
                    swap(arrays, i, i + 1);
                }
            }
        }

    }


    private static int factorial(int number) {

        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    private static boolean hasPairWithSum(int[] array, int sum) {
        Set<Integer> distinctNumbers = new HashSet<>();
        for (Integer integer : array) {
            if (distinctNumbers.contains(integer)) {
                return true;
            }
            distinctNumbers.add(sum - integer);
        }
        return false;
    }

    private static int[] addOneToArray(int[] array) {
        int carry = 1;
        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int sum = array[i] + carry;
            if (sum == 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            result[i] = sum % 10;
        }

        if (carry == 1) {
            result = new int[array.length + 1];
            result[0] = carry;
        }
        return result;
    }

    private static int areaOfOverlap(Rectangle rectangle1, Rectangle rectangle2) {

        // calculating the overlaping distances
        int x = distance(rectangle1.getUpper().getX(),
                rectangle2.getUpper().getX(),
                rectangle1.getLower().getX(),
                rectangle2.getLower().getX());
        int y = Math.min(rectangle1.getUpper().getY(),
                rectangle2.getUpper().getY()) -
                Math.max(rectangle1.getLower().getY(), rectangle2.getLower().getY());

        if (x < 0 || y < 0) {
            return -1;
        } else {
            return x * y;
        }
    }

    /**
     * @param upperPXOrY1 upper point x or y for rectangle 1
     * @param upperPXOrY2 upper point x or y for rectangle 2
     * @param lowerPXOrY1 lower point x or y for rectangle 1
     * @param lowerPXOrY2 lower point x or y for rectangle 2
     * @return the ovarlaping distance
     */
    private static int distance(int upperPXOrY1, int upperPXOrY2, int lowerPXOrY1, int lowerPXOrY2) {
        return Math.min(upperPXOrY1,
                upperPXOrY2) -
                Math.max(lowerPXOrY1, lowerPXOrY2);
    }

    private static int numberOfPossibleWay(String data, int length) {
        if (length == 0) {
            return 1;
        }
        if (data.charAt(0) == '0') {
            return 0;
        }
        int result = numberOfPossibleWay(data, length - 1);
        if ((length >= 2) && Integer.parseInt(data.substring(0, 2)) <= 26) {
            System.out.println(Integer.parseInt(data.substring(0, 2)));
            result += numberOfPossibleWay(data, length - 2);
        }
        return result;
    }

    private static int[] moreCloseToSum(int[] array1, int[] array2, int target) {

        if (array1.length == array2.length) {
            Arrays.sort(array1);
            Arrays.sort(array2);
            int i = array1.length - 1;
            int j = 0;
            ArrayList<Integer> listi = new ArrayList<>();
            ArrayList<Integer> listj = new ArrayList<>();
            while ((i == 0) && (j == array2.length - 1)) {

                if ((array1[i] + array2[j]) <= target) {
                    j++;
                    listi.add(i);
                    listj.add(j);
                } else if ((array1[i] + array2[j]) > target) {
                    i--;
                    listi.add(i);
                    listj.add(j);
                }
            }

            return new int[]{array1[i], array2[j]};
        } else {
            return new int[]{-1};
        }
    }


    /**
     * point class to locating a point on graph
     */
    static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }

    /**
     * rectangle contructed  from two points
     */
    static class Rectangle {
        private Point Upper;
        private Point lower;

        Rectangle(Point lower, Point upper) {
            Upper = upper;
            this.lower = lower;
        }

        Point getUpper() {
            return Upper;
        }

        Point getLower() {
            return lower;
        }
    }


}
