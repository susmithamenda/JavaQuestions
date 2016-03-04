package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResourceAllocation
 */
@WebServlet("/ResourceAllocation")
public class ResourceAllocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceAllocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Request> requests = new ArrayList<Request>();
		ArrayList<CloudLocation> clouds = new ArrayList<CloudLocation>();
		clouds.add(new CloudLocation(1, "cloud1", 0.0, 10000.0, 100000.0,8450.0));
		clouds.add(new CloudLocation(2, "cloud2", 0.0, 10000.0, 80000.0,7200.0));
		clouds.add(new CloudLocation(3, "cloud3", 0.0, 10000.0, 110000.0,7750.0));
		clouds.add(new CloudLocation(4, "cloud4", 0.0, 10000.0,110000.0,8800.0));
		clouds.add(new CloudLocation(5, "cloud5", 0.0, 10000.0, 100000.0,7800.0));
		
		try {
			FileInputStream fstream = new FileInputStream(
					"/home/smenda/Documents/textfiles/1000E.txt");
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
