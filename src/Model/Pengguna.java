package Model;

import Modules.Model;

public class Pengguna extends Model{
    private String username;
    private String password;

    public Pengguna() {
        super("pengguna");
    }

    public Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
    }

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
}
