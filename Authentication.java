package LowLevelDesign.DesignVendingMachine;

import LowLevelDesign.DesignVendingMachine.Auth.AuthenticationStrategy;

public class Authentication {
    private User user;
    private AuthenticationStrategy strategy;

    public Authentication(User user, AuthenticationStrategy strategy) {
        this.user = user;
        this.strategy = strategy;
    }

    public boolean authenticate(String credential) throws Exception {
        return strategy.authenticate(user, credential);
    }


}
