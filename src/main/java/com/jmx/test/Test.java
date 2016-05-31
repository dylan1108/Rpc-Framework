package com.jmx.test;

public class Test implements TestMBean {
	private String name="dylan";
	@Override
	public void printHelloWorld() {
		System.out.println(name+" Say Hello World...");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}
	
}
