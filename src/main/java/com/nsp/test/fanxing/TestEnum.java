package com.nsp.test.fanxing;

@SuppressWarnings("unused")
public enum TestEnum {
	
	TEST_ONE("hehe", 1),TEST_TWO("nsp", 2),TEST_THREE ("wyq", 3);
	
	
	private String name;
	private Integer score;
	
	private TestEnum(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
}
