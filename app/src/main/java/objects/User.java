package objects;

public class User {

    //clase, define comportamiento los atributos (molde a seguir)

    private String firstName;
    private String lastName;
    private Integer cellphone; //atributos


    public void User(){} //genero entidades unicas ()

    public void User(String firstName, String lastName, Integer cellphone){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCellphone(cellphone);
    }

    public void User(String firstName, Integer cellphone){
        User user = new User();
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
}
