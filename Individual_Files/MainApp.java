package week_9;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.Writer;

public class MainApp {
    static Scanner input = new Scanner(System.in); //creates global scanner
    static Shop shop = new Shop();
    static long time;
    static boolean firstPlay = true;
    static float money = 2000;
    static ArrayList<Item> basket = new ArrayList<Item>();
    static Inventory inv = new Inventory("Inventory"); //creates inventory object
    static File save = new File("save.txt"); //imports file used for saving data
   // static Pet pet = new Pet("Molly", "Female", "Rabbit", 0, 0, 0, 0, 0, false);
    static Pet pet = new Pet();
    
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
        
        inv.add(wipes);     //Inventory items here for testing only
        inv.add(plasticRings);
        inv.add(kiddiePool);
        inv.add(catHouse);
        inv.add(meat);
        inv.add(toothbrush);
        inv.add(luxSoap);
        inv.add(fruitAndVeg);
        inv.add(insects);
        
        ArrayList<Pet> petChoices = new ArrayList<Pet>();
        Pet pet1 = new Pet("Dog");
        Pet pet2 = new Pet("Cat");
        Pet pet3 = new Pet("Bird");
        Pet pet4 = new Pet("Frog");
        Pet pet5 = new Pet("Bunny");

        petChoices.add(pet1);
        petChoices.add(pet2);
        petChoices.add(pet3);
        petChoices.add(pet4);
        petChoices.add(pet5);

        
        
