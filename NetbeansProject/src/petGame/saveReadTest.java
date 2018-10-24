package petGame;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.Writer;

public class saveReadTest {
    static Shop shop = new Shop();
    static long time;
    static int money = 0;
    static Inventory inv = new Inventory("Inventory"); //creates inventory object
    static File save = new File("save.txt"); //imports file used for saving data
    static Pet pet = new Pet("Bloofe", "Female", "Bird", 0, 0, 0, 0, 0, false);
    static Pet pet2 = new Pet("AAAA", "AAA", "AA", 100, 100, 100, 100, 100, true);
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //first, build all of the game's items
        //the game's food items
        Item meat = new Item ("Meat", "food", 25, 75, 20, 50, 1000);
        Item fruitAndVeg = new Item ("Fruit & Vegetables", "food", 15, 50, 10, 20, 1000);
        Item insects = new Item ("Insects", "food", 15, 35, 40, 15, 850);
        Item seeds = new Item ("Seeds", "food", 20, 40, 15, 15, 900);
        Item milk = new Item ("Milk", "food", 40, 60, 25, 40, 1250);
        //the game's hygiene items
        Item luxShampoo = new Item ("Luxury Shampoo", "hygiene", 25, 50, 2500);
        Item luxSoap = new Item ("Luxury Soap", "hygiene", 20, 30, 2000);
        Item luxTowel = new Item ("Luxury Towel", "hygiene", 30, 15, 2250);
        Item wipes = new Item ("Wipes", "hygiene", 25, 35, 2000);
        Item toothbrush = new Item ("Toothbrush", "hygiene", 20, 35, 2500);
        //the game's resting items
        Item dogBed = new Item ("Dog Bed", "resting", 50, 70, 50, 4000);
        Item catHouse = new Item ("Cat House", "resting", 55, 70, 45, 4000);
        Item birdHouse = new Item ("Bird House", "resting", 45, 60, 40, 3500);
        Item giantLily = new Item ("Giant Lily Pad", "resting", 60, 65, 40, 4500);
        Item grassBed = new Item ("Grass Bed", "resting", 40, 55, 40, 2750);
        //the game's toy items
        Item rubberBone = new Item (35, "toy", 45, 30, 2500, "Rubber Bone");
        Item plushMouse = new Item (40, "toy", 50, 45, 3000, "Plush Mouse");
        Item plasticRings = new Item (30, "toy", 40, 25, 2000, "Plastic Rings");
        Item kiddiePool = new Item (50, "toy", 60, 50, 4000, "Kiddie Pool");
        Item toyCarrot = new Item (30, "toy", 40, 25, 2250, "Toy Carrot");
        //add them all to shop's array list
        shop.getStock().add(meat);
        shop.getStock().add(fruitAndVeg);
        shop.getStock().add(insects);
        shop.getStock().add(seeds);
        shop.getStock().add(milk);
        shop.getStock().add(luxShampoo);
        shop.getStock().add(luxSoap);
        shop.getStock().add(luxTowel);
        shop.getStock().add(wipes);
        shop.getStock().add(toothbrush);
        shop.getStock().add(dogBed);
        shop.getStock().add(catHouse);
        shop.getStock().add(birdHouse);
        shop.getStock().add(giantLily);
        shop.getStock().add(grassBed);
        shop.getStock().add(rubberBone);
        shop.getStock().add(plushMouse);
        shop.getStock().add(plasticRings);
        shop.getStock().add(kiddiePool);
        shop.getStock().add(toyCarrot);
        
        //inv.add(meat);
        //inv.add(fruitAndVeg);
        //inv.add(insects);
        //inv.add(seeds);
        //inv.add(milk);
        //inv.add(luxShampoo);
        //inv.add(luxSoap);
        //inv.add(luxTowel);
        //inv.add(wipes);
        //inv.add(toothbrush);
        //inv.add(dogBed);
        //inv.add(catHouse);
        //inv.add(birdHouse);
        //inv.add(giantLily);
        //inv.add(grassBed);
        //inv.add(rubberBone);
        //inv.add(plushMouse);
        //inv.add(plasticRings);
        //inv.add(kiddiePool);
        //inv.add(toyCarrot);
        
        save();
        readSave();
        displaySavedData();
    }
    
    public static void save() throws FileNotFoundException, IOException {
        Writer saveData;
        FileWriter addToFile = new FileWriter(save, false);
        saveData = new BufferedWriter(addToFile);
        //int invSize = inv.getInventory().size();
        
        saveData.write(pet.getName());                      //the following lines write the pet's attributes/stats to a txt file
        saveData.write("\n" + pet.getSpecies());
        saveData.write("\n" + pet.getGender());
        saveData.write("\n" + pet.getHunger());
        saveData.write("\n" + pet.getHappiness());
        saveData.write("\n" + pet.getFatigue());
        saveData.write("\n" + pet.getBoredom());
        saveData.write("\n" + pet.getHygiene());
        saveData.write("\n" + pet.getDead());               //:C
        saveData.write("\n" + inv.getSize());               //gets inventory size
        for (int i = 0; i < inv.getSize(); i++) {
            saveData.write("\n" + inv.getNameOfItem(i));    //writes all items in inventory to the file
        }
        saveData.write("\n" + System.currentTimeMillis());
        saveData.write("\n" + money);
        saveData.close();
        System.out.println("Your data has been saved.");
    }
    
    public static void readSave() throws FileNotFoundException, IOException {
        int invSize;
        Scanner reader = new Scanner(save); //reads the file lines
        
        pet2.setName(reader.nextLine());     //these lines take the values from the file and assigns them to that of the pet's.
        pet2.setSpecies(reader.nextLine());
        pet2.setGender(reader.nextLine());
        pet2.setHunger(reader.nextInt());
        pet2.setHappiness(reader.nextInt());
        pet2.setFatigue(reader.nextInt());
        pet2.setBoredom(reader.nextInt());
        pet2.setHygiene(reader.nextInt());
        pet2.setDead(reader.nextBoolean());
        invSize = reader.nextInt();
        for (int i = 0; i <= invSize; i++) {  //scans the next few lines to get all previous inventory items from last save
            inv.addWithSameName(reader.nextLine(), shop, inv);  //adds inventory items to new inventory
        };
        time = reader.nextLong(); //sets current time
        money = reader.nextInt(); //sets money to previous quantity
    }
    
    //this method is for testing only
    public static void displaySavedData() throws FileNotFoundException, IOException {
        Scanner reader = new Scanner(save); //reads the file lines
        System.out.println();
        
        while (reader.hasNext()) {
            System.out.println(reader.nextLine());
        }
        System.out.println("\nPET STATS:");
        System.out.println(pet2.getName());      //if all the pet stats are the same, then reader has written the stats to pet 2
        System.out.println(pet2.getSpecies());   //pet2 is only used to see if the reader would overwrite pet1 correctly when actually used in game
        System.out.println(pet2.getGender());
        System.out.println(pet2.getHunger());
        System.out.println(pet2.getHappiness());
        System.out.println(pet2.getFatigue());
        System.out.println(pet2.getBoredom());
        System.out.println(pet2.getHygiene());
        System.out.println(pet2.getDead());
        
        System.out.println("\nINVENTORY ITEMS:");
        for (int i = 0; i < inv.getSize(); i++) {
            System.out.println(inv.getNameOfItem(i));
        }

        System.out.println("\nTIME:");
        System.out.println(time);
                
        System.out.println("\nMONEY:");
        System.out.println(money);
    }
}
