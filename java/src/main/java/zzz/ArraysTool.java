package zzz;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/17 19:03
 */
public class ArraysTool {

    private static final int MIN = 1;
    private static final int MAX = 100;

    public static boolean equals(int[] i1, int[] i2) {
        boolean flag = true;
        if (i1.length != i2.length) {
            return false;
        }
        for (int i = 0; i < i1.length; i++) {
            if (i1[i] != i2[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // [6, 36, 81, 44, 12, 7, 43, 49, 2, 92, 18, 15, 28, 96, 31]
    public static int[] generatorArray(String arrStr) {
        String[] numStrArr = arrStr.replaceAll("[\\[|\\]|\\s]", "").split(",");
        return Arrays.stream(numStrArr).mapToInt(Integer::valueOf).toArray();
    }

    public static int[] generatorArray(int length) {
        return generatorArray(MIN, MAX, length, false);
    }

    public static int[] generatorSortedArray(int length) {
        return generatorSortedArray(MIN, MAX, length);
    }

    public static int[] generatorSortedArray(int min, int max, int length) {
        return generatorArray(min, max, length, true);
    }

    public static int[] generatorArray(int min, int max, int length) {
        return generatorArray(min, max, length, false);
    }

    public static int[] generatorArray(int min, int max, int length, boolean sorted) {
        final IntStream is = IntStream.generate(() -> RandomUtil.randomInt(min, max)).limit(length);
        return sorted ? is.sorted().toArray() : is.toArray();
    }

    public static KNode[] generatorNodeArray(int length) {
        return generatorNodeArray(MIN, MAX, length);
    }

    public static KNode[] generatorSortedNodeArray(int length) {
        return generatorSortedNodeArray(MIN, MAX, length);
    }

    public static KNode[] generatorSortedNodeArray(int min, int max, int length) {
        return generatorNodeArray(min, max, length, true);
    }

    public static KNode[] generatorNodeArray(int min, int max, int length) {
        return generatorNodeArray(min, max, length, false);
    }

    public static KNode[] generatorNodeArray(int min, int max, int length, boolean sorted) {
        final Stream<KNode> nodeStream = Stream.generate(() -> KNode.of(RandomUtil.randomInt(min, max))).limit(length);
        return sorted ? nodeStream.sorted().toArray(KNode[]::new) : nodeStream.toArray(KNode[]::new);
    }

}
