import java.util.Scanner;
public class Player extends NPC
{
  Scanner kb = new Scanner(System.in);
  int myHealth = 20;
  boolean flying = false; //for the fly spell: the opponent's next attack misses
  boolean focused = false; //for the focus spell: makes the player's next attack more likely to hit
  boolean spells[][] = new boolean[][]{
    {false, false},
    {false, false},
    {false, false}
  };
  
  String newSpells[][] = new String[][]{
    {"blast", "laser"}, 
    {"focus", "fly"},
    {"drain", "corrupt"}
  };
  
  public Player()
  {
  }
  
  /*updates the player's spells based on monster killed
   */
  public void spellbook(int row, int col)
  {
    if (col > 0)
    {
      spells[row][col] = true;
      System.out.println("You learned the spell: " + newSpells[row][col] + "!");
    }
  }
  
  public void play(NPC enemy)
  {
    String turn = kb.nextLine();
    if (turn.equals("fireball")) this.fireball(enemy);
    else if (turn.equals("icebeam")) this.icebeam(enemy);
    else if (turn.equals("thunder")) this.thunder(enemy);
    else if (turn.equals("poison")) this.poison(enemy);
    else if (turn.equals("heal")) this.heal();
    else if (turn.equals("fly") && spells[1][1] == true) this.fly();
    else if (turn.equals("focus") && spells[1][0] == true) this.focus();
    else if (turn.equals("blast")) this.blast(enemy);
    else
    {
      System.out.println("You suffer a headache as you attempt to draw upon mystical knowledge unavailable to you.");
    }
  }
  
  public void takeDamage(int damage) //methods to lower class health
  {
    if (flying == true)
    {
      System.out.println("The opponent can't reach you while you're up in the air, and deals no damage.");
      if (super.d20() > 10)
      {
        flying = false;
        System.out.println("You fall gently back to the ground.");
      }
    }
    else
    {
      myHealth -= damage;
      System.out.println("You have " + myHealth + " health left.");
    }
  }
  
  
  
  public int getHealth()
  {
    return myHealth;
  }
  
  
  
  
  public void fireball(NPC enemy) //straight damage, with a small chance of doing massive continual damage
  {
    int damage;
    if (super.d20() > 7)
    {
      damage = super.d10();
      System.out.println("You send a fireball forth which crashes into your foe for " + damage + " damage.");
      enemy.takeDamage(damage);
      if (super.d20() > 10)
      {
        System.out.println("You light the enemy on fire!");
        enemy.becomeOnFire();
      }
    }
    else 
    {
      if (focused == true)
      {
        this.fireball(enemy);
        System.out.println("Your keen mind makes your spells more accurate.");
        if (super.d20() < 10) 
        {
          focused = false;
          System.out.println("You are no longer focused.");
        }
      }
      else
      {
        damage = 0;
        System.out.println("The fireball misses its target.");
      }
    }
  }
  
  
  
  public void icebeam(NPC enemy) //deals straight damage with a chance of immobilizing the enemy
  {
    int damage;
    int roll = super.d20();
    if (roll > 7)
    {
      damage = super.d10();
      System.out.println("An icebeam bursts from your hands dealing " + damage + " damage to the enemy.");
      enemy.takeDamage(damage);
      if (roll > 13)
      {
        System.out.println("You froze the enemy in its tracks!");
        enemy.becomeImmobilized();
      }
    }
    else 
    {
      if (focused == true)
      {
        this.icebeam(enemy);
        System.out.println("Your keen mind makes your spells more accurate.");
        if (super.d20() < 10) 
        {
          focused = false;
          System.out.println("You are no longer focused.");
        }
      }
      else
      {
        damage = 0;
        System.out.println("The icebeam misses its target.");
      }
    }
  }
  
  
  
  
  public void thunder(NPC enemy) //thunder always deals straight damage with a chance of doing extra damage
  {
    int damage;
    int roll = super.d20();
    if (roll > 7)
    {
      damage = super.d10();
      System.out.println("You send a bolt of lightning at your opponent for " + damage + " damage.");
      enemy.takeDamage(damage);
    }
    else if (roll == 20)
    {
      damage = 20;
      System.out.println("You snend a massive bolt of lightning at your opponent for " + damage + " damage.");
      enemy.takeDamage(damage);
    }
    else if (roll <= 7)
    {
      if (focused == true)
      {
        this.thunder(enemy);
        System.out.println("Your keen mind makes your spells more accurate.");
        if (super.d20() < 10) 
        {
          focused = false;
          System.out.println("You are no longer focused.");
        }
      }
      else
      {
        damage = 3;
        System.out.println("You send a weaker lightning bold at your enemy for " + damage + " damage.");
        enemy.takeDamage(damage);
      }
    }
  }
  
  
  
  public void poison(NPC enemy) //large chance of doing small continuous damage
  {
    int damage;
    int roll = super.d20();
    if (roll > 10)
    {
      damage = super.d6();
      System.out.println("From your hands, a wave of poison washes over your opponent for " + damage + " damage.");
      enemy.takeDamage(damage);
    }
    if (roll > 5)
    {
      enemy.becomePoisoned();
      System.out.println("Poison courses throughout the opponents body.");
    }
    else
    {
      if (focused == true)
      {
        this.poison(enemy);
        System.out.println("Your keen mind makes your spells more accurate.");
        if (super.d20() < 10) 
        {
          focused = false;
          System.out.println("You are no longer focused.");
        }
      }
      else
      {
        damage = 0;
        System.out.println("Your poison spell fails.");
      }
    }
  }
  
  
  
  public void heal() //method for the player to heal himself
  {
    int regen = super.d10() + 2;
    myHealth += regen;
    System.out.println("You gain " + regen + " health.");
    if (myHealth > 50)
    {
      System.out.println("You gain too much health and explode.");
      myHealth = 0;
    }
  }
  
  
  
  public void fly() //method to fly and dodge attacks
  {
    flying = true;
    System.out.println("You rise up into the air above your opponent.");
  }
  
  
  
  public void focus() //spell makes the player more likely to hit
  {
    focused = true;
    System.out.println("Your eyes emit an arcane glow as you focus on your next move.");
  }
  
  public void blast(NPC enemy) //innacurate spell that does a lot of damage if it hits
  {
    {
    int damage;
    int roll = super.d20();
    if (roll > 15)
    {
      damage = super.d20() + super.d20();
      System.out.println("Your enemy recoils as you send a huge shockwave hurtling from your palm for " + damage + " damage.");
      enemy.takeDamage(damage);
    }
    else if (roll == 20)
    {
      damage = 40;
      System.out.println("The earth shakes as your shockwave deals colossal damage to your enemy.");
      enemy.takeDamage(damage);
    }
    else
    {
      if (focused == true)
      {
        this.blast(enemy);
        System.out.println("Your keen mind makes your spells more accurate.");
        if (super.d20() < 10) 
        {
          focused = false;
          System.out.println("You are no longer focused.");
        }
      }
      else
      {
        damage = 0;
        System.out.println("Your innacurate blast misses the opponent.");
      }
    }
  }
  }
}