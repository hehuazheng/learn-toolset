package com.hhz.common;

import java.lang.reflect.Method;


public abstract class AnnotationHandler {
	public abstract void internalHandle(Method method);
}
