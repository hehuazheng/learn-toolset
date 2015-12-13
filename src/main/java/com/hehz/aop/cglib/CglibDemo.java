package com.hehz.aop.cglib;

import java.lang.reflect.Method;

import com.hehz.common.i.impl.Bike;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDemo {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Bike.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method m, Object[] args,
					MethodProxy proxy) throws Throwable {
				System.out.println("before invoke: " + m.getName());
				Object result = proxy.invokeSuper(obj, args);
				System.out.println("after invoke: " + m.getName());
				return result;
			}
		});
		Bike bike = (Bike) enhancer.create();
		bike.showName();
	}

}
