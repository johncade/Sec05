/**
 * Created by madgriff on 7/6/14. Changed stuff
 *
 */
public class User {
    private String userID;


    private String name;
    private String salt;
    private String password;

    public User(){

    }

    @Override
    public String toString() {
        return (userID + " : " + name + " : " + salt + " : " + password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
