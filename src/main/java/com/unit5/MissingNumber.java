package com.unit5;

public class MissingNumber {
    public int missingNum(int[] nums, int maxNum) {

        int total = 0;
        int actual = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            actual += i + 1;
        }

        if (nums.length == maxNum - 1)
            actual += maxNum;

        return Math.abs(actual - total);
    }
}
