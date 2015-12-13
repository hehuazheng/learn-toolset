package com.hehz.common.i.impl;

import com.hehz.common.i.IAutomobile;

public class Bike implements IAutomobile {
	private String name = "bike";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void showName() {
		System.out.println("automobile : " + name);
	}
}
