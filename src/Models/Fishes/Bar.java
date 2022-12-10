package Models.Fishes;

import Models.Common.*;
import Models.Handlers.CustomRNG;

public class Bar extends WeedEaterFish implements IHerma {
    public Bar(String name, Gender gender) {
        super(name, gender);
    }

    public Bar(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    @Override
    public ILivingThing haveChild() {
        return new Bar(CustomRNG.GetRandomName(),CustomRNG.GetRandomGender());
    }
}
