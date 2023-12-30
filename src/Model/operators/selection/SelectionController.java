/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.operators.selection;

import Model.Individuals.CityTilesetPopulation;
import Model.ModelParameters;
import java.util.Random;

/**
 *
 * @author gabriel
 */
public class SelectionController{
    
    RankSelection rs;
    NaturalSelection ns;
    Random generator;
    
    private boolean useElitism;
    private boolean useTruncate;
    private double  truncateSize;

    public SelectionController(ModelParameters mp){
        rs =            new RankSelection();
        generator =     new Random(System.currentTimeMillis());
        useElitism =    mp.getUSEELITISM();
        useTruncate =   mp.getUSETRUNCATE();
        truncateSize =  mp.getTRUNCATESIZE();
        ns =			new NaturalSelection();
    }
    
    //include elitism and truncation.
    public CityTilesetPopulation apply(CityTilesetPopulation pop){
        //return rs.apply(pop,useElitism,useTruncate,generator,truncateSize);
    	return ns.apply(pop, generator);
    }
}
