package com;

import java.util.Arrays;

public class Main {

  private static int[] arr = {4, 2, 8, 3, 5, 6, 3, 123, 321, 1};

  public static void main(String[] args) {
    System.out.println(Arrays.toString(arr));
    insertSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void insertSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int j = i - 1;
      int current = arr[i];
      while (j >= 0 && arr[j] < current) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = current;
    }
  }
}
