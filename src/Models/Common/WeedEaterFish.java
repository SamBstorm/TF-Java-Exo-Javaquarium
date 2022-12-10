package Models.Common;

import Models.Handlers.CustomRNG;

public abstract class WeedEaterFish extends Fish implements IWeedEater {
    public WeedEaterFish(String name, Gender gender) {
        super(name, gender);
    }

    public WeedEaterFish(String name, Gender gender, int age) {
        super(name, gender, age);
    }
    @Override
    public void eats(ISeaweed meal) {
        System.out.printf("%s mange une algue.", this.getName());
        System.out.println();
        meal.hurt(2);
        this.heal(3);
    }
    @Override
    public void eats(ILivingThing meal) {
        this.eats((ISeaweed) meal);
    }

    @Override
    protected ILivingThing chooseMeal() {
        ILivingThing randomWeed;
        do {
            int randomIndex = CustomRNG.GetRandomIndex(getEnvironment().getSeaweeds().length);
            randomWeed = getEnvironment().getSeaweeds()[randomIndex];
        } while (randomWeed == this || !randomWeed.isAlive());
        return randomWeed;
    }
}