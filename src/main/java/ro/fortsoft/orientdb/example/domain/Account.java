package ro.fortsoft.orientdb.example.domain;

/**
 * @author Decebal Suiu
 */
public class Account {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("Account[");
        builder.append("username=").append(getUsername()).append(",");
        builder.append("password=").append(getPassword());
        builder.append("]");
        
        return builder.toString();
    }

}
