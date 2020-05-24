package model;

import java.util.ArrayList;

public class RouteManager{
	private RoutesList routeList;
	
	public RouteManager() {
		routeList= new RoutesList();
	}

	public ArrayList <RouteNode> getRoutes(boolean type) throws InterruptedException {
			return routeList.getRoutes(type);	
	}
	
	public String searchRoute(String route,  boolean type){
		return routeList.search(route);
	}
	
	public void addRoute(String route, String text, boolean type) {
		routeList.add(route, type, text);
	}
	
	public RouteNode deleteRoute(String route, boolean type) {
		return routeList.delete(route);
	}
	
}
