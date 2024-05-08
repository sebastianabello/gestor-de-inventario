package LowLevelDesign.DesignVendingMachine;

public class User {
    private String username;
    private String password;
    private int failedLoginAttempts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.failedLoginAttempts = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void incrementFailedLoginAttempts() {
        this.failedLoginAttempts++;
    }

    public void resetFailedLoginAttempts() {
        this.failedLoginAttempts = 0;
    }

    public boolean isBlocked() {
        return failedLoginAttempts >= 3;
    }
}

