package gatherer;

public class Card {
    private static final int BASIC = 0;
    private static final int COMMON = 1;
    private static final int RARE = 2;
    private static final int EPIC = 3;
    private static final int LEGENDARY = 4;

    private static final int NEUTRAL = 0;
    private static final int WARRIOR = 1;
    private static final int SHAMAN = 2;
    private static final int ROGUE = 3;
    private static final int PALADIN = 4;
    private static final int HUNTER = 5;
    private static final int DRUID = 6;
    private static final int WARLOCK = 7;
    private static final int MAGE = 8;
    private static final int PRIEST = 9;

    private static final int CLASSIC = 0;
    private static final int GVG = 1;
    private static final int TGT = 2;

    public String name;
    public int cost;
    public String flavor;
    public String text;
    public int type;
    public int rarity;
    public int set;

    public Card() {

    }

    public Card(String name, int cost, String flavor, String text, int type, int rarity, int set) {
        this.name = name;
        this.cost = cost;
        this.flavor = flavor;
        this.text = text;
        this.type = type;
        this.rarity = rarity;
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getText() {
        return text;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getType() {
        return type;
    }

    public int getRarity() {
        return rarity;
    }

    public int getSet() {
        return set;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void setSet(int set) {
        this.set = set;
    }
}
