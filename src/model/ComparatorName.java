package model;

import java.util.Comparator;

public class ComparatorName implements Comparator<RouteNode>{

	@Override
	public int compare(RouteNode r1, RouteNode r2) {
		if(r1.getName().compareTo(r2.getName())<0)
			return -1;
			
		if(r1.getName().compareTo(r2.getName())>0)
			return 1;
			
			return 0;
	}
}
