package com.oneclick.productservice.concurrent.leetcode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] nums = {1, 2, 3, 4};
        int target = 2;

        int result = searchInsert(nums, target);
        System.out.println("El indice de insercion es" + result);
    }

    public static int searchInsert(int[] nums, int target) {
        int inicio = 0;
        int fin = nums.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (nums[medio] == target) {
                return medio;
            }
            if (nums[medio] < target) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return inicio;
    }


}
