package model;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class RouteNode implements Serializable, Comparable<RouteNode>{

	private String name;
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
		this.type = type;
		this.text = text;
		
		name = calculateName(route);
		
		nextRoute = null;
		previousRoute = null;
	}
	
	private String calculateName(String r) {
		String[] aux = route.split("/");
		
		return (aux[aux.length-1].split("\\."))[0];
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public String getName() {
		return name;
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
		previousRoute=prev;
	}
	
	@Override
	public String toString() {
		return name + "// " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + " - " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
	}

	@Override
	public int compareTo(RouteNode r2) {
		if(date.toString().compareTo(r2.getDate().toString())<0)
			return -1;
			
		if(date.toString().compareTo(r2.getDate().toString())>0)
			return 1;
			
			return 0;
	}
}
