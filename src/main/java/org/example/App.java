package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static Integer[] genArr() {
        Random rand = new Random();
        Integer[] ar1 = new Integer[10000];
        for (int i = 0; i < ar1.length; i++) {
            ar1[i] = rand.nextInt(1000);
        }
        return ar1;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private static void swapElements(Integer[] arr, int i, int minElementIndex) {
        Integer buf = arr[i];
        arr[i] = arr[minElementIndex];
        arr[minElementIndex] = buf;
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        long start;
        Integer[] ar1 = genArr();
        Integer[] ar2 = ar1.clone();
        Integer[] ar3 = ar1.clone();
        Integer[] ar4 = ar1.clone();
        start = System.currentTimeMillis();
        Arrays.sort(ar1);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        sortBubble(ar2);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        sortSelection(ar3);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        sortInsertion(ar4);
        System.out.println(System.currentTimeMillis() - start);
    }
}
