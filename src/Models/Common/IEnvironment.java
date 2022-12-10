package Models.Common;

public interface IEnvironment {
    ILivingThing[] getPopulation();
    void addLiving(ILivingThing living);
}
