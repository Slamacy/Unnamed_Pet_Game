package petGame;

import java.util.ArrayList;

public class Shop {
    private float totalprice; //the shop adds the price of all the items and displays how much you have to pay
    private ArrayList<Item> stock = new ArrayList<Item>(); //holds all items in the game
    
    public Shop () {
        
    }
    
    public Item getItem(int i) {
        return stock.get(i);
    }
    
    public ArrayList getStock() {
        return stock;
    }
    
    public float getTotalPrice() {
        return totalprice;
    }
    
    public void add(Item item){
        this.stock.add(item);
    }
    
    public void remove(Item item) {
        this.stock.remove(stock.indexOf(item));
    }
    
    public String getNameOfItem(int i) {
        return stock.get(i).getName();
    }
    
    public void setTotalPrice(float totalprice) {
        this.totalprice = totalprice;
    }

    public void itemInfo(int i) {
        System.out.println(getItem(i).asString());
    }
}

