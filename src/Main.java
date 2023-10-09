import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра началась!");
        System.out.println(GameMaster.showStats());

        while (true) {
            System.out.println("Ход игрока. Введите \"atk\" для атаки или \"h\" для лечения.");
            while (true) {
                String cmd = scanner.nextLine();
                if (cmd.equals("atk")) {
                    int attackMod = GameMaster.attackMod(GameMaster.player, GameMaster.monster);
                    if (GameMaster.roll(attackMod)) {
                        double monsterHealth = GameMaster.hit(GameMaster.player, GameMaster.monster);
                        if (monsterHealth <= 0) {
                            System.out.println("Монстр умер, игра окончена!");
                            return;
                        }
                        System.out.println("Нанесён урон! Здоровье монстра:" + GameMaster.monster.getHealth());
                        break;
                    } else {
                        System.out.println("Вы промахнулись!");
                    }
                } else if (cmd.equals("h")) {
                    GameMaster.player.healthYourSelf();
                    System.out.println("Ваше здоровье:" + GameMaster.player.getHealth());
                    break;
                } else {
                    System.out.println("Неверная команда, повторите ввод.");
                }
            }

            System.out.println("Ход монстра!");
            int attackMod = GameMaster.attackMod(GameMaster.monster, GameMaster.player);
            if (GameMaster.roll(attackMod)) {
                double playerHealth = GameMaster.hit(GameMaster.monster, GameMaster.player);
                if (playerHealth <= 0) {
                    System.out.println("Игрок умер, игра окончена!");
                    return;
                }
                System.out.println("Нанесён урон! Здоровье игрока:" + GameMaster.player.getHealth());
            } else {
                System.out.println("Монстр промахнулся!");
            }
        }
    }
}