package org.kmj.algorithm.datastruct.heap;

import zzz.KNode;

/**
 * 二叉堆是基于完全二叉树,用顺序数组实现
 */
public interface IHeap {

    void create(KNode[] arr);

    void insert(KNode node);

    KNode extractMax();

}
