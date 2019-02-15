package DTO;

public class UserDTO {

    private String id;
    private String login;
    private int password;

    public UserDTO(String id, String login, int password, String userName){
        this.id = id;
        this.login = login;
        this.password = password;
        this. userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
}
