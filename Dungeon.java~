import java.util.Scanner;
public class Dungeon
{
  public static void main (String[] args)
  {
    Scanner kb = new Scanner(System.in);
    Player player = new Player();
    int count = 0;
    Class monsters[][] = new Class[][]{
      {Goblin, Bugbear, Bear, Minotaur, Beholder}, 
      {Kobold, Bandit, Orc, Drake, Dragon},
      {Imp, Zombie, Demon, Vampire, Lich} 
    };
    if (count == 0) System.out.println("You arrive at the entrance to the dungeon.");
    while (count < 5)
    {
      Monster a = monsters[0][0];
      Monster enemy = a;
      System.out.println("A wild " + enemy.getName() + " appears!");
      while (player.getHealth() > 0 && enemy.getHealth() > 0)
      {
        System.out.println("What do you do?");
        player.play(enemy);
        enemy.randomAttack(player);
      }
      if (enemy.getHealth() <= 0)
      {
        count++;
        System.out.println("You've defeated the " + enemy.getName() + "!");
      }
      else if (player.getHealth() <= 0)
      {
        System.out.println("You are dead.");
      }
    }
    System.out.println("You've won!");
  }
}