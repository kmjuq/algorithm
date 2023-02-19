package org.kmj.algorithm.sort;

import cn.hutool.core.util.ArrayUtil;

/**
 * 快速排序,基于冒泡。
 * 从数组中选择一个基数（任意方式），然后将大于基数和小于基数的数重新排列，然后将基数左右两边分成两个数组，重新进行该操作。
 * 升序：
 *      将大于基数的数交换到右边，将小于基数的数交换到左边；
 */
public class QUI implements ISortTest {
    @Override
    public String taskName() {
        return "快速排序";
    }

    @Override
    public int[] sort(int[] unSortInts) {
        Rsort_(unSortInts, 0, unSortInts.length - 1);
        return unSortInts;
    }

    public void Rsort_(int[] unSortInts, int start, int end) {
        int tStart = start;
        int tEnd = end;
        if (tEnd - tStart > 0) {
            int mark = unSortInts[start];
            while (tStart != tEnd) {
                while (tStart < tEnd && mark > unSortInts[tStart]) {
                    tStart++;
                }
                while (tStart < tEnd && mark < unSortInts[tEnd]) {
                    tEnd--;
                }
                if (tEnd > tStart) {
                    if (unSortInts[tEnd] == unSortInts[tStart]) {
                        tEnd--;
                    } else {
                        ArrayUtil.swap(unSortInts, tStart, tEnd);
                    }
                }
            }
            int indexMark = tEnd;
            Rsort_(unSortInts, start, indexMark - 1);
            Rsort_(unSortInts, indexMark + 1, end);
        }
    }

    public void Rsort(int[] unSortInts, int start, int end) {
        if (end - start > 0) {
            int index = partition(unSortInts, start, end);
            Rsort(unSortInts, start, index);
            Rsort(unSortInts, index + 1, end);
        }
    }

    public int partition(int[] unSortInts, int start, int end) {
        int pivot = unSortInts[start];
        int i = start - 1, j = end + 1;
        while (true) {
            do {
                i++;
            } while (unSortInts[i] < pivot);
            do {
                j--;
            } while (unSortInts[j] > pivot);
            if (i < j) ArrayUtil.swap(unSortInts, i, j);
            else return j;
        }
    }

    public static void main(String[] args) {
        new QUI().test();
    }
}
