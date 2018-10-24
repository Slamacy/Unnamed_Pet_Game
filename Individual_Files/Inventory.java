package week_9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Inventory {
    private String name;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    
    public Inventory(String name) {
        this.name = name;
    }
    
    public ArrayList getInventory() {
        return inventory;
    }
    
    public String getNameOfItem(int i) {
        return inventory.get(i).getName();
    }
    
    public void add(Item item){
        this.inventory.add(item);
    }
    
    public void addWithSameName(String name, Shop shop, Inventory inv){
        for (int i = 0; i < shop.getStock().size(); i++) {
            if (shop.getNameOfItem(i) == name) {
                inv.add(shop.getItem(i));
            }
        }
    }
    
    public void remove(Item item) {
        this.inventory.remove(inventory.indexOf(item));
    }
    
    public int getSize() {
        return this.inventory.size();
    }
    
    public int getQuantity(Item item) {
        int quantity = 0;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName() == item.getName()) {
                quantity = quantity++;
            }
        }
        return quantity;
    }

    public void selectItemType(Pet Pet, String itemType) { //Displays all items of type itemType in inventory and asks player to select one
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getType().equals(itemType)) { //Checks if item is of type food, and displays name if true
                System.out.println(inventory.get(i).getName());
            }
        }
        System.out.println("\nWhat would you like to give your pet?");
        String itemChoice = keyboard.nextLine();
        //Converts first character to uppercase, and leaves the rest of the String as lowercase
        itemChoice = itemChoice.substring(0, 1).toUpperCase() + itemChoice.substring(1); 
        
        for(int i = 0; i < inventory.size(); i++) {
            System.out.println(itemChoice);
            System.out.println(inventory.get(i).getName());
            if(inventory.get(i).getName().equals(itemChoice))//Checks inventory for inputted String
            {   
                /*The following if else statment checks the itemType variable, so it knows whether to feed,
                play with, wash, or rest the pet.*/
                
                if(itemType.equals("food")) {
                    Pet.feedPet(inventory.get(i));
                    inventory.remove(i);//Removes item from inventory
                }
                else if(itemType.equals("toy")) {
                    Pet.playWithPet(inventory.get(i));
                }
                else if(itemType.equals("hygiene")) {
                    Pet.washPet(inventory.get(i));
                    inventory.remove(i);//Removes item from inventory
                }
                else if(itemType.equals("resting")) {
                    Pet.restPet(inventory.get(i));
                }
            }
        }
    }
    
        public void sortInventory()
    {
        Collections.sort(inventory);
    }
    
    public void asString() {
        System.out.println("Inventory: ");
        for(int i = 0; i < inventory.size(); i++) {
            System.out.println("Item " + i + ": " + inventory.get(i).getName());
        }
    }
}
