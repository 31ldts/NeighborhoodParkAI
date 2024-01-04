/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.operators.mutation;

import Model.Individuals.CityTileset;
import Model.Individuals.Population;

/**
 * Controller for managing various mutation operators.
 */
public class MutationController {

    private RandomParkMutation rpm;
    private PointNeighborhoodMutation pnm;
    private TargetedNeighborhoodMutation tnm;
    private ParkExpansionMutation pem;
    private int counter = 1;
    private int counterRandom = 0;
    private double lastUpdate = 0.0;

    /**
     * Constructs a MutationController with specified mutation probabilities and parameters.
     *
     * @param mutationProb Probability of mutation.
     * @param pointNeigh  Number of point mutations in the neighborhood.
     */
    public MutationController(double mutationProb, int pointNeigh) {
        rpm = new RandomParkMutation(mutationProb);
        pnm = new PointNeighborhoodMutation(mutationProb, pointNeigh);
        tnm = new TargetedNeighborhoodMutation(mutationProb, pointNeigh);
        pem = new ParkExpansionMutation(mutationProb);
    }

    /**
     * Applies various mutation operators to a population of CityTilesets.
     *
     * @param pop Population of CityTilesets.
     */
    public void apply(Population<CityTileset> pop, boolean ending){
    	/*if ((pop.getBestIndividual().getFitness() == lastUpdate)&&(counter < 10)){
    		counter++;
    	}else {
    		counter = 0;
    	}
    	boolean extraMut = counter >= 10;
    	//rpm.apply(pop);
    	//pnm.apply(pop);
    	if(extraMut) {
    		counterRandom++;
    		if(counterRandom == 5) {
    			rpm.apply(pop);
    			counterRandom = 0;
    		}
    	}
    	tnm.apply(pop, extraMut);
    	//pem.apply(pop);*/
    	if(ending) {
    		tnm.apply(pop, false);
    	}else {
	    	if (pop.getBestIndividual().getFitness() == lastUpdate){
	    		counter++;
	    	}else {
	    		counter = 1;
	    	}
	    	if(counter % 100 == 0) {
	    		pem.apply(pop, true);
	    	}else if(counter > 50) {
	    		pem.apply(pop, false);
	    	}else if(counter > 20) {
	    		rpm.apply(pop);
	    	}else if(counter % 10 == 0) {
	    		tnm.apply(pop, true);
	    	}else {
	    		tnm.apply(pop, false);
	    	}
    	}
    	/*
    	extraMut = counter >= 10;
    	//rpm.apply(pop);
    	//pnm.apply(pop);
    	if(extraMut) {
    		counterRandom++;
    		if(counterRandom == 5) {
    			rpm.apply(pop);
    			counterRandom = 0;
    		}
    	}
    	tnm.apply(pop, extraMut);*/
    	//pem.apply(pop);
    }
}
