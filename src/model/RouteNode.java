package model;

import java.time.LocalDateTime;

public class RouteNode {

	private String route;
	private LocalDateTime date;
	private RouteNode nextRoute;
	private RouteNode last;
	
	public RouteNode(String route, LocalDateTime date) {
		this.route = route;
		this.date = date;
	}
	
	private RouteNode getNext() {
		return nextRoute;
	}
	
	private void setNext(RouteNode next) {
		nextRoute=next;
	}
}
