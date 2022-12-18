package com.leetcode.arrays;

import com.leetcode.utilities.FastReader;

/**
 * A sorted array is rotated at some unknown point, find the key element in it.
 * Following solution assumes that all elements are distinct.
 * Examples
 * <p>
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * key = 3
 * Output : Found at index 8
 * </p>
 * <p>
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * key = 30
 * Output : Not found
 * </p>
 * <p>
 * Input : arr[] = {30, 40, 50, 10, 20}
 * key = 10
 * Output : Found at index 3
 * </p>
 *
 * @author sudhir on 30/3/18
 */
public class SearchInSortedAndRotatedArray {

    public static int searchInSortedAndRotatedArray(int[] a, int target, int low, int high) {
        if (high < low) return -1;
        int mid = low + (high - low) / 2;
        if (target == a[mid]) return mid;
        if (a[low] <= a[mid]) {
            if (target >= a[low] && target <= a[mid]) {
                return searchInSortedAndRotatedArray(a, low, mid - 1, target);
            } else {
                return searchInSortedAndRotatedArray(a, mid + 1, high, target);
            }
        } else {
            if (target >= a[mid + 1] && target <= a[high]) {
                return searchInSortedAndRotatedArray(a, mid + 1, high, target);
            } else {
                return searchInSortedAndRotatedArray(a, low, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        for (int t = 0; t < T; t++) {
            int key = fr.nextInt();
            int n = fr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
            }
            int minEle = searchInSortedAndRotatedArray(arr, key, 0, n - 1);
            System.out.println(minEle != -1 ? "Key found at position: " + minEle : "Key not found");
        }
        fr.close();
    }
}
