package com.test.controller;

/**
 * Java program that implements the algorithm to find the next alphabetically greater permutation of a given word,
 * or return "no answer" if there is no such permutation
 */
public class NextPermutation {
    public static String nextPermutation(String word) {
        char[] chars = word.toCharArray();

        // Find the first character from the right that is smaller than the one to its right
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i == -1) {
            // No such permutation exists
            return "no answer";
        }

        // Find the smallest character to the right of i that is greater than chars[i]
        int j = chars.length - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        // Swap chars[i] and chars[j]
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        // Reverse the portion of the word to the right of i
        reverse(chars, i + 1, chars.length - 1);

        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String word = "abcd";
        String result = nextPermutation(word);
        System.out.println(result); // Output: "abdc"
    }
}