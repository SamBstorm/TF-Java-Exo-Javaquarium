package Models.Common;

public interface IFish extends ILivingThing{
    String getName();
    Gender getGender();

    boolean getIsBusy();
    void setIsBusy(boolean value);

    void eats(ILivingThing meal);

}
