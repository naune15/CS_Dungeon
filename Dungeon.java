import java.util.Scanner;
public class Dungeon
{
  public static void main (String[] args)
  {
    Scanner kb = new Scanner(System.in);
    Player player = new Player();
    int count = 0;
    int superCount = 0;
    String monsters[][] = new String[][]{
      {"Goblin", "Bugbear", "Bear", "Minotaur", "Beholder"}, 
      {"Kobold", "Bandit", "Orc", "Drake", "Dragon"},
      {"Imp", "Zombie", "Demon", "Vampire", "Lich"} 
    };
    if (count == 0) System.out.println("You arrive at the entrance to a dungeon.");
    while (count < 5) //keeps track of the monsters defeated
    {
      String monsterName = monsters[(int)((Math.random() * 3) + 1)][count]; //generates a random monster from the matrix above
      Monster enemy = new Monster(count, monsterName);
      System.out.println("A wild " + enemy.getName() + " appears!");
      while (player.getHealth() > 0 && enemy.getHealth() > 0) //combat!!
      {
        System.out.println("What do you do?"); 
        player.play(enemy); //player goes first
        if (!enemy.isImobilized()) enemy.randomAttack(player); //then enemy goes if not immobilized
        else 
        {
          enemy.reverseImmobilized();
        }
        //SERIES OF STATEMENTS KEEP TRACK OF ONGOING EFFECTS
        if (enemy.isOnFire()) enemy.takeDamage(5); //if enemy is on fire, takes damage
        //if enemy is poisoned, take not as much damage
      }
      if (enemy.getHealth() <= 0)
      {
        count++;
        System.out.println("You've defeated the " + enemy.getName() + "!");
        System.out.println("You progress to the next stage of the dungeon.");
      }
      else if (player.getHealth() <= 0)
      {
        System.out.println("You are dead.");
      }
    }
    if (count == 5)
    {
      System.out.println("You've won!");
      count = 0;
      superCount++;
    }
    if (superCount == 3) System.out.println("Congratulations, you are a Master Wizard!");
  }
}