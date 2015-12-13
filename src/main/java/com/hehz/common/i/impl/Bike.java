package com.hehz.common.i.impl;

import com.hehz.annotation.Profile;
import com.hehz.common.i.IAutomobile;

@Profile
public class Bike implements IAutomobile {
	private String name = "bike";

	@Override
	@Profile
	public String getName() {
		return name;
	}

	@Override
	public void showName() {
		System.out.println("automobile : " + name);
	}
}
