package cn.tiankafei.base.juc.reference;

import java.lang.ref.WeakReference;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class WeakReferenceTest {

    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());


        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }

}
