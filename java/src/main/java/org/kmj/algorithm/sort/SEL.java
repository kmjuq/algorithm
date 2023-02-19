package org.kmj.algorithm.sort;

import cn.hutool.core.util.ArrayUtil;

/**
 * <p>
 * 选择排序
 * 指定下标为0的为之后所有数据的逻辑最小值，然后与所有数据比较，将实际最小值交换到逻辑最小值的下标上。
 * 然后指定下标为1的为之后所有数据的逻辑最小值，重复上述过程。
 * </p>
 *
 * @author kemengjian@126.com 2020/8/17 20:56
 */
public class SEL implements ISortTest {

    @Override
    public String taskName() {
        return "选择排序";
    }

    public int[] sort(int[] unSortArr) {
        for (int i = 1; i < unSortArr.length; i++) {
            int minIndex = i - 1;
            for (int j = i; j < unSortArr.length; j++) {
                if (unSortArr[minIndex] > unSortArr[j]) {
                    ArrayUtil.swap(unSortArr,minIndex,j);
                }
            }
        }
        return unSortArr;
    }

    public int[] sort1(int[] unSortArr) {
        for (int i = 1; i < unSortArr.length; i++) {
            int minIndex = i - 1;
            for (int j = i; j < unSortArr.length; j++) {
                if (unSortArr[minIndex] > unSortArr[j]) {
                    minIndex = j;
                }
            }
            if (i - 1 != minIndex) {
                ArrayUtil.swap(unSortArr, i - 1, minIndex);
            }
        }
        return unSortArr;
    }



    public static void main(String[] args) {
        new SEL().test();
    }
}
