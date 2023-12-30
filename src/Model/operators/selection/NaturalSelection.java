package Model.operators.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.Individuals.CityTileset;
import Model.Individuals.CityTilesetPopulation;

public class NaturalSelection {

	public CityTilesetPopulation apply(
            CityTilesetPopulation pop, 
            Random generator){
        
        //Get the population sorted by fitness
        List<CityTileset> sortedPop = pop.sortPopulationByFitness();
        List<Integer> matingPool = new ArrayList<>();
        double maxFit = sortedPop.get(0).getFitness();
        int cont = 0;
        for(CityTileset city : pop) {
        	int n = Double.valueOf(city.getFitness() * 100 / maxFit).intValue();
        	for (int i = 0; i < n; i++) {
        		matingPool.add(cont);
        	}
        	cont++;
        }
                
        CityTilesetPopulation aux = new CityTilesetPopulation(pop.getId()+1,pop.size());
        
        int selection, random;
        while(aux.size() < aux.getMaxSize()){
        	random = generator.nextInt(matingPool.size());
        	selection = matingPool.get(random);
            aux.add(sortedPop.get(selection));
        }
            
        return aux;
    }
}
