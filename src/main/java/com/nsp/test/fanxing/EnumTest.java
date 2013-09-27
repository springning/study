package com.nsp.test.fanxing;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;

import org.junit.Test;

public class EnumTest {
	
	
	@Test
	public void testValueof() {
		System.out.println(TestEnum.TEST_ONE.name());
		System.out.println(TestEnum.TEST_ONE.ordinal());
		
		System.out.println("***********************************");
		System.out.println(TestEnum.TEST_TWO.name());
		System.out.println(TestEnum.TEST_TWO.ordinal());
		
		System.out.println(TestEnum.values());
		
		System.out.println("*************************************");
		for (TestEnum testEnum : TestEnum.values()) {
			System.out.println(testEnum.name());
		}
	}
	
	
	@Test
	public void testState() {
		for (State state : State.values()) {
			System.out.println(state.name());
		}
		
		State switchState = State.OFF;
		
		//switch和enum的结合使用
		switch (switchState) {
		case ON:
			System.out.println("on");
			break;
		case OFF:
			System.out.println("off");
			break;
		default:
			break;
		}
		
		//EnumSet的使用
		EnumSet<State> stateSet = EnumSet.allOf(State.class);
		for (State state : stateSet) {
			System.out.println(state);
		}
		
		EnumMap<State, String> enumMap = new EnumMap<State, String>(State.class);
		enumMap.put(State.ON, "is on");
		enumMap.put(State.OFF, "is off");
		for (State state : State.values()) {
			System.out.println(state.name() + ":" + enumMap.get(state));
		}
	}
}
