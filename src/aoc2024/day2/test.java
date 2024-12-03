package aoc2024.day2;

import java.util.ArrayList;
import java.util.List;

public class test {
    // Function to check if array is sorted (ascending or descending)
	public static boolean isSorted(List<Integer> list) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) ascending = false;
            if (list.get(i) > list.get(i - 1)) descending = false;
        }

        return ascending || descending;
    }

    // Function to check if ArrayList can be sorted by removing one element
    public static boolean canBeSortedByRemovingOne(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            List<Integer> modifiedList = new ArrayList<>(list); // Clone the list
            modifiedList.remove(i); // Remove the element at index i
            if (isSorted(modifiedList)) {
                return true;
            }
        }
        return false;
    }
    // Helper function to create a new array with one element removed
    public static int[] removeElement(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }
}