        choosePet(petChoices); //Player chooses species
        selectGender(); //Player selects pets gender
        enterName(); //Player enters pets name

        
        save();
        readSave();
    }
    
    public static void menu() {
        update();
        int choice = 0;
        Scanner input = new Scanner(System.in);
        inv.sortInventory(); //Sorts inventory items into alphabetical order
        
        
        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~ Welcome to [Insert name here] ~");
            System.out.println("~                               ~");
            System.out.println("~ 1. Inventory ~");
            System.out.println("~ 2. Shop ~");
            System.out.println("~ 3. Pet ~"); // rename at some point
            System.out.println("~ 4. About the game ~");
            System.out.println("~ 5. Exit game ~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            choice = input.nextInt();
            switch (choice) {
                case 1: 
                    inventory(); //access inventory
                    break;
                case 2: 
                    shop(); //access shop
                    break;
                case 3:
                    //play(); //access play functionality
                    petMenu();
                    break;
                case 4: 
                    about(); //acces about section
                    break;
                case 5: 
                    break; //exit program
            }
        } while (choice != 5);
    }
    
    public static void petMenu() {
        update();
        int choice = 0;

        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~ Pet ~");
            System.out.println("~                                  ~");
            System.out.println("~ 1. Feed pet ~");
            System.out.println("~ 2. Play with pet ~");
            System.out.println("~ 3. Wash pet ~");
            System.out.println("~ 4. Rest pet ~");
            System.out.println("~ 5. Exit menu ~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    pet.checkHunger(); //Displays pets hunger
                    inv.selectItemType(pet, "food"); //Displays all food items in inventory and asks player to select one
                    pet.checkHunger(); //Displays pets hunger
                    pet.checkHygiene(); //Displays pets hygiene
                    pet.checkFatigue(); //Displays pets fatigue
                    pet.checkHappiness(); //Displays pets happiness
                    break;
                case 2:
                    pet.checkBoredom(); //Displays pets boredom
                    inv.selectItemType(pet, "toy"); //Displays all toy items in inventory and asks player to select one
                    pet.checkBoredom(); //Displays pets boredom
                    pet.checkFatigue(); //Displays pets fatigue
                    pet.checkHappiness(); //Displays pets happiness
                    break;
                case 3:
                    pet.checkHygiene(); //Displays pets hygiene
                    inv.selectItemType(pet, "hygiene"); //Displays all hygiene items in inventory and asks player to select one
                    pet.checkHygiene(); //Displays pets hygiene
                    pet.checkHappiness(); //Displays pets happiness
                    break;
                case 4:
                    pet.checkFatigue(); //Displays pets fatigue
                    inv.selectItemType(pet, "resting");
                    pet.checkFatigue();
                    pet.checkHappiness();
                    //Display rest items
                    break;
                case 5:
                    menu();
                    break;
            }
        } while (choice != 5);
    }
    
    public static void choosePet(ArrayList<Pet> petChoices) { //Player chooses from a list of pet species
        boolean noPet = true;

        do //This do while loop will continue to loop until the player enters a valid pet species
        {
            System.out.println("Please choose a pet: \n");
            for (Pet types : petChoices) { //Displays different species to player
                System.out.println(types.getSpecies());
            }
            System.out.println();
            String userPetChoice = input.nextLine().toLowerCase(); //ensures both upper and lower case answers are accepted
            
            if (userPetChoice.startsWith("d")) {
                pet.setSpecies("Dog");
                System.out.println("  /^^^\\");
                System.out.println(" / 0 0 \\");
                System.out.println(" V\\ * /V");
                System.out.println("  /   \\");
                System.out.println(" /  Y  \\");
                System.out.println(" \\| | |/");
                pet.setHunger(40);
                pet.setFatigue(10);
                pet.setBoredom(60);
                pet.setHygiene(70);
                pet.setDead(false);
                pet.setHappiness(50);
                noPet = false;
            }
            else if (userPetChoice.startsWith("c")) {
                pet.setSpecies("Cat");
                System.out.println("  /\\_/\\");
                System.out.println(" = o ω o= _ ");
                System.out.println("  \\   /   ||");
                System.out.println("  /   \\  //");
                System.out.println(" /  Y  \\//");
                System.out.println(" \\| | | )");
                pet.setHunger(40);
                pet.setFatigue(10);
                pet.setBoredom(60);
                pet.setHygiene(70);
                pet.setDead(false);
                pet.setHappiness(50);
                noPet = false;
            } 
            else if (userPetChoice.startsWith("bi")) {
                pet.setSpecies("Bird");
                System.out.println("    _ ,,, _");
                System.out.println("   /       \\");
                System.out.println("  /  ◕ _ ◕  \\ ");
                System.out.println("  (   \\ /   )");
                System.out.println("  )    v    (");
                System.out.println(" (  )     (  )");
                System.out.println("  \\ |     | /");
                System.out.println("   \\|     |/");
                System.out.println("    /|\\ /|\\");
                pet.setHunger(40);
                pet.setFatigue(10);
                pet.setBoredom(60);
                pet.setHygiene(70);
                pet.setDead(false);
                pet.setHappiness(50);
                noPet = false;
            } 
            else if (userPetChoice.startsWith("bu")) {
                pet.setSpecies("Bunny");
                System.out.println("    _     _");
                System.out.println("    \\`\\ /`/");
                System.out.println("     \\ V /");
                System.out.println("     |◕ ◕|");
                System.out.println("    =( × )=");
                System.out.println("     /   \\");
                System.out.println("    /\\\\ //\\");
                System.out.println("   (   V   )");
                pet.setHunger(40);
                pet.setFatigue(10);
                pet.setBoredom(60);
                pet.setHygiene(70);
                pet.setDead(false);
                pet.setHappiness(50);
                noPet = false;
            } 
            else if (userPetChoice.startsWith("f")) {
                pet.setSpecies("Frog");
                System.out.println("    (◕)-(◕)");
                System.out.println("  -(   ◡   )- ");
                System.out.println("/  /`     `\\  \\");
                System.out.println("\\ _\\ \\___/ /_ /");
                System.out.println("/|  /|\\ /|\\  |\\");
                pet.setHunger(40);
                pet.setFatigue(10);
                pet.setBoredom(60);
                pet.setHygiene(70);
                pet.setDead(false);
                pet.setHappiness(50);
                noPet = false;
            } 
            else if (userPetChoice.equals("b")) {
                System.out.println("Did you mean Bird, or Bunny?");
            } 
            else {
                System.out.println("Please enter a valid pet");
            }
        } while (noPet);
        selectGender();
    }

     public static void selectGender() {
        boolean noGender = true;
        
        do {
        System.out.println("Select your pets gender: m/f");
        String gender = input.nextLine().toLowerCase();//Ensures both upper and lower case answers are accepted
        
            if (gender.startsWith("f")) {
                pet.setGender("Female");
                noGender = false;
            } 
            else if (gender.startsWith("m")) {
                pet.setGender("Male");
                noGender = false;
            } 
            else {
                System.out.println("Please enter a valid gender");
            }
        } while (noGender);
        enterName();
    }
    
    public static void enterName()
    {
        System.out.print("Enter your pets name: ");
        String petName = input.nextLine();
        pet.setName(petName);
        menu();
    }
    
    public static void inventory() {
        int number;
        Item item;
        boolean exit = false;
        while (!exit) {
            inv.asString();
            System.out.println("To examine an Item, input the number associated with it.");
            System.out.println("Input '-1' to exit.");
            number = input.nextInt();
            if (number == -1) {
                menu();
            }
            else if (number >= 0) {
                item = (Item)inv.getInventory().get(number);
                //System.out.println(item.toString());
            }
        }
    }
    
    public static void about() {
        
    }
    
    public static void shop() {
        update();
        int choice, quantity, choice2, choice3;
        float total = 0f;
        boolean yesOrNo = false, working = false;
        char yN;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to the Pet Shop!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please select the items you wish to buy by entering the corresponding number.");
        System.out.println("\nFood items: ");
        System.out.print("0. Meat"); 
        System.out.print("\n1. Fruit and Vegetables"); 
        System.out.print("\n2. Insects"); 
        System.out.print("\n3. Seeds"); 
        System.out.print("\n4. Milk\n"); 
        System.out.println("\nHygiene items: ");
        System.out.print("5. Luxury Shampoo"); 
        System.out.print("\n6. Luxury Soap"); 
        System.out.print("\n7. Luxury Towel"); 
        System.out.print("\n8. Wipes"); 
        System.out.print("\n9. Toothbrush\n"); 
        System.out.println("\nResting items: ");
        System.out.print("10. Dog Bed"); 
        System.out.print("\n11. Cat House"); 
        System.out.print("\n12. Bird House"); 
        System.out.print("\n13. Giant Lily"); 
        System.out.print("\n14. Grass Bed\n"); 
        System.out.println("\nToys: ");
        System.out.print("15. Rubber Bone"); 
        System.out.print("\n16. Plush Mouse"); 
        System.out.print("\n17. Plastic Rings"); 
        System.out.print("\n18. Kiddie Pool"); 
        System.out.print("\n19. Toy Carrot\n"); 
        System.out.println("\nTo purchase any items added into your basket, please input the number 20.");
        System.out.println("To leave the shop, input -1 or any number below 0.");
        choice = input.nextInt();
        
        if (choice >= 0 && choice < 20) {
            System.out.println("\nThe item you have chosen has the following attributes.");
            shop.itemInfo(choice);
            do {
                System.out.println("Add this item to basket? (Y / N)");
                yN = input.next().charAt(0);
                if (yN == 'Y' || yN == 'y') {
                    System.out.println("How many of this item would you like to add to your basket?");
                    quantity = input.nextInt();
                    for (int i = 0; i < quantity; i++) {
                        basket.add(shop.getItem(choice));
                    }
                    yesOrNo = true;
                    shop();
                }
                else if (yN != 'N' || yN != 'n' || yN != 'Y' || yN != 'y') {
                    System.out.println("<<PLEASE INPUT A VALID CHARACTER (Y / N)>>");
                }
            } while (yesOrNo == false);
            yesOrNo = true;
        }
        else if (choice == 20) {
            if (basket.isEmpty()) {
                System.out.println("Your basket is empty.");
                shop(); //returns you to the start of the shop if your basket is empty.
            }
            else {
                System.out.println("Your basket contains the following:");
                for (int i = 0; i < basket.size(); i++) {
                    System.out.println(i + ") " + basket.get(i).getName());
                } //This will list the names of every item you have added to your basket.
                
                for (int i = 0; i < basket.size(); i++ ) {
                    total = total + basket.get(i).getPrice();
                }
                do {
                    System.out.println("The total price of the items in your basket is " + total + " money.");
                    System.out.println("To checkout and purchase these items, please input 1.");
                    System.out.println("To remove an item from the basket, please input 2.");
                    choice2 = input.nextInt();
                    if (choice2 == 1) {
                        if (money >= total) {
                            money = money - total;
                            for (int i = 0; i < basket.size(); i++) {
                                inv.add(basket.get(i));
                            }
                            yesOrNo = true;
                        }
                        else {
                            System.out.println("You have insuffecient funds to purchase these items.");
                            shop();
                        }
                    }
                    else if (choice2 == 2) {
                        do {
                            System.out.println("Please input the number that corresponds with the item you wish to remove from the basket.");
                            choice3 = input.nextInt();
                            if (choice3 < 20 && choice3 >= 0) {
                                working = true;
                            }
                        } while (working == false);
                        basket.remove(basket.get(choice3));
                        total = total - basket.get(choice3).getPrice();
                        System.out.println("This item has been removed.");
                    }
                } while (yesOrNo == false);
            }
        }
        else if (choice == -1) {
            menu();
        } 
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
        menu();
    }
    
    public static void readSave() throws FileNotFoundException, IOException {
        int invSize;
        Scanner reader = new Scanner(save); //reads the file lines
        
        pet.setName(reader.nextLine());      //these lines take the values from the file and assigns them to that of the pet's.
        pet.setSpecies(reader.nextLine());
        pet.setGender(reader.nextLine());
        pet.setHunger(reader.nextInt());
        pet.setHappiness(reader.nextInt());
        pet.setFatigue(reader.nextInt());
        pet.setBoredom(reader.nextInt());
        pet.setHygiene(reader.nextInt());
        pet.setDead(reader.nextBoolean());
        invSize = reader.nextInt();
        for (int i = 0; i <= invSize; i++) {  //scans the next few lines to get all previous inventory items from last save
            inv.addWithSameName(reader.nextLine(), shop, inv);  //adds inventory items to new inventory
        };
        time = reader.nextLong(); //sets current time
        money = reader.nextInt(); //sets money to previous quantity
        menu();
    }
    
    public static void update() { //method to update pet stats over time
   long storedTime = time, ifTime, i;
        int change;
        boolean dead;
        time = System.currentTimeMillis();
        ifTime = time - storedTime; 

        if (ifTime >= 604800000) {
            dead = true;
            pet.setDead(dead);
            //checks if a week has passed since last play, if so, pet is dead.
        }
        
        for (i = 0; i <= ifTime % 3600000; i++) {
            change = (pet.getHunger() + 7);
            pet.setHunger(change);
            if (pet.getHunger() > 100) {
                pet.setHunger(100);
            }
            change = (pet.getFatigue() + 5);
            pet.setFatigue(change);
            if (pet.getFatigue() > 100) {
                pet.setFatigue(100);
            }
            change = (pet.getBoredom() + 10);
            pet.setBoredom(change);
            if (pet.getBoredom() > 100) {
                pet.setBoredom(100);
            }
            change = (pet.getHygiene() - 5);
            pet.setHygiene(change);
            if (pet.getHygiene() < 0) {
                pet.setHygiene(0);
            }
            
            //updates happiness based on Hunger
            if (pet.getHunger() >= 60 && pet.getHunger() < 80) {
                pet.setHappiness(pet.getHappiness() - 5);
            }
            else if (pet.getHunger() >= 80 && pet.getHunger() < 100) {
                pet.setHappiness(pet.getHappiness() - 15);
            }
            else if (pet.getHunger() >= 100) {
                pet.setHappiness(pet.getHappiness() - 35);
            }
            
            //updates happiness based on Fatigue
            if (pet.getFatigue() >= 60 && pet.getFatigue() < 75) {
                pet.setHappiness(pet.getHappiness() - 3);
            }
            else if (pet.getFatigue() >= 75 && pet.getFatigue() < 90) {
                pet.setHappiness(pet.getHappiness() - 15);
            }
            else if (pet.getFatigue() >= 90) {
                pet.setHappiness(pet.getHappiness() - 25);
            }
            
            //updates happiness based on Boredom
            if (pet.getBoredom() >= 60 && pet.getBoredom() < 80) {
                pet.setHappiness(pet.getHappiness() - 3);
            }
            else if (pet.getBoredom() >= 80 && pet.getBoredom() < 100) {
                pet.setHappiness(pet.getHappiness() - 9);
            }
            else if (pet.getBoredom() >= 100) {
                pet.setHappiness(pet.getHappiness() - 20);
            }
            
            //updates happiness based on Hygiene
            if (pet.getHygiene() >= 50 && pet.getHygiene() < 65) {
                pet.setHappiness(pet.getHappiness() - 2);
            }
            else if (pet.getHygiene() >= 65 && pet.getHygiene() < 90) {
                pet.setHappiness(pet.getHappiness() - 8);
            }
            else if (pet.getHygiene() >= 90) {
                pet.setHappiness(pet.getHappiness() - 15);
            }
        }
    }
}