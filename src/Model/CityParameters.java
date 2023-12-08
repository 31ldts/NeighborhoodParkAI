/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabriel
 */
public class CityParameters {

    //Size of a side of the tileset
    public static final int DEFAULTSIZE = 200;
    public static final int MINSIZE = 10;
    public static final int MAXSIZE = 400;
    
    //Size of the neighborhoods. It works better if it divides SETSIZE
    public static final int NEIGHBORHOODSIZE = 50;
    
    private final int size;
    private final int roadDensity;
    private final int buildingDensity;
    private final int parkSpreadness;
    private final int parksPercentage; //1 to 1000
    
    public CityParameters(int s, int rd, int bd, int ps, int pp){
        size            =   s;
        roadDensity     =   rd;
        buildingDensity =   bd;
        parkSpreadness  =   ps;
        parksPercentage =   pp;
    }
    
    public int getSize(){
        return size;
    }
    
    public int getRoadDensity(){
        return roadDensity;
    }
    
    public int getBuildingDensity(){
        return buildingDensity;
    }
    
    public int getParkSpreadness(){
        return parkSpreadness;
    }
    
    public int getParksPercentage(){
        return parksPercentage;
    }
}
