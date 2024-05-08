package LowLevelDesign.DesignVendingMachine.Auth;

import LowLevelDesign.DesignVendingMachine.User;

public interface AuthenticationStrategy {
    boolean authenticate(User user, String credential) throws Exception;
}
