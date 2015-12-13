package com.hehz.aop.cglib;

import org.junit.Test;

import com.hehz.common.i.impl.Bike;

public class CglibProxyCreatorTest {

	@Test
	public void testCreateProxy() {
		Bike bike = new Bike();
		Bike proxy = CglibProxyCreator.createProxy(bike);
		System.out.println(proxy.getName());
	}

}
