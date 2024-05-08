package LowLevelDesign.DesignVendingMachine;

import LowLevelDesign.DesignVendingMachine.Auth.AuthenticationStrategy;
import LowLevelDesign.DesignVendingMachine.Auth.PinAuthentication;
import LowLevelDesign.DesignVendingMachine.Auth.SocialMediaAuthentication;
import LowLevelDesign.DesignVendingMachine.Auth.UsernamePasswordAuthentication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        boolean isAuthenticated = false;

        while (true) {
            System.out.println("1. Ver productos");
            System.out.println("2. Comprar producto");
            if (!isAuthenticated) {
                System.out.println("3. Administrar máquina (autenticarse)");
            }
            if (isAuthenticated) {
                System.out.println("4. Llenar inventario");
                System.out.println("5. Gestionar monedas");
            }
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = 0;
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Por favor, ingrese un número entero para seleccionar una opción.");
                continue;
            }

            switch (option) {
                case 1:
                    vendingMachine.displayProducts();
                    break;
                case 2:
                    vendingMachine.purchaseProduct();
                    break;
                case 3:
                    if (!isAuthenticated) {
                        System.out.println("Seleccione el método de autenticación:");
                        System.out.println("1. Autenticación con nombre de usuario y contraseña");
                        System.out.println("2. Autenticación con PIN");
                        System.out.println("3. Autenticación con redes sociales");
                        System.out.print("Seleccione una opción: ");

                        int authOption = scanner.nextInt();
                        AuthenticationStrategy strategy = switch (authOption) {
                            case 1 -> new UsernamePasswordAuthentication();
                            case 2 -> new PinAuthentication();
                            case 3 -> new SocialMediaAuthentication();
                            default -> {
                                System.out.println("Opción no válida. Se utilizará la autenticación con nombre de usuario y contraseña por defecto.");
                                yield new UsernamePasswordAuthentication();
                            }
                        };

                        User user = new User("admin", "password");
                        Authentication auth = new Authentication(user, strategy);

                        System.out.print("Ingrese el nombre de usuario:");
                        String username = scanner.next();
                        System.out.print("Ingrese la contraseña: ");
                        String password = scanner.next();
                        try {
                            isAuthenticated = auth.authenticate(username + ":" + password);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Ya estás autenticado");
                    }
                    break;
                case 4:
                    if (isAuthenticated) {
                        try {
                            vendingMachine.fillUpInventory();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Debe autenticarse para realizar esta acción");
                    }
                    break;
                case 5:
                    if (isAuthenticated) {
                        try {
                            vendingMachine.manageCoins();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Debe autenticarse para realizar esta acción");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}