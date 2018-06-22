package objects;

import java.util.UUID;

public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String cellphone; //atributos


    public User(){} //genero entidades unicas ()

    public User(String firstName, String lastName, String cellphone){
        this.setId(UUID.randomUUID().toString());
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCellphone(cellphone);
    }

    public User(String firstName, String cellphone){
        this.setId(UUID.randomUUID().toString());
        this.setFirstName(firstName);
        this.setLastName(""); //no null
        this.setCellphone(cellphone);
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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
