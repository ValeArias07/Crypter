package thread;

import java.util.ArrayList;

import model.RouteNode;
import model.RoutesList;

public class RouteThread extends Thread {

	private RoutesList routesList;
	private ArrayList <RouteNode> encryptedArrayList;
	private ArrayList <RouteNode> decryptedArrayList;
	
	public RouteThread(RoutesList routesList) {
		this.routesList = routesList;
		encryptedArrayList= new ArrayList();
		decryptedArrayList= new ArrayList();
	}
	
	public void run() {
		
	}
	
	
}
