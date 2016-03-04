package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class SelectiveAllocation {
	public static void main(String... args) {
		ArrayList<Request> requests = new ArrayList<Request>();

		/*
		 * requests.add(new Request(1, 2,
		 * "IOS","USA","secondinstance","OnDemand", InstanceType.MEDIUM));
		 * requests.add(new Request(2, 1,
		 * "Android","IN","firstinstance","OnDemand", InstanceType.LARGE));
		 * requests.add(new Request(3, 4,
		 * "IOS","CHN","fourthinstance","OnDemand", InstanceType.LARGE));
		 * requests.add(new Request(4, 2,
		 * "IOS","JPN","thirdinstance","OnDemand", InstanceType.SMALL));
		 * requests.add(new Request(5, 2,
		 * "IOS","USA","fifthinstance","OnDemand", InstanceType.MEDIUM));
		 * requests.add(new Request(6, 1,
		 * "Android","IN","sixthinstance","OnDemand", InstanceType.SMALL));
		 * requests.add(new Request(7, 5,
		 * "IOS","CHN","tenthinstance","OnDemand", InstanceType.SMALL));
		 * requests.add(new Request(8, 2,
		 * "IOS","JPN","eighthinstance","OnDemand", InstanceType.SMALL));
		 * requests.add(new Request(9, 2,
		 * "IOS","USA","seventhinstance","OnDemand", InstanceType.MEDIUM));
		 * requests.add(new Request(10, 1,
		 * "Android","IN","ninthinstance","OnDemand", InstanceType.LARGE));
		 */

		ArrayList<CloudLocation> clouds = new ArrayList<CloudLocation>();
		/*clouds.add(new CloudLocation(1, "cloud1", 0.0, 0.0, 0.0, 0.0));
		clouds.add(new CloudLocation(2, "cloud2", 0.0, 20.0, 20.0, 20.0));
		clouds.add(new CloudLocation(3, "cloud3", 0.0, 40.0, 40.0, 40.0));
		clouds.add(new CloudLocation(4, "cloud4", 0.0, 60.0, 60.0, 60.0));
		clouds.add(new CloudLocation(5, "cloud5", 0.0, 0.0, 0.0, 0.0));*/

		clouds.add(new CloudLocation(1, "cloud1", 0.3, 10000.0, 100000.0,8450.0));
		clouds.add(new CloudLocation(2, "cloud2", 0.2, 10000.0, 80000.0,7200.0));
		clouds.add(new CloudLocation(3, "cloud3", 0.4, 10000.0, 110000.0,7750.0));
		clouds.add(new CloudLocation(4, "cloud4", 0.2, 10000.0,110000.0,8800.0));
		clouds.add(new CloudLocation(5, "cloud5", 0.3, 10000.0, 100000.0,7800.0));
		
		try {
			FileInputStream fstream = new FileInputStream(
					"/home/smenda/Documents/textfiles/200.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				String[] str_array = strLine.split(",");
				requests.add(new Request(Integer.parseInt(str_array[0]),
						Integer.parseInt(str_array[1]), str_array[2],
						str_array[3], str_array[4], str_array[5], InstanceType
								.valueOf(str_array[6])));
			}
			br.close();
			SelectiveAllocation.allocateResources(requests, clouds);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	} // main

	public static void allocateResources(ArrayList<Request> requests,
			ArrayList<CloudLocation> clouds) throws Exception {

		long startTime = System.currentTimeMillis();
		int cloud1counter = 0;
		int cloud2counter = 0;
		int cloud3counter = 0;
		int cloud4counter = 0;
		int cloud5counter = 0;
		System.out.println("Start time: " + startTime);

		while (!requests.isEmpty()) {
			// find location that yields minimum cost for each request
			for (Request r : requests) {
				r.minCost = 1000.0;
				double currMin = 0.0;
				for (CloudLocation l : clouds) {
					try {
						currMin = CostComputer.getCost(r, l);
						if (r.minCost > currMin) {
							r.minCost = currMin;
							r.minCostLocation = l;
						}
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
				if (r.minCost == 1000.0 || r.minCostLocation == null) {
					/*
					 * throw new Exception(
					 * "Insufficient resources: cannot provision request r:" +
					 * r.id + " requested capacity: " + r.capacityRequested());
					 */
					System.out
							.println("Insufficient resources: cannot provision request r:"
									+ r.id
									+ " requested capacity: "
									+ r.capacityRequested()
									+ " min_cost: "
									+ r.minCost);
				}
			}

			// Sort all requests by minCost
			Collections.sort(requests, Request.ReqCostComparator);

			// Calculate standard deviation for minCost of all requests
			double avgMinCost = 0.0;
			for (Request r : requests) {
				avgMinCost += r.minCost;
			}
			avgMinCost = avgMinCost / (requests.size());

			double variance = 0.0;
			double stdDev = 0.0;
			for (Request r : requests) {
				variance += Math.pow((r.minCost - avgMinCost), 2);
			}
			stdDev = Math.sqrt(variance / (requests.size()));
			// System.out.println("StdDev: " + stdDev);

			/*
			 * Choose between Min-Min & Max-Min by deducing p; where p is such
			 * that (p.minCost - p.previous.minCost) > stdDev
			 */

			Request previous = null;
			Request p = null;
			for (Request r : requests) {
				p = r;
				if (previous != null
						&& ((r.minCost - previous.minCost) > stdDev)) {
					break;
				}
				previous = r;
			}
			System.out.println("p found at: "+ requests.indexOf(p) );
			Request currRequest = null;
			if (requests.indexOf(p) <= requests.size() / 2) {
				System.out.println("Choose Min-Min");
				currRequest = requests.remove(0);
			} else {
				System.out.println("Choose Max-Min ");
				currRequest = requests.remove(requests.size() - 1);
			}

			// Assign request to resource
			if (currRequest.minCostLocation != null) {
				currRequest.minCostLocation.assignVMtoHosts(currRequest);
				if (currRequest.minCostLocation.cloudId == 1) {
					cloud1counter++;
				} else if (currRequest.minCostLocation.cloudId == 2) {
					cloud2counter++;
				} else if (currRequest.minCostLocation.cloudId == 3) {
					cloud3counter++;
				} else if (currRequest.minCostLocation.cloudId == 4) {
					cloud4counter++;
				} else {
					cloud5counter++;
				}
				System.out.println("Assigning request reqId: " + currRequest.id
						+ ", cost: " + currRequest.minCost + ", location: "
						+ currRequest.minCostLocation.cloudId + ", utilFactor: "
						+ currRequest.minCostLocation.utilizationFactor + " RAM: "
						+ currRequest.minCostLocation.cloudAvailableRAM + " Storage: "
						+ currRequest.minCostLocation.cloudAvailableStorage + " :VCPUs "
						+ currRequest.minCostLocation.cloudAvailableVCPUs );
				//System.out.println("cloudid: "+currRequest.minCostLocation.cloudId+" totalRAM - availableRAM :" +currRequest.minCostLocation.totalRAM +"-" +currRequest.minCostLocation.cloudAvailableRAM );
				
			} else {
				System.out.println("Cannot provision request: " + currRequest.id + " because of insufficient resources");
			}
			
			//System.out.println("=====================");
		}
		/*for(CloudLocation cloudlet : clouds){
			System.out.println("CloudId: "+ cloudlet.cloudId + "cloudzone: "+ cloudlet.zone);
			System.out.println("whose hosts are                   ");
			for(Host host : cloudlet.hosts){
				System.out.println("HostId: "+ host.hostId + " availableRAM: " + host.getAvailableRAM() + " availableStorage: "+ host.getAvailableStorage()+ " availableVCPUs: " + host.getAvailableVCPUs());
			}
		}*/
		long endTime = System.currentTimeMillis();
		System.out.println("End time: " + endTime);
		System.out.println("Total time taken: " + (endTime - startTime));
		System.out.println("Cloud Distribution: cloud1: " + cloud1counter
				+ " cloud2: " + cloud2counter + " cloud3: " + cloud3counter
				+ " cloud4: " + cloud4counter + " cloud5: " + cloud5counter);
	} // allocateResources
} // class
