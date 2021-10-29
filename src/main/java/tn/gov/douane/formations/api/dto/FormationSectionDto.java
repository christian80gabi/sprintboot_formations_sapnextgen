package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.CategoryFormation;

public class FormationSectionDto {

    private int id;
    private String formationSectionCode;
    private String formationSectionName;
    private String formationSectionDescription;
    private long categoryFormationId;
    private CategoryFormation categoryFormation;

    public FormationSectionDto() {
    }

    public FormationSectionDto(String formationSectionCode, String formationSectionName,
                               String formationSectionDescription, long categoryFormationId, CategoryFormation categoryFormation) {
        this.formationSectionCode = formationSectionCode;
        this.formationSectionName = formationSectionName;
        this.formationSectionDescription = formationSectionDescription;
        this.categoryFormationId = categoryFormationId;
        this.categoryFormation = categoryFormation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormationSectionCode() {
        return formationSectionCode;
    }

    public void setFormationSectionCode(String formationSectionCode) {
        this.formationSectionCode = formationSectionCode;
    }

    public String getFormationSectionName() {
        return formationSectionName;
    }

    public void setFormationSectionName(String formationSectionName) {
        this.formationSectionName = formationSectionName;
    }

    public String getFormationSectionDescription() {
        return formationSectionDescription;
    }

    public void setFormationSectionDescription(String formationSectionDescription) {
        this.formationSectionDescription = formationSectionDescription;
    }

    public long getCategoryFormationId() {
        return categoryFormationId;
    }

    public void setCategoryFormationId(long categoryFormationId) {
        this.categoryFormationId = categoryFormationId;
    }

    public CategoryFormation getCategoryFormation() {
        return categoryFormation;
    }

    public void setCategoryFormation(CategoryFormation categoryFormation) {
        this.categoryFormation = categoryFormation;
    }
}
