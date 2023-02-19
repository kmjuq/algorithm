package org.kmj.algorithm;

/**
 * 递归遍历二维数组
 */
public class RecursionTraversalTwoDimensionalArrays {

    public static void main(String[] args) {
        int[][] arrays = new int[][]{{2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
        recursion(arrays, 0, 0);
    }

    private static void recursion(int[][] arr, int i, int j) {
        if (i < arr.length) {
            if (j < arr[i].length) {
                System.out.println(arr[i][j]);
                recursion(arr, i, ++j);
            } else {
                j = 0;
                recursion(arr, ++i, j);
            }
        }
    }

}
