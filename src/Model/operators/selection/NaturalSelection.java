package Model.operators.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Model.Individuals.CityTileset;
import Model.Individuals.CityTilesetPopulation;

public class NaturalSelection {

	public CityTilesetPopulation apply(CityTilesetPopulation pop, Random generator) {
	    // Get the population sorted by fitness
	    List<CityTileset> sortedPop = pop.sortPopulationByFitness();
	    
	    // Create mating pool based on fitness
	    List<Integer> matingPool = createMatingPool(pop, sortedPop);

	    // Initialize offspring population
	    CityTilesetPopulation aux = new CityTilesetPopulation(pop.getId() + 1, pop.size());

	    // Select individuals from the mating pool to form the next generation
	    selectFromMatingPool(aux, matingPool, sortedPop, generator);

	    return aux;
	}

	/**
	 * Create a mating pool based on the fitness of individuals in the population.
	 *
	 * @param pop       Original population.
	 * @param sortedPop Population sorted by fitness.
	 * @return Mating pool indices.
	 */
	private List<Integer> createMatingPool(CityTilesetPopulation pop, List<CityTileset> sortedPop) {
	    List<Integer> matingPool = new ArrayList<>();
	    double maxFit = sortedPop.get(0).getFitness();

	    for (int cont = 0; cont < pop.size(); cont++) {
	        int n = Double.valueOf(pop.getArrayList().get(cont).getFitness() * 100 / maxFit).intValue();
	        matingPool.addAll(Collections.nCopies(n, cont));
	    }

	    return matingPool;
	}

	/**
	 * Select individuals from the mating pool to form the next generation.
	 *
	 * @param aux       Offspring population.
	 * @param matingPool Mating pool indices.
	 * @param sortedPop Population sorted by fitness.
	 * @param generator Random number generator.
	 */
	private void selectFromMatingPool(CityTilesetPopulation aux, List<Integer> matingPool,
	                                   List<CityTileset> sortedPop, Random generator) {
	    while (aux.size() < aux.getMaxSize()) {
	        int random = generator.nextInt(matingPool.size());
	        int selection = matingPool.get(random);
	        aux.add(sortedPop.get(selection));
	    }
	}

}
