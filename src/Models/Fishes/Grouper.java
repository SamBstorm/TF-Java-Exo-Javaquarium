package Models.Fishes;

import Models.Common.*;
import Models.Handlers.CustomRNG;

public class Grouper extends MeatEaterFish implements IHerma {
    public Grouper(String name, Gender gender) {
        super(name, gender);
    }

    public Grouper(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    @Override
    public ILivingThing haveChild() {
        return new Grouper(CustomRNG.GetRandomName(), CustomRNG.GetRandomGender());
    }
}
