package Models.Fishes;

import Models.Common.*;
import Models.Handlers.CustomRNG;

public class Carp extends WeedEaterFish implements IMonosexed {
    public Carp(String name, Gender gender) {
        super(name, gender);
    }

    public Carp(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    @Override
    public ILivingThing haveChild() {
        return new Carp(CustomRNG.GetRandomName(), CustomRNG.GetRandomGender());
    }
}
