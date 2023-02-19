package org.kmj.algorithm.datastruct.linear;

import zzz.KNode;

public interface IList {

    int indexOf(KNode node);

    KNode get(int index);

    void set(KNode node, int index);

    void add(KNode node, int index);

    void remove(int index);

    int size();

    void clear();

}
