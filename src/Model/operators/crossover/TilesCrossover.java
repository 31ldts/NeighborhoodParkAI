package Model.operators.crossover;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import Basics.Position;
import Model.Individuals.CityTileset;
import Model.Individuals.CityTilesetPopulation;
import Model.operators.crossover.CrossoverOperator.Pairing;

public class TilesCrossover extends CrossoverOperator<CityTileset> {

    private Random generator = new Random();
    private int SEGMENTS; //Asumes que esto es par.
    private double PROBABILITY;

    private int size;
    private int totalTiles;

    public TilesCrossover(int segments, double probability) {
        this.SEGMENTS = segments;
        this.PROBABILITY = probability;
    }

    /**
     * Applies the crossover operation to a population of CityTilesets.
     *
     * @param pop Population of CityTilesets.
     * @return Population of offspring CityTilesets after crossover.
     */
    public CityTilesetPopulation apply(CityTilesetPopulation pop) {
        size = pop.getArrayList().get(0).getSize();
        totalTiles = size * size;

        // Initialize offspring population
        CityTilesetPopulation offsprings = new CityTilesetPopulation(pop.getId(), pop.size());

        // Create random pairings for crossover
        ArrayList<Pairing> pairings = makeRandomPairings(pop);

        // Apply crossover to each pairing
        for (Pairing pairing : pairings) {
        	// Get parks for each parent
        	TreeSet<Position> parksFirst = new TreeSet<>(pairing.firstParent.getArrayOfParkPositions());
        	TreeSet<Position> parksSecond = new TreeSet<>(pairing.secondParent.getArrayOfParkPositions());
        
            // Generate random cutoff points for crossover
            Set<Integer> cutOffPoints = generateCutOffPoints();

            // Get pairs of start and end indices for crossover segments
            int[][] pairs = getPairs((TreeSet<Integer>) cutOffPoints);

            // Perform crossover for each segment
            for (int[] pair : pairs) {
                int start = pair[0];
                int end = pair[1] != -1 ? pair[1] : (totalTiles - 1);

                // Convert 1D index to 2D coordinates
                int xStart = start % size;
                int yStart = start / size;
                int xEnd = end % size;
                int yEnd = end / size;
                
                // Extract park segments for each parent
                TreeSet<Position> exchangeFirst = new TreeSet<>(parksFirst.subSet(new Position(xStart, yStart), new Position(xEnd, yEnd)));
                TreeSet<Position> exchangeSecond = new TreeSet<>(parksSecond.subSet(new Position(xStart, yStart), new Position(xEnd, yEnd)));
                
                // Identify common parks in the segments
                TreeSet<Position> commonParks = new TreeSet<>(exchangeFirst);
                commonParks.retainAll(exchangeSecond);
                
                // Remove common parks from the exchange sets
                exchangeFirst.removeAll(commonParks);
                exchangeSecond.removeAll(commonParks);
                
                // Swap parks between parents
                for(Position pos: exchangeFirst) {
                	pairing.firstParent.removeParkTile(pos);
                	pairing.secondParent.NewParkTile(pos);
                }
                
                for(Position pos: exchangeSecond) {
                	pairing.secondParent.removeParkTile(pos);
                	pairing.firstParent.NewParkTile(pos);
                }          
            }
            // Add offspring to the population
            offsprings.add(pairing.firstParent);
            offsprings.add(pairing.secondParent);
        }

        return offsprings;
    }
    
    /**
     * Generates random cutoff points for crossover segments.
     *
     * @return Set of random cutoff points.
     */
    private Set<Integer> generateCutOffPoints() {
        Set<Integer> cutOffPoints = new TreeSet<>();
        while (cutOffPoints.size() < this.SEGMENTS - 1) {
            cutOffPoints.add(generator.nextInt(totalTiles));
        }
        return cutOffPoints;
    }

    
    /**
     * Performs crossover on two parent CityTilesets using specified cutoff points.
     *
     * @param firstParent   First parent CityTileset.
     * @param secondParent  Second parent CityTileset.
     * @param cutOffPoints  Set of cutoff points for crossover segments.
     * @return Offspring CityTileset after crossover.
     *//*
    private CityTileset crossover(CityTileset firstParent, CityTileset secondParent, Set<Integer> cutOffPoints) {
    	TreeSet<Position> parks = new TreeSet<>(firstParent.getArrayOfParkPositions());
    	
    	// Create offspring as a copy of the first parent
        CityTileset offspring = new CityTileset(firstParent);

        // Get pairs of start and end indices for crossover segments
        int[][] pairs = getPairs((TreeSet<Integer>) cutOffPoints);

        // Perform crossover for each segment
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1] != -1 ? pair[1] : (totalTiles - 1);

            // Convert 1D index to 2D coordinates
            int xStart = start % size;
            int yStart = start / size;
            int xEnd = end % size;
            int yEnd = end / size;
            
            TreeSet<Position> aux = new TreeSet<>(parks.subSet(new Position(xStart, yStart), new Position(xEnd, yEnd)));

            // Copy tiles from the second parent to the offspring
            for (int y = yStart; y <= yEnd; y++) {
                for (int x = xStart; x <= xEnd; x++) {
                    offspring.setTile(x, y, secondParent.getTile(x, y));
                }
            }
            
        }

        return offspring;
    }*/

    /**
     * Converts a sorted set of cutoff points into pairs of start and end indices.
     *
     * @param set Sorted set of cutoff points.
     * @return Array of pairs representing start and end indices.
     */
    private static int[][] getPairs(TreeSet<Integer> set) {
        int numElems = set.size();
        int[][] pairs = new int[numElems / 2 + numElems % 2][2];

        int i = 0;
        while (!set.isEmpty()) {
            int firstValue = set.pollFirst();
            int secondValue = set.isEmpty() ? -1 : set.pollFirst();

            pairs[i][0] = firstValue;
            pairs[i][1] = secondValue;

            i++;
        }

        return pairs;
    }
}
