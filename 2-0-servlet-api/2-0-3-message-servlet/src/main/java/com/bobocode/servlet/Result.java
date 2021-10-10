package com.bobocode.servlet;

public class Result {

  public static void main(String[] args) {
    String str = "qwer";
    getSubString(str);
  }

  private static void permutationLetter(String str) {
    String[] split = str.split("");
  }

  private static void getSubString(String str) {
    int n = str.length();
    int counter = 0;
    for (int i = 0; i <= n - 1; i++) {
      for (int j = i + 1; j <= n; j++) {
        counter++;
        System.out.println(str.substring(i, j));
      }
    }
    System.out.println(counter);
  }

  private static boolean isPalindrome(String str) {
    int n = str.length();
    for (int i = 0; i < n / 2; i++) {
      if (!(str.charAt(i) == str.charAt(n - i - 1))) {
        return false;
      }
    }
    return true;
  }
}
