enum Gender {
    MALE, FEMALE
}

public class Author {
    private String name;
    private String email;
    private Gender gender;

    public Author(String name, String email, Gender gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public Gender getGender(){
        return gender;
    }
    @Override
    public String toString(){
        return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }
}
