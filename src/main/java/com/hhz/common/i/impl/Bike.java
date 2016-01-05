package com.hhz.common.i.impl;

import com.hhz.annotation.Profile;
import com.hhz.common.i.IAutomobile;

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
