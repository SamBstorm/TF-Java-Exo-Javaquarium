package Models.Common;

public interface ILivingThing {
    int getMaxHP();
    int getAge();
    int getCurrentHP();
    IAquaEnvironment getEnvironment();
    void setEnvironment(IAquaEnvironment value);
    boolean isAlive();
    void lives();
    void hurt(int damage);
    void heal(int healthPoint);

    ILivingThing haveChild();
}
