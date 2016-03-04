package com;

import java.util.Comparator;

public class Request {
	long userId;
	long id;
	int numInstances;
	String instancename;
	String machinetype;
	String requesttype;
	String userlocation;
	double minCost = 1000.0;
	CloudLocation minCostLocation = null;
	
	InstanceType instanceType;
	String OSType;
	String plan;
	String provisioningType;
	CloudLocation cloudlocation;
	
	
	public Request(long userId , int inum , String machinetype , String userlocation , String instancename , String requesttype, InstanceType iType) {		
		this.id = userId;
		numInstances = inum;
		this.machinetype = machinetype;
		this.instancename = instancename;
		this.requesttype = requesttype;
		this.userlocation = userlocation;
		instanceType = iType;
	}
	
	private double getCapacityPerInstanceType(InstanceType type) {
		double capacity = 1.0;
		switch(type) {
		case SMALL: 
			capacity = 1.0;
			break;
		case MEDIUM: 
			capacity = 2.0;
			break;
		case LARGE: 
			capacity = 3.0;
			break;
		}
		return capacity;
	}
	
	public double capacityRequested() {
		
		double requestedRAM = 0;
		double requestedStorage = 0;
		double requestedVCPUs = 0;
		switch(instanceType) {
		case SMALL: 
			requestedRAM = 1 * numInstances;
			requestedStorage = 8 * numInstances;
			requestedVCPUs = 1 * numInstances;
			break;
		case MEDIUM: 
			requestedRAM = 4 * numInstances;
			requestedStorage = 16 * numInstances;
			requestedVCPUs = 6 * numInstances;
			break;
		case LARGE: 
			requestedRAM = 8 * numInstances;
			requestedStorage = 32 * numInstances;
			requestedVCPUs = 10 * numInstances;
			break;
		}
		String capacityRequested = requestedRAM+requestedStorage+requestedVCPUs+"";
		return Double.parseDouble(capacityRequested);
	}

	public static Comparator<Request> ReqCostComparator = new Comparator<Request>() {
		public int compare(Request r1, Request r2) {
			return Float.compare((float) r1.minCost, (float) r2.minCost);
		}
	};
}
