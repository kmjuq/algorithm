package org.kmj.algorithm;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

public class SnowFlakeWorker {

    /**
     * 起始的时间戳:这个时间戳自己随意获取，比如自己代码的时间戳
     */
    private final static long START_STMP = 1543903501000L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 5;  //机器标识占用的位数
    private final static long DATACENTER_BIT = 5;//数据中心占用的位数

    /**
     * 每一部分的最大值：先进行左移运算，再同-1进行异或运算；异或：相同位置相同结果为0，不同结果为1
     */
    /**
     * 用位运算计算出最大支持的数据中心数量：31
     */
    private final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);

    /**
     * 用位运算计算出最大支持的机器数量：31
     */
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);

    /**
     * 用位运算计算出12位能存储的最大正整数：4095
     */
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */

    /**
     * 机器标志较序列号的偏移量
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;

    /**
     * 数据中心较机器标志的偏移量
     */
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;

    /**
     * 时间戳较数据中心的偏移量
     */
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private static long getNewstmp() {
        return System.currentTimeMillis();
    }

    /**
     * study -----------------------------------------------------------------------------------------------------------
     */

    /**
     * points ----------------------------------------------------------------------------------------------------------
     * 原码,反码,补码
     * 正数的反码是其本身,负数的反码是在其原码的基础上,符号位不变,其余各位取反
     * 正数的补码是其本身,负数的补码是反码加1
     * [+1] = [00000001]原 = [00000001]反 = [00000001]补
     * [-1] = [10000001]原 = [11111110]反 = [11111111]补
     */

    @Test
    public void demo1() {
        // ^ 是异或运算符 相同为 0 不同为 1
        // -1L ^ (-1L << 5)) 相当于 ~(-1L << 5))
        // ~(-1L << n)) 运算方式 获取n位数最大表示数
        System.out.println("-1 在计算机的二进制表示: " + Long.toBinaryString(-1L));
        System.out.println("-1 左移5位: " + Long.toBinaryString(-1L << 5));
        System.out.println("5位二进制最大表示数: " + Long.toBinaryString(~(-1L << 5)));
    }

    @Test
    public void demo2() {
        // 逻辑与运算 相同遇0得0
        System.out.println("2 在计算机的二进制表示: " + pstvNmbrBinaryString(2L));
        System.out.println("4 在计算机的二进制表示: " + pstvNmbrBinaryString(4L));
        System.out.println("5 在计算机的二进制表示: " + pstvNmbrBinaryString(5L));
        System.out.println(2 & 4);
        System.out.println(5 & 4);
    }

    @Test
    public void demo4() {
        long x = (getNewstmp() - START_STMP) << TIMESTMP_LEFT;
        long y = 31L << DATACENTER_LEFT;
        long z = 31L << MACHINE_LEFT;
        System.out.println(pstvNmbrBinaryString(x));
        System.out.println(pstvNmbrBinaryString(y));
        System.out.println(pstvNmbrBinaryString(z));
        System.out.println(x | y | z);
        System.out.println(pstvNmbrBinaryString(x | y | z));

    }

    private String pstvNmbrBinaryString(Long number) {
        String binaryString = Long.toBinaryString(number);
        return StrUtil.fillBefore(binaryString, '0', 64);
    }

    @Test
    public void demo3() {
        System.out.println(pstvNmbrBinaryString(2L));
    }
}