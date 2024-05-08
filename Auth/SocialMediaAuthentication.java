package LowLevelDesign.DesignVendingMachine.Auth;

import LowLevelDesign.DesignVendingMachine.User;

public class SocialMediaAuthentication implements AuthenticationStrategy {
    @Override
    public boolean authenticate(User user, String credential) throws Exception {
        throw new Exception("La autenticación con redes sociales no está implementada aún");
    }
}
