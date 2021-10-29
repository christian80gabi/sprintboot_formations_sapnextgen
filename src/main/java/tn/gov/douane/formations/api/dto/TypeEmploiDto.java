package tn.gov.douane.formations.api.dto;

public class TypeEmploiDto {

    private int id;
    private String typeEmpLibelle;
    private String typeEmpDescription;

    public TypeEmploiDto() {
    }

    public TypeEmploiDto(int id, String typeEmpLibelle, String typeEmpDescription) {
        this.id = id;
        this.typeEmpLibelle = typeEmpLibelle;
        this.typeEmpDescription = typeEmpDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeEmpDescription() {
        return this.typeEmpDescription;
    }

    public void setTypeEmpDescription(String typeEmpDescription) {
        this.typeEmpDescription = typeEmpDescription;
    }

    public String getTypeEmpLibelle() {
        return this.typeEmpLibelle;
    }

    public void setTypeEmpLibelle(String typeEmpLibelle) {
        this.typeEmpLibelle = typeEmpLibelle;
    }

}
