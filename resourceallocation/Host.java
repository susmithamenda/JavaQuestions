package com;

public class Host {
	int hostId;
	int cloudId;
	double totalRAM;
	double availableRAM;
	double totalStorage;
	double availableStorage;
	double totalVCPUs;
	double availableVCPUs;
	
	public Host(int hostId, int cloudId, int totalRAM, int availableRAM, int totalStorage,int availableStorage, int totalVCPUs, int availableVCPUs){
		this.hostId = hostId;
		this.cloudId = cloudId;
		this.totalRAM = totalRAM;
		this.availableRAM = availableRAM;
		this.totalStorage = totalStorage;
		this.availableStorage = availableStorage;
		this.totalVCPUs = totalVCPUs;
		this.availableVCPUs = availableVCPUs;
	}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public int getCloudId() {
		return cloudId;
	}

	public void setCloudId(int cloudId) {
		this.cloudId = cloudId;
	}

	public double getTotalRAM() {
		return totalRAM;
	}

	public void setTotalRAM(double totalRAM) {
		this.totalRAM = totalRAM;
	}

	public double getAvailableRAM() {
		return availableRAM;
	}

	public void setAvailableRAM(double availableRAM) {
		this.availableRAM = availableRAM;
	}

	public double getTotalStorage() {
		return totalStorage;
	}

	public void setTotalStorage(double totalStorage) {
		this.totalStorage = totalStorage;
	}

	public double getAvailableStorage() {
		return availableStorage;
	}

	public void setAvailableStorage(double availableStorage) {
		this.availableStorage = availableStorage;
	}

	public double getTotalVCPUs() {
		return totalVCPUs;
	}

	public void setTotalVCPUs(double totalVCPUs) {
		this.totalVCPUs = totalVCPUs;
	}

	public double getAvailableVCPUs() {
		return availableVCPUs;
	}

	public void setAvailableVCPUs(double availableVCPUs) {
		this.availableVCPUs = availableVCPUs;
	}
	
}
