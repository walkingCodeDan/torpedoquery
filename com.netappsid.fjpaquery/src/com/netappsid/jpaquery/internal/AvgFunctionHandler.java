package com.netappsid.jpaquery.internal;

import com.netappsid.jpaquery.NumberFunction;

public class AvgFunctionHandler<T extends Number> extends AggregateFunctionHandler<T, NumberFunction<T, T>> implements NumberFunction<T, T> {

	@Override
	protected String getFunctionName() {
		return "avg";
	}

}
