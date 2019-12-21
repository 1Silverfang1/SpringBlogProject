package SpringMVC.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
    @NotNull
    @Size(min = 1,max = 18)
    private String firstName;
    @NotNull
    @Size(min = 1,max = 18)
    private String LastName;
    @NotNull(message = "This Field is Required")
    private String country;
    @NotNull
    @Min(1)
    private  int id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
