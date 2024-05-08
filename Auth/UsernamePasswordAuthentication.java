package LowLevelDesign.DesignVendingMachine.Auth;

import LowLevelDesign.DesignVendingMachine.User;

public class UsernamePasswordAuthentication implements AuthenticationStrategy {

    @Override
    public boolean authenticate(User user, String credential) throws Exception {
        String[] credentials = credential.split(":");
        String username = credentials[0];
        String password = credentials[1];

        if (user.isBlocked()) {
            throw new Exception("Usuario bloqueado. Contacte al administrador");
        }

        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            user.resetFailedLoginAttempts();
            return true;
        } else {
            user.incrementFailedLoginAttempts();
            if (user.isBlocked()) {
                throw new Exception("Usuario bloqueado. Contacte al administrador");
            }
            return false;
        }
    }
}
