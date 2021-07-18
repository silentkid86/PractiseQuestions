package com.silentkid.practice;

import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        A.sort(Integer::compare);
        int middle = A.size() / 2;
        return A.get(middle);

    }
}
