package com.hhz.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

public class SuppliersDemo {
    private static final Supplier<SuppliersDemo> SINGLETON_SUPPLIER = Suppliers
            .memoize(new Supplier<SuppliersDemo>() {
                public SuppliersDemo get() {
                    return new SuppliersDemo();
                }
            });

    private static final Supplier<SuppliersDemo> SINGLETON_SUPPLIER_WITH_EXPIRE_TIME = Suppliers
            .memoizeWithExpiration(new Supplier<SuppliersDemo>() {
                public SuppliersDemo get() {
                    return new SuppliersDemo();
                }
            }, 2, TimeUnit.SECONDS);

    public static SuppliersDemo getInstance() {
        return SINGLETON_SUPPLIER.get();
    }

    public static SuppliersDemo getExpiredInstance() {
        return SINGLETON_SUPPLIER_WITH_EXPIRE_TIME.get();
    }

    public static void main(String[] args) {
        SuppliersDemo sd1 = getInstance();
        SuppliersDemo sd2 = getInstance();
        System.out.println(sd1 == sd2);// true
        SuppliersDemo sd3 = getExpiredInstance();
        SuppliersDemo sd4 = getExpiredInstance();
        System.out.println(sd3 == sd4);// true
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SuppliersDemo sd5 = getExpiredInstance();
        System.out.println(sd3 == sd5); // false
    }

}
