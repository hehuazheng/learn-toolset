package com.hhz.guava;

import com.google.common.base.MoreObjects;

public class ObjectsDemo {

    static class P {
        String name;
        String addr;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).omitNullValues()
                    .add("name", name).add("addr", addr).toString();
        }
    }

    public static void main(String[] args) {
        P p = new P();
        p.name = "first name";
        System.out.println(p.toString()); // P{name=first name}

        p.addr = "pj city";
        System.out.println(p.toString()); // P{name=first name, addr=pj city}
    }

}
