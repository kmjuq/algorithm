package org.kmj.algorithm.datastruct.tree.base;

import org.kmj.algorithm.datastruct.tree.ITree;
import zzz.KNode;

import java.util.Objects;

public class SimpleBinaryTree implements ITree {

    private KNode root;

    @Override
    public ITree insert(Integer num) {
        KNode addNode = KNode.of(num);
        if (Objects.isNull(root)) {
            root = addNode;
        } else {
            KNode cur = root;

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
