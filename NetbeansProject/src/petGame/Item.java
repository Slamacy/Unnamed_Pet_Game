package petGame;

public class Item {
    private String name;        //item's name
    private String type;        //type of item (i.e. food item, resting item, hygiene item, or toy item)
    private int happinessValue; //value that this item affects happiness
    private int fatigueValue;   //value that this item affects fatigue
    private int feedingValue;   //value that this item affects hunger
    private int restingTime;    //value that this item affects fatigue
    private int hygieneValue;   //value that this item affects hygiene
    private int boredomValue;   //value that this item affects boredom
    private float cost;         //item price when seen in store
    
    //food item constructor
    public Item(String name, String type, int happinessValue, int feedingValue, int hygineValue, int fatigueValue, float cost) {
        this.name = name;
        this.type = type;
	this.happinessValue = happinessValue;
        this.feedingValue = feedingValue;
        this.hygieneValue = hygineValue;
        this.cost = cost;
    }
    
    //resting item constructor
    public Item(String name, String type, int happinessValue, int restingTime, int fatigueValue, float cost) {
        this.name = name;
        this.type = type;
	this.happinessValue = happinessValue;
        this.restingTime = restingTime;
        this.fatigueValue = fatigueValue;
        this.cost = cost;
    }
    
    //hygine item constructor
    public Item(String name, String type, int happinessValue, int hygineValue, float cost) {
        this.name = name;
        this.type = type;
	this.happinessValue = happinessValue;
        this.hygieneValue = hygineValue;
        this.cost = cost;
    }
    
    //toy item constructor
    public Item(int boredomValue, String type, int happinessValue, int fatigueValue, float cost, String name) {
        this.boredomValue = boredomValue;
        this.type = type;
	this.happinessValue = happinessValue;
        this.fatigueValue = fatigueValue;
        this.cost = cost;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public float getPrice() {
        return cost;
    }
    
    public int getHappiness() {
	return happinessValue;
    }
	
    public int getHygine() {
        return hygieneValue;
    }
    
    public int getFatigue() {
        return fatigueValue;
    }
    
    public int getResting() {
        return restingTime;
    }
    
    public int getBoredom() {
        return boredomValue;
    }
    
    public int getFeeding() {
        return feedingValue;
    }
    
        public String getType()
    {
        return type;
    }
    
	
    public String asString() {
        String item =   "Name: " + this.name +
                        "\nType:" + this.type +
                        "\nHappiness Value: " + this.happinessValue +
                        "\nFatigue Value: " + this.fatigueValue +
                        "\nHygine Value: " + this.hygieneValue +
                        "\nFeeding Value: " + this.feedingValue +
                        "\nResting Time: " + this.restingTime +
                        "\nBoredom Value: " + this.boredomValue +
                        "\nCost: " + this.cost + "\n";
        return item;
    }
}
