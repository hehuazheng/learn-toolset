package com.hehz.aop.cglib;

import com.hehz.common.i.impl.Bike;

public class CglibDemo {

	public static void main(String[] args) {
		Bike bike = CglibProxyCreator.createProxy(new Bike());
		bike.showName();
	}

}
