package LowLevelDesign.DesignVendingMachine;

import LowLevelDesign.DesignVendingMachine.Item;

public class ItemShelf {

    int code;
    Item item;
    boolean soldOut;
    int quantity;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void decreaseQuantity() { // Añade un método para disminuir la cantidad
        if (quantity > 0) {
            quantity--;
        }
    }
}
