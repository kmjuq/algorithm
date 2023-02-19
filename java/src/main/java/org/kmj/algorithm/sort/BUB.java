package org.kmj.algorithm.sort;

import cn.hutool.core.util.ArrayUtil;

/**
 * <p>
 * 冒泡排序
 * 相邻元素比较，将最大数移动到最右端，重复(数组长度-1)次。
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/17 19:03
 */
public class BUB implements ISortTest {

    @Override
    public String taskName() {
        return "冒泡排序";
    }

    public int[] sort(int[] unSortInts) {
        for (int i = 1; i < unSortInts.length; i++) {
            for (int j = 0; j < unSortInts.length - i; j++) {
                if (unSortInts[j] > unSortInts[j + 1]) {
                    ArrayUtil.swap(unSortInts, j, j + 1);
                }
            }
        }
        return unSortInts;
    }

    public static void main(String[] args) {
        new BUB().test();
    }

}
