package model;

import java.time.LocalDateTime;

public class RouteNode {

	private String route;
	private LocalDateTime date;
	private boolean type;
	private String text;
	private RouteNode nextRoute;
	private RouteNode previousRoute;
	
	/**
	 * This method build a RouteNode instance
	 * @param route represents in a String the address of the file
	 * @param date represents in LocalDateTime class the time of the encrypt or decrypt
	 * @param type represents the action in the file. True for encrypt, False for decrypt
	 */
	public RouteNode(String route, LocalDateTime date, boolean type, String text) {
		this.route = route;
		this.date = date;
		this.type= type;
		this.text= text;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public String getRoute() {
		return route;
	}
	
	public String getText() {
		return text;
	}
	
	public boolean getType() {
		return type;
	}
	
	public RouteNode getNext() {
		return nextRoute;
	}
	
	public RouteNode getPrev() {
		return previousRoute;
	}
	
	public void setNext(RouteNode next) {
		nextRoute=next;
	}

	public void setPrev(RouteNode prev) {
		nextRoute=prev;
	}	
}