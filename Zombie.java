public class Zombie extends Monster
{
  int myHealth = 5;
  String myName = "zombie";
  public void randomAttack(Player player) //determines randomly which attack the monster will use
  {
    int temp = (int)(Math.random() * 4 + 1);
    if (temp > 0)
    {
      this.attackA(player);
    }
    else if (temp > 1)
    {
      this.attackB(player);
    }
    else if (temp > 2)
    {
      this.attackC(player);
    }
    else if (temp > 3)
    {
      this.attackD(player);
    }
  }
  public void attackA(Player player)
  {
    int damage;
    if (super.d20() > 5)
    {
      damage = super.d4();
      System.out.println("The " + name + " clubs you for " + damage + " damage.");
    }
    else
    {
      damage = 0;
      System.out.println("The monster misses with his attack.");
    }
    player.takeDamage(damage);
  }
  
  public void attackB(Player player)
  {
    int damage;
    if (super.d20() > 8)
    {
      damage = super.d6();
      System.out.println("The " + name + " bites you for " + damage + " damage.");
    }
    else
    {
      damage = 0;
      System.out.println("The monster misses with his attack.");
    }
    player.takeDamage(damage);
  }
  
  public void attackC(Player player)
  {
    int damage;
    if (super.d20() > 10)
    {
      damage = super.d8();
      System.out.println("The " + name + " stabs you for " + damage + " damage.");
    }
    else
    {
      damage = 0;
      System.out.println("The monster misses with his attack.");
    }
    player.takeDamage(damage);
  }
  
  public void attackD(Player player)
  {
    int damage;
    if (super.d20() > 15)
    {
      damage = super.d8();
      System.out.println("The " + name + " torches you for " + damage + " damage.");
    }
    else
    {
      damage = 0;
      System.out.println("The monster misses with his attack.");
    }
    player.takeDamage(damage);
  }
  
  public void takeDamage(int damage) //methods to lower class variables
  {
    myHealth -= damage;
    System.out.println("The " + name + " takes " + damage + " damage.");
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