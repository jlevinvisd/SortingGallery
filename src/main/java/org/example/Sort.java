package org.example;

public class Sort {

    /**
     * Should take in an array of two ints and changes it
     * to array with the numbers from smallest to largest.
     *
     * @param nums
     */
    public static void sortTwo(int[] nums) {
        if (nums[0] > nums[1]) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
        }

    }

    public static void mergeSort(int[] inputArray) {
        /** prevent from spliting if it only has one thing*/
        if (inputArray.length < 2) {
            return;
        }
        /** create int w/ the length of the first array */
        int midLength = inputArray.length / 2;

        /** create a left array */
        int[] array1 = new int[midLength];

        /** create a right array */
        int[] array2 = new int[inputArray.length - midLength];

        /** put left part of inputArray into the left array */
        for (int i = 0; i < midLength; i++) {
            array1[i] = inputArray[i];
        }
        /** put right part of inputArray into the right array */
        for (int i = midLength; i < inputArray.length; i++) {
            array2[i - midLength] = inputArray[i];
        }
        mergeSort(array1);
        mergeSort(array2);
        merge(inputArray, array1, array2);
    }

    /**
     * This function should take the two arrays and merge them into the inputArray.
     * The result should be in order from smallest to largest, with all the numbers from both arrays included.
     *
     * @param inputArray - The original array that will come back changed.
     * @param array1     - A sorted list of numbers that is the size of half the length of the inputArray
     * @param array2     - A sorted list of numbers that is the size of half the length of the inputArray
     */
    public static void merge(int[] inputArray, int[] array1, int[] array2) {
        /** add the value with the lower value to the array */
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                inputArray[k] = array1[i];
                i++;
            } else {
                inputArray[k] = array2[j];
                j++;
            }
            k++;
        }
        while (array1.length > i) {
            inputArray[k] = array1[i];
            i++;
            k++;
        }
        while (array2.length > j) {
            inputArray[k] = array2[j];
            j++;
            k++;
        }
    }
}