public abstract class Creature {
    public final int attack;
    public final int defence;
    public double health;

    final int minDamage;

    private final int maxDamage;

    public Creature(int attack, int defence, double health, int minDamage, int maxDamage) {
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDamage() {
        return Math.random() * ((maxDamage - minDamage) + 1) + minDamage;
    }
}
