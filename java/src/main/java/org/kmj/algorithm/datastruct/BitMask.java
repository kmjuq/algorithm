package org.kmj.algorithm.datastruct;

import lombok.extern.slf4j.Slf4j;

/**
 * 开关项从 0 开始；
 */
@Slf4j
public class BitMask {

    private int intSwitch;

    public BitMask(int initSwitch){
        intSwitch = initSwitch;
    }

    public void open(int i){
        intSwitch = intSwitch | (1 << i);
    }

    public boolean isOpen(int i){
        return (intSwitch & (1 << i)) != 0;
    }

    public void close(int i){
        intSwitch = intSwitch & ~(1 << i);
    }

    public void reverse(int i){
        intSwitch = intSwitch ^ (1 << i);
    }

    @Override
    public String toString() {
        return String.format("当前位掩码位:[%s]",Integer.toBinaryString(this.intSwitch));
    }

    public static void main(String[] args) {
        final BitMask bitMask = new BitMask(0b10101010_10111011_11001100_00000001);
        bitMask.open(1);
        log.info("{}",bitMask);
        bitMask.close(0);
        log.info("{}",bitMask);
        log.info("{}",bitMask.isOpen(1));
        bitMask.reverse(3);
        log.info("{}",bitMask);
    }
}
