package org.kmj.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zzz.ArraysTool;
import zzz.StopWatch;

import java.util.Arrays;

public interface ISortTest {

    Logger log = LoggerFactory.getLogger(ISortTest.class);
    StopWatch stopWatch = new StopWatch();

    default void test() {
        stopWatch.start(taskName());
        boolean taskSuccessFlag = true;
        for (int i = 0; i < 10; i++) {
            int[] ints = ArraysTool.generatorArray(15);
            int[] intscopy = Arrays.copyOf(ints, ints.length);
            log.info("原始数组:\t\t\t{}", ints);
            int[] sortInts = sort(ints);
            log.info("{} 排序数组:\t\t{}", taskName(),sortInts);
            // ints 经过 arrays.sort 排序，与手写排序后的 sortInts 数组进行比对，来验证算法正确性
            Arrays.sort(intscopy);
            log.info("Arrays.sort排序数组:\t{}",sortInts);
            boolean oneFlag = ArraysTool.equals(intscopy, sortInts);
            if (!oneFlag) taskSuccessFlag = false;
            log.info("是否相符：{}", oneFlag);
        }
        stopWatch.setTaskSuccessFlag(taskSuccessFlag);
        stopWatch.stop();
    }

    static void main(String[] args) {
        new BUB().test();
        new INS().test();
        new MER().test();
        new SEL().test();
        new QUI().test();
        new COU().test();
        new RAD().test();
        log.info(stopWatch.prettyPrint());
    }

    String taskName();

    int[] sort(int[] unSortInts);

}
