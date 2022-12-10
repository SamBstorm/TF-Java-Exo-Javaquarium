package Models.Fishes;

import Models.Common.*;
import Models.Handlers.CustomRNG;

public class Tuna extends MeatEaterFish implements IMonosexed {

    public Tuna(String name, Gender gender) {
        super(name, gender);
    }

    public Tuna(String name, Gender gender, int age) {
        super(name, gender, age);
    }
    @Override
    public ILivingThing haveChild() {
        return new Tuna(CustomRNG.GetRandomName(), CustomRNG.GetRandomGender());
    }
}
