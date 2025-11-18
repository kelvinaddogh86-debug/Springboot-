package shops.shops.userentity;

public class UserDto {
    private String name;
    private String email;

public UserDto(){}

    public  UserDto(String name,String gmail){
    this.name = name;
    this.email = gmail;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return email;
    }

    public void setGmail(String gmail) {
        this.email = gmail;
    }
    
}
