package org.kmj.algorithm.datastruct.tree;

import zzz.KNode;

public interface ITree {

    ITree insert(Integer num);

    boolean remove(Integer num);

    KNode search(Integer num);
}
