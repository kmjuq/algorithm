package org.kmj.algorithm;

import cn.hutool.core.date.StopWatch;

/**
 * <p>
 * 牛顿迭代法
 * </p>
 *
 * @author mengjian.ke@hand-china.com
 * 2019/7/25 11:20
 */
public class NewtonMethod {

    public static void main(String[] args) {
        final StopWatch sw = new StopWatch();
        sw.start();
        System.out.println(sqrt(2));
        sw.stop();
        sw.start();
        System.out.println(Math.sqrt(2));
        sw.stop();
        System.out.println(sw.prettyPrint());
    }

    private static Double sqrt(int x) {
        if (x == 0) return 0D;
        double last = 0;
        double res = 1;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return res;
    }

}
