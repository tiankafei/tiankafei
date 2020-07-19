package org.tiankafei.base.juc.reference;

import java.io.IOException;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ObjectTest {

    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc(); //DisableExplicitGC

        System.in.read();
    }

}
