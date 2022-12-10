package Models;

import Models.Common.IEnvironment;
import Models.Common.ILivingThing;
import Models.Common.ISeaweed;
import Models.Common.LivingThing;

public class Seaweed extends LivingThing implements ISeaweed {
    public Seaweed(int age) {
        super(age);
    }
    public Seaweed(int age, int currentHP) {
        super(age,currentHP);
    }
    public Seaweed() {
        this(0);
    }

    @Override
    public void lives() {
        super.lives();
        if(!this.isAlive()) return;
        System.out.println("Alge : Je vie!");
        this.heal(1);
        if(getCurrentHP()>=10) {
            ILivingThing child = haveChild();
            getEnvironment().addLiving(child);
        }
    }

    @Override
    public ILivingThing haveChild() {
        int hp = this.getCurrentHP()/2;
        hurt(hp);
        return new Seaweed(0,hp);
    }
}
