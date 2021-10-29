package tn.gov.douane.formations.api.dto;

public class CategoryFormationDto {

    private int id;
    private String categoryFormationCode;
    private String categoryFormationName;
    private String categoryFormationDescription;

    public CategoryFormationDto() {
    }

    public CategoryFormationDto(int id, String categoryFormationCode, String categoryFormationName, String categoryFormationDescription) {
        this.id = id;
        this.categoryFormationCode = categoryFormationCode;
        this.categoryFormationName = categoryFormationName;
        this.categoryFormationDescription = categoryFormationDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryFormationCode() {
        return this.categoryFormationCode;
    }

    public void setCategoryFormationCode(String categoryFormationCode) {
        this.categoryFormationCode = categoryFormationCode;
    }

    public String getCategoryFormationName() {
        return this.categoryFormationName;
    }

    public void setCategoryFormationName(String categoryFormationName) {
        this.categoryFormationName = categoryFormationName;
    }

    public String getCategoryFormationDescription() {
        return this.categoryFormationDescription;
    }

    public void setCategoryFormationDescription(String categoryFormationDescription) {
        this.categoryFormationDescription = categoryFormationDescription;
    }

}
