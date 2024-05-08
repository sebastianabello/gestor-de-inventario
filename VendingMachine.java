package LowLevelDesign.DesignVendingMachine;

import LowLevelDesign.DesignVendingMachine.Auth.AuthenticationStrategy;
import LowLevelDesign.DesignVendingMachine.Auth.UsernamePasswordAuthentication;
import LowLevelDesign.DesignVendingMachine.VendingStates.State;
import LowLevelDesign.DesignVendingMachine.VendingStates.impl.IdleState;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;
    private Authentication auth;

    public VendingMachine(){
        this.auth = new Authentication(new User("admin", "password"), new UsernamePasswordAuthentication());
        vendingMachineState = new IdleState();
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public void fillUpInventory() throws Exception {
        if (auth == null) {
            throw new Exception("Debe autenticarse para realizar esta acción");
        }
        // Resto del código...
    }

    public void manageCoins() throws Exception {
        if (auth == null) {
            throw new Exception("Debe autenticarse para realizar esta acción");
        }
        // Resto del código...
    }

    public boolean login(String username, String password) {
        try {
            boolean success = auth.authenticate(username + ":" + password);
            if (success) {
                System.out.println("Autenticación exitosa");
                return true;
            } else {
                System.out.println("Usuario y/o contraseña incorrectos");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void displayProducts() {
        // Aquí puedes implementar la lógica para mostrar los productos disponibles
        // Por ejemplo, podrías recorrer la lista de productos en el inventario y mostrar sus detalles
        for (ItemType item : ItemType.values()) {
            System.out.println(item.name());
        }
    }

    public void purchaseProduct() {
        // Aquí puedes implementar la lógica para permitir al usuario comprar un producto
        // Por ejemplo, podrías pedir al usuario que introduzca el nombre del producto que desea comprar,
        // luego buscar ese producto en el inventario y, si está disponible, reducir su cantidad en el inventario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto que desea comprar: ");
        String productName = scanner.next();
        try {
            ItemType product = ItemType.valueOf(productName.toUpperCase());
            if (inventory.isProductAvailable(product)) {
                inventory.reduceProductQuantity(product);
                System.out.println("Has comprado " + product.name());
            } else {
                System.out.println("El producto no está disponible");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("El producto ingresado no existe");
        }
    }
}