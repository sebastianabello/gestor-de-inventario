package LowLevelDesign.DesignVendingMachine.Auth;

import LowLevelDesign.DesignVendingMachine.User;

public class PinAuthentication implements AuthenticationStrategy{

    @Override
    public boolean authenticate(User user, String credential) throws Exception {
        throw new Exception("La autenticación con PIN no está implementada aún");
    }
}
