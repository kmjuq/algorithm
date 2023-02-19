package org.kmj.algorithm.sort;

import cn.hutool.core.util.ArrayUtil;

/**
 * 基数排序
 * 有MSD和LSD两种方法实现：
 *      MSD是从高位数往低位数循环，用于位数较多的整数排序。
 *      LSD是从低位数往高位数循环，用于位数较少的整数排序。
 *
 * LSD 实现逻辑：
 *      1.只能用于计算整数。
 *      2.获取待排序数组中的个位数，统计每个个位数相同的数据的个数。
 *      3.将统计后的数据重新排列。
 *      4.重复2，3步骤。
 */
public class RAD implements ISortTest {
    @Override
    public String taskName() {
        return "基数排序";
    }

    @Override
    public int[] sort(int[] unSortInts) {
        int maxNum = ArrayUtil.max(unSortInts);
        final int maxDigit = calculateNumberOfDigits(maxNum);
        int digit = 1;
        while (digit <= maxDigit) {
            unSortInts = sort(unSortInts, digit);
            digit++;
        }
        return unSortInts;
    }

    private int[] sort(int[] unSortInts, int digit) {
        int[] bucket = new int[10];
        int[] result = new int[unSortInts.length];
        // 计算每个元素的桶索引。
        for (int unSortInt : unSortInts) {
            int bucketIndex = calculateNumberOfBucketDigits(unSortInt, digit);
            bucket[bucketIndex] += 1;
        }
        // 计算每个元素的相对位置。
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }
        // 重新排序。第一次没有意义，当循环到多次的时候，可以保证之前的排序顺序
        for (int i = unSortInts.length - 1; i >= 0; i--) {
            int bucketIndex = calculateNumberOfBucketDigits(unSortInts[i], digit);
            int resultIndex = bucket[bucketIndex];
            result[resultIndex - 1] = unSortInts[i];
            bucket[bucketIndex]--;
        }
        return result.clone();
    }

    static int calculateNumberOfBucketDigits(int number, int digit) {
        return ((number / ((int) Math.pow(10, digit - 1))) % 10);
    }

    static int calculateNumberOfDigits(int number) {
        return (int) Math.log10(number) + 1;
    }

    public static void main(String[] args) {
        new RAD().test();
    }
}
