package Models.Common;

import Models.Handlers.CustomRNG;

public abstract class MeatEaterFish extends Fish implements IMeatEater {
    public MeatEaterFish(String name, Gender gender) {
        super(name, gender);
    }
    public MeatEaterFish(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    @Override
    public void eats(IFish meal) {
        if (meal.getIsBusy()){
            System.out.printf("%s : ma proie est déjà prise...", this.getName());
            System.out.println();
            return;
        } else if (meal.getClass().equals(this.getClass())) {
            System.out.printf("%s : je ne suis pas canibal...", this.getName());
            System.out.println();
            return;
        }
        meal.setIsBusy(true);
        System.out.printf("%s mange %s", this.getName(), meal.getName());
        System.out.println();
        meal.hurt(4);
        this.heal(5);
    }
    @Override
    public void eats(ILivingThing meal) {
        this.eats((IFish) meal);
    }

    @Override
    protected ILivingThing chooseMeal() {
        IFish[] fishes = getEnvironment().getFishes();
        if(fishes.length <= 1) {
            System.out.printf("%s : Il n'y a rien à manger ici...", this.getName());
            System.out.println();
            return null;
        }
        IFish randomFish;
        do {
            int randomIndex = CustomRNG.GetRandomIndex(fishes.length);
            randomFish = fishes[randomIndex];
        } while (randomFish == this || !randomFish.isAlive());
        return randomFish;
    }
}
