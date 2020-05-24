package model;

import java.time.LocalDateTime;

public class RoutesList {
	
	private RouteNode firstRouteNode;

	

	public void add(String route, boolean type, String text){
		LocalDateTime time= LocalDateTime.now();
		if(firstRouteNode!=null) {
			add(firstRouteNode, route, time, type, text);
		}else {
			firstRouteNode= new RouteNode(route, time, type, text);
		}
	}
	
	private void add(RouteNode current, String route, LocalDateTime time, boolean type, String text) {
		if(current.getNext()!=null) {
			add(current.getNext(),route, time, type, text);
		}else {
			current.setNext(new RouteNode(route, time, type, text));
			current.getNext().setPrev(current);
		}
	}
	
	public String search(String route, boolean type) {
	if(firstRouteNode!=null) {
		return search(firstRouteNode, route, type);
	}
	return null;
	}
	
	private String search(RouteNode current, String route, boolean type) {
		if(current.getRoute().equals(route)) {
			/////// Do we need return route or return text?
			return current.getRoute();
		}else {
			if(current.getNext()!=null)
			search(current.getNext(), route, type);
		}
		return null;
	}
}
