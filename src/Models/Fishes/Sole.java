package Models.Fishes;

import Models.Common.*;
import Models.Handlers.CustomRNG;

public class Sole extends WeedEaterFish implements IOpportunistHerma {
    public Sole(String name, Gender gender) {
        super(name, gender);
    }

    public Sole(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    @Override
    public ILivingThing haveChild() {
        return new Sole(CustomRNG.GetRandomName(), CustomRNG.GetRandomGender());
    }
}
