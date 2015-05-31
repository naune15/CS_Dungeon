public class NPC
{
  int myHealth = 1;
  String name = "NPC";
  boolean onFire = false;
  boolean poisoned = false;
  boolean immobilized = false;
  public NPC()
  {
  }
  
  
  public int getHealth() //methods to keep track of class variables
  {
    return myHealth;
  }
  
  public String getName()
  {
    return name;
  }
  
  
  
  public void takeDamage(int damage) //methods to lower class variables
  {
    myHealth -= damage;
    System.out.println("The " + name + " takes " + damage + " damage.");
    System.out.println("The " + name + " has " + myHealth + " HP.");
  }
  
  public void becomeOnFire() //methods to change conditions
  {
    onFire = true;
  }
  public void becomePoisoned()
  {
    poisoned = true;
  }
  public void becomeImmobilized()
  {
    immobilized = true;
  }
  
  public boolean isOnFire() //methods keep track of conditions
  {
    return onFire;
  }
  public boolean isImobilized()
  {
    return immobilized;
  }
  public boolean isPoisoned()
  {
    return poisoned;
  }
  
  public void reverseOnFire() //methods to reverse conditions
  {
    onFire = false;
  }
  public void reverseImmobilized()
  {
    immobilized = false;
  }
  
  public static int d4() //methods to produce random numbers
  {
    return (int)((Math.random() * 4) + 1);
  }
  public static int d6()
  {
    return ((int)(Math.random() * 6) + 1);
  }
  public static int d8()
  {
    return ((int)(Math.random() * 8) + 1);
  }
  public static int d10()
  {
    int output = ((int)(Math.random() * 10) + 1);
    return output;
  }
  public static int d12()
  {
    return ((int)(Math.random() * 12) + 1);
  }
  public static int d20()
  {
    return (int)((Math.random() * 20) + 1);
  }
}