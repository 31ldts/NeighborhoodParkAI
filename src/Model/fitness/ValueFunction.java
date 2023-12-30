/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.fitness;

import Basics.Position;
import Model.Individuals.CityTileset;
import Model.Individuals.Tiles.TileType;

/**
 *
 * @author gabriel
 */
public class ValueFunction {
    public static Double Evaluate(CityTileset city){
        double maxPark = CityTileset.getMaxValue()* city.getNparkTiles();
        double minPark = CityTileset.getMinValue() * city.getNparkTiles();
        
        double counter = 0;
        
        for (Position park : city.getArrayOfParkPositions()) {	// Get each park from the city
            int val = city.getTile(park).getValue(TileType.PARK);
            counter += val;
    	}
        
        /*    	double average = 0;
        if(city.getNparkTiles() != 0){
        average = counter / city.getNparkTiles();
        }	// Average score of the parks*/
        
        //System.out.print("mv: " + maxPark + ", minv: " + minPark + ", meanv: " +CityTileset.getMeanValue()+ ", average: " + average + "\n");
        
    	//return (average-minPark)/(maxPark-minPark);	// Percentage of the average of the parks
        return (counter - minPark)/maxPark;
    }
}
