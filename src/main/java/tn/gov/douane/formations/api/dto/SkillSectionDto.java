package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.CategorySkill;

public class SkillSectionDto {

    private int id;
    private String skillSectionCode;
    private String skillSectionName;
    private String skillSectionDescription;
    private int categorySkillId;
    private CategorySkill categorySkill;

    public SkillSectionDto() {
    }

    public SkillSectionDto(int id, String skillSectionCode, String skillSectionName, String skillSectionDescription, int categorySkillId) {
        this.id = id;
        this.skillSectionCode = skillSectionCode;
        this.skillSectionName = skillSectionName;
        this.skillSectionDescription = skillSectionDescription;
        this.categorySkillId = categorySkillId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillSectionCode() {
        return this.skillSectionCode;
    }

    public void setSkillSectionCode(String skillSectionCode) {
        this.skillSectionCode = skillSectionCode;
    }

    public String getSkillSectionDescription() {
        return this.skillSectionDescription;
    }

    public void setSkillSectionDescription(String skillSectionDescription) {
        this.skillSectionDescription = skillSectionDescription;
    }

    public String getSkillSectionName() {
        return this.skillSectionName;
    }

    public void setSkillSectionName(String skillSectionName) {
        this.skillSectionName = skillSectionName;
    }

    public int getCategorySkillId() {
        return this.categorySkillId;
    }

    public void setCategorySkillId(int categorySkillId) {
        this.categorySkillId = categorySkillId;
    }

    public CategorySkill getCategorySkill() {
        return categorySkill;
    }

    public void setCategorySkill(CategorySkill categorySkill) {
        this.categorySkill = categorySkill;
    }
}
