package LowLevelDesign.DesignVendingMachine;

public class Item {
    ItemType type;
    int price;
    private ItemType itemType;

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
