package com.abn.dsalgos.ds.stack;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static final String DISPLAY_CODE = "1234";

    public static void main(String[] args) {

        List<String[]> accum = new LinkedList<>();

        accum.add(new String[] { DISPLAY_CODE + "_1_0", null    } );
        accum.add(new String[] { DISPLAY_CODE,          "fr_FR" } );
        accum.add(new String[] { DISPLAY_CODE,          "en_US" } );

        for (String[] params : accum) {


        }
    }

    public static void methodA(String displayCode, String locale) {

    }


}
