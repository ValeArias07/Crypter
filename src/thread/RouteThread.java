package thread;

import java.util.ArrayList;

import model.RouteNode;
import model.RoutesList;

public class RouteThread extends Thread {

	private RoutesList routesList;
	private boolean type;
	private ArrayList <RouteNode> encryptedArrayList;
	private ArrayList <RouteNode> decryptedArrayList;
	
	public RouteThread(RoutesList routesList, boolean type) {
		this.routesList = routesList;
		encryptedArrayList= new ArrayList <RouteNode>();
		decryptedArrayList= new ArrayList <RouteNode>();
		this.type=type;
	}
	
	public void run() {
		if(type==true) {
			encryptedArrayList=routesList.getRoutes(type);
		}else {
			decryptedArrayList=routesList.getRoutes(type);
		}	
	}
	
	public ArrayList <RouteNode> getEncryptedArray() {
		return encryptedArrayList;
	}
	
	public ArrayList <RouteNode> getDecryptedArray() {
		return decryptedArrayList;
	}
}
