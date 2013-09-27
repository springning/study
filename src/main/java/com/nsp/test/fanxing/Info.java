package com.nsp.test.fanxing;

public interface Info<T> {
	public T getVar();
	
	public <U> U getString();
}
