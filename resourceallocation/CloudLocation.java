package com;

import java.util.ArrayList;

public class CloudLocation {
	
	int cloudId;
	String zone;
	double totalRAM;
	double totalStorage;
	double totalVCPUs;
	
	double cloudAvailableRAM;
	double cloudAvailableStorage;
	double cloudAvailableVCPUs;
	
	double utilizationFactor = 0.0;
	double bufferRatio = 0.2;
	
	ArrayList<Host> hosts = new ArrayList<Host>();

	public CloudLocation(int cloudId, String zone, double bufferRatio, double ram, double storage, double cpus) {

		this.cloudId = cloudId;
		this.zone = zone;
		this.bufferRatio = bufferRatio;
		this.cloudAvailableRAM = this.totalRAM = ram;
		this.cloudAvailableStorage = this.totalStorage = storage;
		this.cloudAvailableVCPUs = this.totalVCPUs = cpus;
		initializehosts(cloudId);
	}
	
	public ArrayList<Host> initializehosts(int cloudId){
		switch(cloudId) {
		case 1: 
			hosts.add(new Host(1,cloudId, 2000, 2000,  19000, 19000,2200, 2200));
			hosts.add(new Host(2,cloudId, 2000, 2000, 20500, 20500, 1700, 1700));
			hosts.add(new Host(3,cloudId, 2000, 2000, 21500, 21500, 1900, 1900));
			hosts.add(new Host(4,cloudId, 2000, 2000, 19000, 19000, 1200, 1200));
			hosts.add(new Host(5,cloudId, 2000, 2000, 20000, 20000, 1450, 1450));
			break;
		case 2: 
			hosts.add(new Host(1,cloudId, 2000, 2000, 18000, 18000, 1100, 1100));
			hosts.add(new Host(2,cloudId, 2000, 2000, 14000, 14000, 1400, 1400));
			hosts.add(new Host(3,cloudId, 2000, 2000, 13000, 13000, 1200, 1200));
			hosts.add(new Host(4,cloudId, 2000, 2000, 19000, 19000, 2500, 2500));
			hosts.add(new Host(5,cloudId, 2000, 2000, 16000, 16000, 1000, 1000));
			break;
		case 3: 
			hosts.add(new Host(1,cloudId, 2000, 2000, 21000, 21000, 2300, 2300));
			hosts.add(new Host(2,cloudId, 2000, 2000, 22000, 22000, 1250, 1250));
			hosts.add(new Host(3,cloudId, 2000, 2000, 23000, 23000, 1700, 1700));
			hosts.add(new Host(4,cloudId, 2000, 2000, 24000, 24000, 1350, 1350));
			hosts.add(new Host(5,cloudId, 2000, 2000, 20000, 20000, 1150, 1150));
			break;
		case 4: 
			hosts.add(new Host(1,cloudId, 2000, 2000, 23000, 23000, 1700, 1700));
			hosts.add(new Host(2,cloudId, 2000, 2000, 21000, 21000, 2500, 2500));
			hosts.add(new Host(3,cloudId, 2000, 2000, 22000, 22000, 1450, 1450));
			hosts.add(new Host(4,cloudId, 2000, 2000, 19000, 19000, 1900, 1900));
			hosts.add(new Host(5,cloudId, 2000, 2000, 25000, 25000, 1250, 1250));
			break;
		case 5:
			hosts.add(new Host(1,cloudId, 2000, 2000, 18000, 18000, 1500, 1500));
			hosts.add(new Host(2,cloudId, 2000, 2000, 22000, 22000, 1450, 1450));
			hosts.add(new Host(3,cloudId, 2000, 2000, 21000, 21000, 2000, 2000));
			hosts.add(new Host(4,cloudId, 2000, 2000, 19000, 19000, 1050, 1050));
			hosts.add(new Host(5,cloudId, 2000, 2000, 20000, 20000, 1800, 1800));
			break;
		}
		return hosts;
	}
	public double getCost(Request r) throws Exception {
		double cost = 1000.0;
		double requestedRAM = 0;
		double requestedStorage = 0;
		double requestedVCPUs = 0;
		
		switch(r.instanceType) {
		case SMALL: 
			requestedRAM = 1 * r.numInstances;
			requestedStorage = 8 * r.numInstances;
			requestedVCPUs = 1 * r.numInstances;
			break;
		case MEDIUM: 
			requestedRAM = 4 * r.numInstances;
			requestedStorage = 16 * r.numInstances;
			requestedVCPUs = 6 * r.numInstances;
			break;
		case LARGE: 
			requestedRAM = 8 * r.numInstances;
			requestedStorage = 32 * r.numInstances;
			requestedVCPUs = 10 * r.numInstances;
			break;
		}


		if (requestedRAM > cloudAvailableRAM | requestedStorage > cloudAvailableStorage
				| requestedVCPUs > cloudAvailableVCPUs) {
			return cost;
		}

		cost = 1/((cloudAvailableRAM - requestedRAM) + (cloudAvailableStorage - requestedStorage) + (cloudAvailableVCPUs - requestedVCPUs))  + utilizationFactor ;
		return cost;
	}
	
	public void assignVMtoHosts(Request currentRequest) throws Exception {

		double requestedRAM = 0.0;
		double requestedStorage = 0.0;
		double requestedVCPUs = 0.0;
		
		switch(currentRequest.instanceType) {
		case SMALL: 
			requestedRAM = 1 * 40 * currentRequest.numInstances;
			requestedStorage = 8 * 40 * currentRequest.numInstances;
			requestedVCPUs = 1 * 40 * currentRequest.numInstances;
			break;
		case MEDIUM: 
			requestedRAM = 3 *40* currentRequest.numInstances;
			requestedStorage = 16 *40* currentRequest.numInstances;
			requestedVCPUs = 4 *40* currentRequest.numInstances;
			break;
		case LARGE: 
			requestedRAM = 10 *40* currentRequest.numInstances;
			requestedStorage = 32 *40* currentRequest.numInstances;
			requestedVCPUs = 8 *40* currentRequest.numInstances;
			break;
		}
		
		if(cloudAvailableRAM >= requestedRAM && cloudAvailableStorage >= requestedStorage && cloudAvailableVCPUs >= requestedVCPUs) {
			for(Host host : hosts){
				if(host.getAvailableRAM() >= requestedRAM && host.getAvailableStorage() >= requestedStorage && host.getAvailableVCPUs() >= requestedVCPUs) {
					host.availableRAM -= requestedRAM;
					host.availableStorage -= requestedStorage;
					host.availableVCPUs -= requestedVCPUs;
					//System.out.println("hostavailableRAM for cloudid "+host.getCloudId() +"is and hostid "+ host.getHostId() + host.availableRAM);
					cloudAvailableRAM -= requestedRAM;
					cloudAvailableStorage -= requestedStorage;
					cloudAvailableVCPUs -= requestedVCPUs;
					//System.out.println("cloudavailableRAM:for cloudid "+cloudId +"is"+ cloudAvailableRAM);
					break;
				}	
			}
		}else{
			System.out.println("cloudavailableRAM < requestedRAM");
		}
		
		utilizationFactor = 1 - ((cloudAvailableRAM+cloudAvailableStorage+cloudAvailableVCPUs)/(totalRAM+totalStorage+totalVCPUs));
	}

}
