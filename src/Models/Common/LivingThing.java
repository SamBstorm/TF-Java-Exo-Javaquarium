package Models.Common;

public abstract class LivingThing implements ILivingThing{

    private int _age;
    private IAquaEnvironment _environment;

    @Override
    public int getAge() {
        return _age;
    }

    protected void setAge(int value) {
        if(value < 0) value = 0;
        _age = value;
        if(getAge() >= 20) setCurrentHP(0);
    }
    @Override
    public IAquaEnvironment getEnvironment() {
        return _environment;
    }

    @Override
    public void setEnvironment(IAquaEnvironment value) {
        _environment = value;
    }
    private int _currentHP;
    private int _maxHP;

    @Override
    public int getMaxHP() {
        return _maxHP;
    }
    private void setMaxHP(int value) {
        if(value <= 0) return; //throw Error...
        _maxHP = value;
        if(getMaxHP() < getCurrentHP()) setCurrentHP(getMaxHP());
    }

    @Override
    public int getCurrentHP() {
        return _currentHP;
    }

    private void setCurrentHP(int value) {
        if(value > _maxHP) value=_maxHP;
        else if(value < 0 ) value = 0;
        _currentHP = value;
    }

    public boolean isAlive(){
        return _currentHP > 0;
    }

    public LivingThing(){
        this(10,10,0);
    }
    public LivingThing(int age){
        this(age,10);
    }

    /*public LivingThing(int maxHP){
        this(maxHP,maxHP);
    }
    public LivingThing(int maxHP, int currentHP){
        this(maxHP,currentHP,0);
    }*/

    public LivingThing( int age, int currentHP){
        this(age,currentHP,10);
    }

    public LivingThing( int age, int currentHP, int maxHP){
        setMaxHP(maxHP);
        setCurrentHP(currentHP);
        setAge(age);
    }

    @Override
    public void lives() {
        this.setAge(this.getAge()+1);
    }

    @Override
    public void hurt(int damage){
        if(damage <= 0 ) return;
        setCurrentHP( getCurrentHP() - damage );
    }
    @Override
    public void heal(int healthPoint){
        if(healthPoint <= 0 ) return;
        setCurrentHP( getCurrentHP() + healthPoint );
    }

    @Override
    public abstract ILivingThing haveChild();

}
