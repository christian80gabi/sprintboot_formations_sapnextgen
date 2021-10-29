package tn.gov.douane.formations.api.dto;

public class CategorySkillDto {

    private int id;
    private String categorySkillCode;
    private String categorySkillName;
    private String categorySkillDescription;

    public CategorySkillDto() {
    }

    public CategorySkillDto(int id, String categorySkillCode, String categorySkillName, String categorySkillDescription) {
        this.id = id;
        this.categorySkillCode = categorySkillCode;
        this.categorySkillName = categorySkillName;
        this.categorySkillDescription = categorySkillDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorySkillCode() {
        return categorySkillCode;
    }

    public void setCategorySkillCode(String categorySkillCode) {
        this.categorySkillCode = categorySkillCode;
    }

    public String getCategorySkillName() {
        return categorySkillName;
    }

    public void setCategorySkillName(String categorySkillName) {
        this.categorySkillName = categorySkillName;
    }

    public String getCategorySkillDescription() {
        return categorySkillDescription;
    }

    public void setCategorySkillDescription(String categorySkillDescription) {
        this.categorySkillDescription = categorySkillDescription;
    }
}
