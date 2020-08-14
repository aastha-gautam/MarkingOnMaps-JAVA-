package MarkOnTheMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.geo.Location;
import parsing.ParseFeed;
import processing.core.PApplet;

/** An applet that shows 30 Largest Cities on a world map.  
 * @author Aastha Gautam
 *
 */
public class LargestCity extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UnfoldingMap map;
	private List<Marker> cityList;
	List<Marker> routeList;
	
	public void setup() {
		// setting up PApplet
		size(800,600, OPENGL);
		
		// setting up map and default events
		map = new UnfoldingMap(this,new Microsoft.AerialProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		// get features from city data file
		List<PointFeature> features = ParseFeed.parseAirports(this, "largest_cities.dat");
		
		// list for markers, hashmap for quicker access when matching
		cityList = new ArrayList<Marker>();
		HashMap<Integer, Location> cities = new HashMap<Integer, Location>();
		
		// create markers from features
		for(PointFeature feature : features) {
			LargestCityMarker m = new LargestCityMarker(feature);
			m.setRadius(6);
			cityList.add(m);
			
			// put city in hashmap with OpenFlights unique id for key
			cities.put(Integer.parseInt(feature.getId()), feature.getLocation());
		
		}
		
		map.addMarkers(cityList);
		
	}
	
	public void draw() {
		background(0);
		map.draw();
		
	}
	

}
