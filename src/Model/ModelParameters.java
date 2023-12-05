/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabriel
 */
public class ModelParameters {
    private final int populationSize;
    
    public ModelParameters(int popSize){
        populationSize = popSize;
    }
    
    public int getPopulationSize(){
        return populationSize;
    }
}
