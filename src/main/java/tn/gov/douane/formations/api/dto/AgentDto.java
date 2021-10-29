package tn.gov.douane.formations.api.dto;

public class AgentDto {

    private int id;
    private String matricule;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String type;
    private String grade;
    private String poste;
    private boolean envoyer;

    public AgentDto() {
    }

    public AgentDto(String matricule, String firstName, String lastName,
                    String phone, String email, String username, String password,
                    String type, String grade, String poste, Boolean envoyer) {
        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
        this.grade = grade;
        this.poste = poste;
        this.envoyer = envoyer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public boolean isEnvoyer() {
        return envoyer;
    }

    public void setEnvoyer(boolean envoyer) {
        this.envoyer = envoyer;
    }
}
