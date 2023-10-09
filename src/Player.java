public class Player extends Creature {

    public int countHeal = 4;

    public final double healing = health * 0.3;

    public Player(int attack,
                  int defence,
                  double health,
                  int minDamage,
                  int maxDamage) {
        super(attack, defence, health, minDamage, maxDamage);
    }

    public void healthYourSelf() {
        if (countHeal > 0) {
            health = health + healing;
        }
    }


}
