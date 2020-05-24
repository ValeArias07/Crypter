package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RoutesList {
	
	private RouteNode firstRouteNode;
	
	public RoutesList() {
		firstRouteNode=null;
	}

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
	

	public String delete(String route, boolean type) {
		if(firstRouteNode!=null) {
			return delete(firstRouteNode, route, type);
		}else {
			return "List empty";
		}
	}
	
	private String delete(RouteNode current, String route, boolean type) {
		if(current.getRoute().equals(route) && current.getType()==type) {
			String message=current.getRoute();
			
			//////When current is the only node 
			if(current.getNext()==null && current.getPrev()==null) {
				current=null;
				
			/////When current is the first node	
			}else if(current.getPrev()==null) {
				current.getNext().setPrev(null);
				
			/////When current is the last one 
			}else if(current.getNext()==null){
				current.setPrev(null);
				
			/////When current is in the middle
			}else {
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
			}
			
			return message;
		}else {
			if(current.getNext()!=null)
			return delete(current.getNext(), route, type);
		}
		return null;
	}
	
	public ArrayList <RouteNode> getRoutes(boolean type) {
		if(firstRouteNode!=null) {
			ArrayList <RouteNode> list= new ArrayList <RouteNode>();
			return getRoutes(firstRouteNode, type, list);
		}
		return null;
	}
	
	private ArrayList <RouteNode> getRoutes(RouteNode current, boolean type, ArrayList <RouteNode> list){
		if(current.getType()==type) {
			list.add(current);
		}
		
		if(current.getNext()!=null) 
			return getRoutes(current.getNext(), type,list);
			else
				return list;
	}
	
}

