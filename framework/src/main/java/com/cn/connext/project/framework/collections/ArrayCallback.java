package com.cn.connext.project.framework.collections;

import java.util.ArrayList;

@FunctionalInterface
public interface ArrayCallback<E> {
    void process(ArrayList<E> arrayList);
}
