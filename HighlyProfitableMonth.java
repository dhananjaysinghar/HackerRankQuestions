package com.test.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighlyProfitableMonth {

    public static void main(String[] args) {
        int month = countHighlyProfitableMonths(Arrays.asList(5, 3, 5, 7, 8), 3);
        System.out.println(month); // 2
    }

    private static int countHighlyProfitableMonths(List<Integer> stockPrices, int k) {
        int n = stockPrices.size();
        int count = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i + 1 < n; i++) {
            if (stockPrices.get(i + 1) > stockPrices.get(i)) {
                count += 1;
            } else {
                temp.add(count);
                count = 1;
            }
        }
        temp.add(count);
        int ans = 0;
        for (int x : temp) {
            if (x >= k) {
                ans += (x - k + 1);
            }
        }
        return ans;
    }
}
