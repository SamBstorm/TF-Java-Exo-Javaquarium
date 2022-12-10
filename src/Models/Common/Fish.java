package Models.Common;

import Models.Handlers.CustomRNG;

import java.util.Arrays;

public abstract class Fish extends LivingThing implements IFish{

    private String _name;
    private Gender _gender;
    @Override
    public void setAge(int value) {
        super.setAge(value);
        if(this instanceof IHerma){
            if(getAge() > 10) _gender = Gender.Female;
            else _gender = Gender.Male;
        }
    }

    private boolean _isBusy;

    public void setIsBusy(boolean value){
        _isBusy = value;
    }
    public boolean getIsBusy(){
        return _isBusy;
    }

    public Fish(String name, Gender gender){
        this(name, gender, 0);
    }
    public Fish(String name,     Gender gender, int age){
        super(age);
        _name = name;
        if(!(this instanceof IHerma)) _gender = gender;
        _isBusy = false;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public Gender getGender() {
        return _gender;
    }

    @Override
    public abstract void eats(ILivingThing meal);

    @Override
    public void lives() {
        super.lives();
        this.hurt(1);
        if(!this.isAlive()) return;
        System.out.printf("%s : Je vie!", this.getName());
        System.out.println();
        if(!getIsBusy()){
            this.setIsBusy(true);
            if(this.getCurrentHP() <= 5){
                System.out.printf("%s : J'ai faim!", this.getName());
                System.out.println();
                ILivingThing meal = this.chooseMeal();
                if(meal != null) this.eats(meal);
            }
            else {
                System.out.printf("%s : Je suis en forme!", this.getName());
                System.out.println();
                IFish partner = choosePartner();
                if(partner == null){
                    System.out.printf("%s : Je me sens seule...", this.getName());
                    System.out.println();
                    return;
                }
                if (!partner.getIsBusy() && this.getClass().equals(partner.getClass())){
                    if (this instanceof IOpportunistHerma)
                        switch (partner.getGender()){
                            case Male : this._gender = Gender.Female;
                                        break;
                            case Female: this._gender = Gender.Male;
                                        break;
                        }
                    if (this.getGender() != partner.getGender()) {
                        partner.setIsBusy(true);
                        ILivingThing child = haveChild();
                        getEnvironment().addLiving(child);
                    }
                }
                else{

                    System.out.printf("%s : Zut! Pas le bon partenaire...", this.getName());
                    System.out.println();
                }
            }
        }
        else{
            System.out.printf("%s : Je ne peux rien faire, je suis occupé...", this.getName());
            System.out.println();
        }
    }
    protected abstract ILivingThing chooseMeal();
    protected IFish choosePartner(){
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

    @Override
    public abstract ILivingThing haveChild();
}
