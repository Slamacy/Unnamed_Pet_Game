package petGame;
import java.util.Scanner;

public class Pet
{
    private String name;
    private String gender;
    private String species;
    private int hunger;
    private int fatigue;
    private int boredom;
    private int hygiene;
    private boolean dead;
    private int happiness;
    
    //Constructor
    public Pet(String name, String species, String gender, int hunger, int happiness, int fatigue, int boredom, int hygiene,  boolean dead)
    {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.hunger = hunger;
        this.happiness = happiness;
        this.fatigue = fatigue;
        this.boredom = boredom;
        this.hygiene = hygiene;
        this.dead = dead;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return this.gender;
    }

    public void setSpecies(String species)
    {
        this.species = species;
    }

    public String getSpecies()
    {
        return this.species;
    }

    public void setHunger(int hunger)
    {
        this.hunger = hunger;
    }

    public int getHunger()
    {
        return this.hunger;
    }

    public void setFatigue(int fatigue)
    {
        this.fatigue = fatigue;
    }

    public int getFatigue()
    {
        return this.fatigue;
    }

    public void setBoredom(int boredom)
    {
        this.boredom = boredom;
    }

    public int getBoredom()
    {
        return this.boredom;
    }

    public void setHygiene(int hygiene)
    {
        this.hygiene = hygiene;
    }

    public int getHygiene()
    {
        return this.hygiene;
    }
    
    public void setDead(boolean dead)
    {
        this.dead = dead;
    }
    
    public boolean getDead()
    {
        return this.dead;
    }
    
    public void setHappiness(int happiness)
    {
        this.happiness = happiness;
    }
    
    public int getHappiness()
    {
        return this.happiness;
    }
    
    public void playWithPet(Item toy)
    {   
        //Math.min returns the lowest value of the two arguments. This ensures the values do not increase past 100
        
        setFatigue(Math.min(getFatigue() + toy.getFatigue(), 100)); //Increases fatigue
        setHappiness(Math.min(getHappiness() + toy.getHappiness(), 100)); //Increases happiness
        setBoredom(Math.max(getBoredom() - toy.getBoredom(), 0)); //Decreases boredom
        
        System.out.println(toString());
    }
    
    public void feedPet(Item food)
    {
        setHappiness(Math.min(getHappiness() + food.getHappiness(), 100)); //Increases happiness
        setHunger(Math.max(getHunger() - food.getFeeding(), 0)); //Decreases hunger
        setHygiene(Math.max(getHygiene() - food.getHygine(), 0)); //Decreases hygiene
        setFatigue(Math.min(getFatigue() + food.getFatigue(), 100)); //Increases fatigue
        
        System.out.println(toString());
    }
    
    public void washPet(Item wash)
    {
        setHappiness(Math.min(getHappiness() + wash.getHappiness(), 100)); //Increases happiness
        setHygiene(Math.min(getHygiene() + wash.getHygine(), 100)); //Increases hygiene
    
        System.out.println(toString());
    }
    
    public  void restPet(Item rest)
    {
        setHappiness(Math.min(getHappiness() + rest.getHappiness(), 100)); //Increases happiness
        setFatigue(Math.max(getFatigue() - rest.getFatigue(), 0)); //Decreases fatigue
    
        System.out.println(toString());
    }
    
    public void checkHappiness()
    {
        String happinessStatus;

        if(getHappiness() >= 0 && getHappiness() <= 25)
        {
            happinessStatus = "miserable";
        }
        else if(getHappiness() >= 26 && getHappiness() <= 50)
        {
         happinessStatus = "unhappy";
        }
        else if(getHappiness() >= 51 && getHappiness() <= 75)
        {
            happinessStatus = "fine";
        }
        else
        {
            happinessStatus = "thrilled";
        }
        
        System.out.println("Happiness: " + happinessStatus);
    }
    
    public void checkHunger()
    {
        String hungerStatus;

        if(getHunger() >= 0 && getHunger() <= 25)
        {
            hungerStatus = "full";
        }
        else if(getHunger() >= 26 && getHunger() <= 50)
        {
         hungerStatus = "peckish";
        }
        else if(getHunger() >= 51 && getHunger() <= 75)
        {
            hungerStatus = "hungry";
        }
        else
        {
            hungerStatus = "starving";
        }
        
        System.out.println("Hunger: " + hungerStatus);
    }
    
    public void checkFatigue()
    {
        String fatigueStatus;

        if(getFatigue() >= 0 && getFatigue() <= 25)
        {
            fatigueStatus = "full of energy";
        }
        else if(getFatigue() >= 26 && getFatigue() <= 50)
        {
         fatigueStatus = "normal";
        }
        else if(getFatigue() >= 51 && getFatigue() <= 75)
        {
            fatigueStatus = "tired";
        }
        else
        {
            fatigueStatus = "exhausted";
        }
        
        System.out.println("Energy: " + fatigueStatus);
    }
    
    public void checkBoredom()
    {
        String boredomStatus;

        if(getBoredom() >= 0 && getBoredom() <= 25)
        {
            boredomStatus = "entertained";
        }
        else if(getBoredom() >= 26 && getBoredom() <= 50)
        {
         boredomStatus = "a little fed up";
        }
        else if(getBoredom() >= 51 && getBoredom() <= 75)
        {
            boredomStatus = "bored";
        }
        else
        {
            boredomStatus = "totally fed up";
        }
        
        System.out.println("Boredom: " + boredomStatus);
    }
    
    public void checkHygiene()
    {
        String hygieneStatus;

        if(getHygiene() >= 0 && getHygiene() <= 25)
        {
            hygieneStatus = "filthy!";
        }
        else if(getFatigue() >= 26 && getFatigue() <= 50)
        {
         hygieneStatus = "starting to smell...";
        }
        else if(getFatigue() >= 51 && getFatigue() <= 75)
        {
            hygieneStatus = "clean";
        }
        else
        {
            hygieneStatus = "sparkling clean!";
        }
        
        System.out.println("Hygiene: " + hygieneStatus);
    }
    
    public void displayStats() {
        System.out.println("\n ***** Displaying Pet Stats *****");
        System.out.println(toString());
        checkHappiness();
        checkHunger();
        checkFatigue();
        checkBoredom();
        checkHygiene();
    }
    
    public String toString()
    {
        return "{Name: " + this.name + ", Gender: " + this.gender + ", Species: " + this.species + ", Hunger: " + this.hunger + ", Fatigue: " + 
                this.fatigue + ", Boredom: " + this.boredom + ", Hygiene: " + this.hygiene + ", Dead: " + this.dead + 
                ", Happiness: " + this.happiness + "}" ;
    }
}
