package org.kmj.algorithm.datastruct.string;

/**
 * KMP 算法在字串重复元素较多时效率更高。
 */
public class KMP {

    private final int[] next;

    private final String pat;

    public KMP(String str) {
        this.pat = str;
        this.next = generateNext(str);
    }

    private int[] generateNext(String str) {
        int[] next = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {

        }
        return null;
    }

    public int search(String str){
        return -1;
    }

}
