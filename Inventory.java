package LowLevelDesign.DesignVendingMachine;

public class Inventory {

    ItemShelf[] inventory = null;

    Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i]= space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {

        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("already item is present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {

        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("item already sold out");
                } else {

                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

    public boolean isProductAvailable(ItemType product) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getItem().getItemType().equals(product) && !itemShelf.isSoldOut()) {
                return true;
            }
        }
        return false;
    }

    public void reduceProductQuantity(ItemType product) {
        // Aquí puedes implementar la lógica para reducir la cantidad de un producto en el inventario
        // Por ejemplo, podrías recorrer el inventario y, si encuentras el producto, reducir su cantidad
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getItem().equals(product) && !itemShelf.isSoldOut()) {
                itemShelf.decreaseQuantity();
                if (itemShelf.getQuantity() == 0) {
                    itemShelf.setSoldOut(true);
                }
                break;
            }
        }
    }


}
