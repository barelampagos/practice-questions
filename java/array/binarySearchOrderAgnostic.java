/**
Problem Statement #
Given a sorted array of numbers, find if a given number ‘key’ is present in the array. Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.

Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

Example 1:

Input: [4, 6, 10], key = 10
Output: 2
 */
class BinarySearch {

  public static int search(int[] arr, int key) {
    // Identify if ASC or DESC
    int firstNum = arr[0];
    int lastNum = arr[arr.length - 1];
    boolean isAsc = firstNum < lastNum;

    int start = 0;
    int end = arr.length - 1;
    int middle = 0;

    // Binary search based on flag
    while (start <= end) {
      middle = start + (end - start) / 2;
      int curr = arr[middle];

      if (curr == key) {
        return middle;
      } else if (curr > key) {
        if (isAsc) {
          end = middle - 1;
        } else {
          start = middle + 1;
        }
      } else if (curr < key) {
        if (isAsc) {
          start = middle + 1;
        } else {
          end = middle - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
  }
}