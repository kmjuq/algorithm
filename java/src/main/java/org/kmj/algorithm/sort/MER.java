package org.kmj.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 将大问题化为小问题，然后合并。
 * 合并是对两个数组进行排序。
 */
public class MER implements ISortTest {

    @Override
    public String taskName() {
        return "归并排序";
    }

    // 34626732
    public int[] sort(int[] unSortArr) {
        // 递归方式
        return RSort(unSortArr);
    }

    public static int[] RSort(int[] unSortArr){
        final int arrLength = unSortArr.length;
        if (arrLength <= 1) {
            return unSortArr;
        } else {
            final int mid = arrLength / 2;
            final int[] left = Arrays.copyOfRange(unSortArr, 0, mid);
            final int[] right = Arrays.copyOfRange(unSortArr, mid, arrLength);
            final int[] sortLeft = RSort(left);
            final int[] sortRight = RSort(right);
            final int[] ints = new int[sortLeft.length + sortRight.length];

            int leftIndex = 0;
            int rightIndex = 0;
            int index = 0;
            while (index < ints.length) {
                /**
                 * 处理边界条件，
                 * 数组一为： 24，29
                 * 数组二为： 1，33，55
                 * 当为这种情况时，数组一会优先合并完，那么数组二可以直接合并。
                 */
                if (leftIndex == sortLeft.length || rightIndex == sortRight.length) {
                    if (leftIndex == sortLeft.length) {
                        System.arraycopy(sortRight, rightIndex, ints, index, sortRight.length - rightIndex);
                        return ints;
                    } else {
                        System.arraycopy(sortLeft, leftIndex, ints, index, sortLeft.length - leftIndex);
                        return ints;
                    }
                }

                // 循环比较两个数组的各个数字大小
                if (sortLeft[leftIndex] < sortRight[rightIndex]) {
                    ints[index] = sortLeft[leftIndex];
                    leftIndex++;
                } else {
                    ints[index] = sortRight[rightIndex];
                    rightIndex++;
                }
                index = leftIndex + rightIndex;
            }
            return ints;
        }
    }


    public static void main(String[] args) {
        new MER().test();
    }

}
