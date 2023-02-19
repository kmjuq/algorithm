package org.kmj.algorithm.sort;

import cn.hutool.core.util.ArrayUtil;

/**
 * 计数排序
 * 计算数组A值范围，然后根据范围创建数组B，遍历数组A，然后将重复的值存在数组B相对应的索引下，数组A中重复的值会使数组B对应索引的数据加1
 *
 * 只能计算正整数的排序，如果要支持负整数需要特殊处理。
 * 数值范围不能过大，比如两个元素的数组[1,10^6],就算是很短的数组，申请的内存依旧很大，排序时间长。
 *
 * 当数组都是整数且容量不是很大并且序列比较集中时，计数排序是一个很有效的排序算法。
 */
public class COU implements ISortTest {

    @Override
    public String taskName() {
        return "计数排序";
    }

    @Override
    public int[] sort(int[] unSortInts) {
        // 3487 345678
        // 循环遍历最少一次，获取最大最小值,n
        int max = ArrayUtil.max(unSortInts);
        int min = ArrayUtil.min(unSortInts);
        // 创建临时数组并赋值，遍历一次，k
        int[] temp = new int[max - min + 1];
        for (int e : unSortInts) {
            temp[e - min] += 1;
        }
        int index = 0;
        // 遍历一次，n
        for (int i = 0; i < temp.length; i++) {
            int count = temp[i];
            for (int j = 0; j < count; j++) {
                unSortInts[index] = i+min;
                index++;
            }
        }
        return unSortInts;
    }

    public static void main(String[] args) {
        new COU().test();
    }


}