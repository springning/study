package com.nsp.test.fanxing;

import java.util.List;

public class InfoImpl implements Info<String> {

	public String getVar() {
		return null;
	}

	public <U> U getString() {
		return (U)"hello";
	}
	
	public static void main(String[] args) {
		InfoImpl impl = new InfoImpl();
		List<String> test = (List<String>)impl.getString();
	}

}
