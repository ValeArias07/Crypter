package model;

import java.util.ArrayList;
import thread.RouteThread;

public class RouteManager{
	private RoutesList routeList;
	public RouteManager() {
		routeList= new RoutesList();
	}
	
	public ArrayList <RouteNode> getEncryptRoutes() throws InterruptedException {
		RouteThread t = new RouteThread(routeList, true);
		t.start();
		t.join();
		return t.getEncryptedArray();
	}
	
	public ArrayList <RouteNode> getDecryptedRouteList() throws InterruptedException{
		RouteThread t = new RouteThread(routeList, false);
		t.start();
		t.join();
		return t.getEncryptedArray();
	}
	
	public String searchRoute(String route,  boolean type){
		///Ask the why we need this method. Do we the route's name or the route's text?
		return routeList.search(route, type);
	}
	
	public void addRoute(String route, String text, boolean type) {
		routeList.add(route, type, text);
	}
	
	public String deleteRoute(String route, boolean type) {
		return routeList.delete(route, type);
	}
	
	
}
