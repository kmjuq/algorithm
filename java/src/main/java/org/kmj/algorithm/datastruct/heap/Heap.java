package org.kmj.algorithm.datastruct.heap;

import zzz.KNode;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Heap implements IHeap {

    private KNode[] eles;
    private int count = 0;

    public Heap(KNode[] arr) {
        create(arr);
    }

    @Override
    public void create(KNode[] arr) {
        int capacity = tableSizeFor(arr.length);
        eles = new KNode[capacity];

        for (KNode kNode : arr) {
            insert(kNode);
        }
    }

    @Override
    public void insert(KNode node) {
        if (count == eles.length) {
            grow();
        }
        eles[count] = node;
        count++;

        up();
    }

    @Override
    public KNode extractMax() {
        if (count == 0) return null;
        KNode result = eles[0];
        eles[0] = eles[count - 1];
        eles[count - 1] = null;
        count--;

        down();

        return result;
    }

    @Override
    public String toString() {
        return Arrays.stream(eles).filter(Objects::nonNull).map(KNode::value).map(String::valueOf).collect(Collectors.joining(","));
    }

    private void up() {
        for (int i = count - 1; i != 0; i = parent(i)) {
            compareAndSwapUp(parent(i), i);
        }
    }

    private void down() {
        for (int curI = 0; curI < noLeafNodeCount(); curI++) {
            int leftI = leftChild(curI);
            int rightI = rightChild(curI);

            compareAndSwapDown(curI, leftI);
            compareAndSwapDown(curI, rightI);
        }
    }

    private int noLeafNodeCount() {
        return (count + 1) / 2;
    }

    private int leftChild(int parent) {
        int leftI = 2 * parent + 1;
        return leftI > count ? -1 : leftI;
    }

    private int rightChild(int parent) {
        int rightI = 2 * parent + 2;
        return rightI > count ? -1 : rightI;
    }

    private int parent(int child) {
        return (child - 1) / 2;
    }

    private void swap(int source, int target) {
        KNode tmp = eles[target];
        eles[target] = eles[source];
        eles[source] = tmp;
    }

    private void compareAndSwapUp(int parentI, int curI) {
        KNode ele1 = eles[parentI];
        KNode ele2 = eles[curI];
        if (ele2.value() > ele1.value()) {
            swap(parentI, curI);
        }
    }

    private void compareAndSwapDown(int curI, int childI) {
        final int cur = eles[curI].value();
        // 最后一个父节点可能只有左叶子节点
        final int child = Optional.ofNullable(eles[childI]).orElse(KNode.of(Integer.MIN_VALUE)).value();
        if (child > cur) {
            swap(childI, curI);
        }
    }

    private void grow() {
        KNode[] kNodes = new KNode[tableSizeFor(eles.length)];
        System.arraycopy(eles, 0, kNodes, 0, eles.length);
        eles = kNodes;
    }

    private static int tableSizeFor(int cap) {
        return -1 >>> (Integer.numberOfLeadingZeros(cap) - 1);
    }
}
