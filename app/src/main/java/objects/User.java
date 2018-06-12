package objects;

import java.util.Random;
import java.util.UUID;

public class User {
    //clase, define comportamiento los atributos (molde a seguir)
    private UUID userId; //todo find how it indexed each user so the data wont be overwrited
    private String firstName;
    private String lastName;
    private Integer cellphone; //atributos


    public User(){} //genero entidades unicas ()

    public User(String firstName, String lastName, Integer cellphone){
        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCellphone(cellphone);
    }

    public User(String firstName, Integer cellphone){
        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setFirstName(firstName);
        user.setLastName(""); //no null
        user.setCellphone(cellphone);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCellphone() {
        return cellphone;
    }

    public void setCellphone(Integer cellphone) {
        this.cellphone = cellphone;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
