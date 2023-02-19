package org.kmj.algorithm.datastruct.graph;

import cn.hutool.core.util.NumberUtil;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Arrays;

@Getter
@Accessors(chain = true)
public class Matrix implements Graph {

    private Integer[][] content;

    public Matrix(Integer[][] content){
        this.content = content;
    }

    /**
     * 必须可以求取平方根
     * 1 4 9 16 25 等
     */
    public static Matrix of(Integer... ints){
        int size = (int) NumberUtil.sqrt(ints.length);
        Integer[][] content = new Integer[size][size];
        for (int i = 0; i < ints.length; i++) {
            int indexi = i % size;
            int indexj = i / size;
            content[indexj][indexi] = ints[i];
        }
        return new Matrix(content);
    }

    @Override
    public String toString() {
        StringBuilder log = new StringBuilder("\n");
        for (Integer[] arr : content) {
            Integer[] integers = Arrays.stream(arr).toArray(Integer[]::new);
            log.append(Arrays.toString(integers)).append("\n");
        }
        return log.toString();
    }
}
