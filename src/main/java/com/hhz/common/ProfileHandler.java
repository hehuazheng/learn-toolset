package com.hhz.common;

import java.lang.reflect.Method;

import com.hhz.annotation.Profile;

public class ProfileHandler extends AnnotationHandler {

	@Override
	public void internalHandle(Method method) {
		if (method.isAnnotationPresent(Profile.class)) {
			System.out.println("profile exist");
		}
	}

}
