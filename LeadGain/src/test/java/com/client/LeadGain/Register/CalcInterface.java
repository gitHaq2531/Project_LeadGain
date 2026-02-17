package com.client.LeadGain.Register;

public interface CalcInterface {
default void add(int a, int b) {
	
}
public int subtract(int a, int b);
public int multiply(int a, int b);
public int divide(int a, int b);

public static CalcInterface getCalculator()
{
	CalcInterface obj=new Calculator();
	return obj;
}
}
