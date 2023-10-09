public class GameMaster {

    public static Player player;
    public static Monster monster;

    static {
        player = new Player(
                (int) randomizer(0, 30),
                (int) randomizer(0, 30),
                randomizer(50, 150),
                (int) randomizer(0, 6),
                (int) randomizer(7, 12)
        );
        monster = new Monster(
                (int) randomizer(0, 30),
                (int) randomizer(0, 30),
                randomizer(50, 150),
                (int) randomizer(0, 6),
                (int) randomizer(7, 12)
        );
    }

    public static String showStats() {
        return  "Статы игрока:\n" +
                "Здоровье " + GameMaster.player.getHealth() + "\n" +
                "Атака " + GameMaster.player.getAttack() + "\n" +
                "Защита " + GameMaster.player.getDefence() + "\n\n" +
                "Статы Монстра:\n " +
                "Здоровье " + GameMaster.monster.getHealth() + "\n" +
                "Атака " + GameMaster.monster.getAttack() + "\n" +
                "Защита " + GameMaster.monster.getDefence();
    }

    private static double randomizer(int min, int max) {
        return (Math.random() * ((max - min) + 1) + min);
    }

    public static int attackMod(Creature attacker, Creature defender) {
        int attackMod = attacker.getAttack() - defender.getDefence() + 1;
        if (attackMod <= 0) {
            return 1;
        } else {
            return attackMod;
        }
    }

    public static boolean roll(int count) {
        while (count > 0) {
            if ((int) randomizer(0, 6) > 4) {
                return true;
            }
            count--;
        }
        return false;
    }

    public static double hit(Creature attacker, Creature defender) {
        defender.setHealth(defender.getHealth() - attacker.getDamage());
        return defender.getHealth();
    }
}
