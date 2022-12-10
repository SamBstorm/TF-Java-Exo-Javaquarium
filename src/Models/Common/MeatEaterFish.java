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
        ILivingThing randomFish;
        do {
            int randomIndex = CustomRNG.GetRandomIndex(getEnvironment().getFishes().length);
            randomFish = getEnvironment().getFishes()[randomIndex];
        } while (randomFish == this || !randomFish.isAlive());
        return randomFish;
    }
}
