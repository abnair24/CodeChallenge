package com.abn.dsalgos.algo.slidingWindo;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MaxWindowSubstringTest {

    MaxWindowSubstring maxWindowSubstring = new MaxWindowSubstring();

    @Test
    public void maxWindowTest() {

        String str = "ABCDAFGAADEFGHBC";
        String pattern = "AABC";
        Assertions.assertThat(maxWindowSubstring.maxWindow(str, pattern)).isEqualTo("CDAFGAADEFGHB");
    }
}
