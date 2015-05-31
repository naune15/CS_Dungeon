public class Monster extends NPC
{
  int myHealth;
  String name = "";
  int myCol; //values keep track of where monster is on the matrix
  int myRow;
  boolean onFire = false;
  boolean poisoned = false;
  boolean immobilized = false;
  public Monster(int count, String monsterName, int monsterCol, int row)
  {
    myHealth = (super.d20() * count);
    name = monsterName;
    myCol = monsterCol;
    myRow = row;
  }
  
  
  
  public void randomAttack(Player player, int count) //determines randomly which attack the monster will use
  {
    int temp = (int)(Math.random() * 4 + 1);
      if (temp > 0)
    {
      this.attackA(player, count);
    }
    else if (temp > 1)
    {
      this.attackB(player, count);
    }
    else if (temp > 2)
    {
      this.attackC(player, count);
    }
    else if (temp > 3)
    {
      this.attackD(player, count);
    }
  }
 public void attackA(Player player, int count)
  {
    int damage;
    if (super.d20() > 5)
    {
      damage = super.d4() + count;
      System.out.println("The " + name + " attacks you for " + damage + " damage.");
      System.out.println("The " + name + " has " + myHealth + " health."); // Mr. K. debug code
      player.takeDamage(damage);
    }
    else
    {
      damage = 0;
      System.out.println("The monster misses with his attack.");
    }
  }
  
  public void attackB(Player player, int count)
  {
    int damage;
    if (super.d20() > 8)
    {
      damage = super.d6() + count;
      System.out.println("The " + name + " attacks you for " + damage + " damage.");
      System.out.println("The " + name + " has " + myHealth + " health."); // Mr. K. debug code
      player.takeDamage(damage);
    }
    else
    {
      damage = 0;
      System.out.println("The " + name + " misses with his attack.");
    }
  }
  
  public void attackC(Player player, int count)
  {
    int damage;
    if (super.d20() > 10)
    {
      damage = super.d8() + count;
      System.out.println("The " + name + " attacks you for " + damage + " damage.");
      System.out.println("The " + name + " has " + myHealth + " health."); // Mr. K. debug code
      player.takeDamage(damage);
    }
    else
    {
      damage = 0;
      System.out.println("The monster misses with his attack.");
    }
  }
  
  public void attackD(Player player, int count)
  {
    int damage;
    if (super.d20() > 15)
    {
      damage = super.d8() + count;
      System.out.println("The " + name + " attacks you for " + damage + " damage.");
      System.out.println("The " + name + " has " + myHealth + " health."); // Mr. K. debug code
      player.takeDamage(damage);
    }
    else
    {
      damage = 0;
      System.out.println("The monster misses with his attack.");
    }
  }
  
  public void takeDamage(int damage, String turn) //methods to lower class variables
  {
    myHealth -= damage;
    System.out.println("The " + name + " has " + myHealth + " health.");
  }
  
  public int getHealth() //methods to keep track of class variables
  {
    return myHealth;
  }
  
  public String getName()
  {
    return name;
  }
}