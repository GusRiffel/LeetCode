package com.GusRiffel.arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class runningSumOf1dArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(runningSum(nums));
    }

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = nums[i];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }

        return result;
    }
}
