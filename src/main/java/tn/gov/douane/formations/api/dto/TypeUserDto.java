package tn.gov.douane.formations.api.dto;

public class TypeUserDto {

    private int id;
    private String typeUserLibelle;
    private String typeUserDescription;

    public TypeUserDto() {
    }

    public TypeUserDto(int id, String typeUserLibelle, String typeUserDescription) {
        this.id = id;
        this.typeUserLibelle = typeUserLibelle;
        this.typeUserDescription = typeUserDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeUserLibelle() {
        return typeUserLibelle;
    }

    public void setTypeUserLibelle(String typeUserLibelle) {
        this.typeUserLibelle = typeUserLibelle;
    }

    public String getTypeUserDescription() {
        return this.typeUserDescription;
    }

    public void setTypeUserDescription(String typeUserDescription) {
        this.typeUserDescription = typeUserDescription;
    }

}
