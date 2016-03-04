package com;

public class CostComputer {

	public static double getCost(Request request, CloudLocation cloud) throws Exception {						
		return cloud.getCost(request);
	}

}
