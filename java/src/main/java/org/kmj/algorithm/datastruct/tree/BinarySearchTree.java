package org.kmj.algorithm.datastruct.tree;

import zzz.KNode;

import java.util.Objects;

public class BinarySearchTree implements ITree {

    private KNode root;

	@Override
    public ITree insert(Integer num) {
        KNode node = KNode.of(num);
        if (Objects.isNull(root)) {
            root = node;
        } else {
            KNode cur = root;
            if (node.value() > cur.value()) {
                       
            } else if (node.value() < root.value()) {

            } else {
                throw new IllegalArgumentException("无法插入，已经存在相同的数值");
            }
        }
        return this;
    }

    @Override
    public boolean remove(Integer num) {
        return false;
    }

    @Override
    public KNode search(Integer num) {
        return null;
    }
}
