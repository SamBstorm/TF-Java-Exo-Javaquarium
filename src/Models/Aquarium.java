package Models;

import Models.Common.*;
import Models.Handlers.CustomRNG;

import java.util.ArrayList;
import java.util.List;

public class Aquarium implements IAquaEnvironment{
    private List<ILivingThing> _population;

    public ILivingThing[] getPopulation(){
        return _population.toArray(ILivingThing[]::new);
    }

    public IFish[] getFishes(){
        List<IFish> fishes = new ArrayList<>();
        for (ILivingThing alive: this._population
             ) {
            if(alive instanceof IFish) fishes.add((IFish) alive);
        }
        return fishes.toArray(IFish[]::new);
    }

    public ISeaweed[] getSeaweeds(){
        List<ISeaweed> Seaweeds = new ArrayList<>();
        for (ILivingThing alive: this._population
        ) {
            if(alive instanceof ISeaweed) Seaweeds.add((ISeaweed) alive);
        }
        return Seaweeds.toArray(ISeaweed[]::new);
    }

    public Aquarium(){
        _population = new ArrayList<>();
    }

    /*public void addFish(IFish fish){
        if(fish.getEnvironment() != this) fish.setEnvironment(this);
        _population.add(fish);
    }

    public void addSeaweed(ISeaweed seaweed){
        if(seaweed.getEnvironment() != this) seaweed.setEnvironment(this);
        _population.add(seaweed);
    }*/

    public void addLiving(ILivingThing living){
      if(living.getEnvironment() != this) living.setEnvironment(this);
        //_population.add(living);
        _population.add(0,living);
    }

    public void newTurn(){
        ILivingThing[] currentPopulation = getPopulation();
        for (int i =0; i < currentPopulation.length; i++) {
            ILivingThing living = currentPopulation[i];
            living.lives();
        }
        cleanPopulation();
        showReport();
        for (IFish fish:getFishes()) {
            fish.setIsBusy(false);
        }
    }

    private void cleanPopulation(){
        List<ILivingThing> deadThings = new ArrayList<>();
        for (ILivingThing living: _population) {
            if(!living.isAlive()) deadThings.add(living);
        }
        for (ILivingThing dead: deadThings) {
            _population.remove(dead);
        }
    }

    private void showReport(){
        System.out.printf("Nombre d'alges : %d", this.getSeaweeds().length);
        System.out.println();
        System.out.println("----------------------------------------");
        for (IFish fish : getFishes()) {
            System.out.printf("Un %s : %s %s (%d/%d)", fish.getClass().getName().substring(14), fish.getName() , fish.getGender().toString(), fish.getCurrentHP(), fish.getMaxHP());
            System.out.println();
        }
    }
}
