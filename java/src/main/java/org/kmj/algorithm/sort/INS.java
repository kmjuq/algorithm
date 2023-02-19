package org.kmj.algorithm.sort;

/**
 * <p>
 * 插入排序
 * 从下标为1开始，然后往前进行比较，插入到比较对象的前或后。
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/17 23:46
 */
public class INS implements ISortTest {

    @Override
    public String taskName() {
        return "插入排序";
    }

    // 34626732
    public int[] sort(int[] unSortArr) {
        for (int i = 1; i < unSortArr.length; i++) {
            final int mark = unSortArr[i];
            int j = i - 1;
            while (j >= 0 && mark < unSortArr[j]) {
                unSortArr[j + 1] = unSortArr[j];
                j--;
            }
            unSortArr[j + 1] = mark;
        }
        return unSortArr;
    }


    public static void main(String[] args) {
        new INS().test();
    }

}
