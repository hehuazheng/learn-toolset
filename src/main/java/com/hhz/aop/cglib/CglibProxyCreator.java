package com.hhz.aop.cglib;

import java.lang.reflect.Method;

import com.hhz.common.ProfileHandler;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyCreator {
	@SuppressWarnings("unchecked")
	public static final <T> T createProxy(Object object) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method m, Object[] args,
					MethodProxy proxy) throws Throwable {
				System.out.println("before invoke: " + m.getName());
				new ProfileHandler().internalHandle(m);
				Object result = proxy.invokeSuper(obj, args);
				System.out.println("after invoke: " + m.getName());
				return result;
			}
		});
		return (T) enhancer.create();
	}
}
