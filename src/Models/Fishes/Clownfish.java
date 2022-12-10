package Models.Fishes;

import Models.Common.*;
import Models.Handlers.CustomRNG;

public class Clownfish extends MeatEaterFish implements IOpportunistHerma {
    public Clownfish(String name, Gender gender) {
        super(name, gender);
    }

    public Clownfish(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    @Override
    public ILivingThing haveChild() {
        return new Clownfish(CustomRNG.GetRandomName(), CustomRNG.GetRandomGender());
    }
}
