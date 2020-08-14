package MarkOnTheMap;

/** Implements a common marker for largest cities 
 * 
 * @author Aastha Gautam
 *
 */
import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PGraphics;

public class LargestCityMarker extends Marker 
{
	public static List<SimpleLinesMarker> routes;
	
	public LargestCityMarker(Feature city) 
	{
		super(((PointFeature)city).getLocation(), city.getProperties());
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) 
	{
	
		pg.pushStyle();
	    pg.noStroke();
	    pg.fill(200, 200, 0, 100);
	    pg.ellipse(x, y, 20, 20);
	    pg.fill(255, 100);
	    pg.ellipse(x, y, 10, 10);
	    pg.popStyle();		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		// TODO Auto-generated method stub
		
	}
}