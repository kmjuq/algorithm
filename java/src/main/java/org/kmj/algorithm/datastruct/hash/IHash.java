package org.kmj.algorithm.datastruct.hash;

import zzz.KNode;

public interface IHash {

    KNode search(KNode node);

    void insert(KNode node);

    void remove(KNode node);

    default int hash(Object key,int c){
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        return (c - 1) & hash;
    }

    void resize();

    void log();

    int size();

}
