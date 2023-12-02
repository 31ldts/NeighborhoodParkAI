/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.operators.mutation;

import Model.Individuals.CityTileset;
import Model.Individuals.Population;

/**
 *
 * @author gabriel
 */
public class MutationController {
    public void apply(Population<CityTileset> population){
    	new RandomParkMutation().RandomParkMutation(population);;
    }
}
