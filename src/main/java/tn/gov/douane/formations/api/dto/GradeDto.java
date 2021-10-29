package tn.gov.douane.formations.api.dto;

public class GradeDto {

    private int id;
    private String gradeCode;
    private String gradeLibelle;
    private String gradeDescription;
    private String gradeNiveau;

    public GradeDto() {
    }

    public GradeDto(int id, String gradeCode, String gradeLibelle, String gradeDescription, String gradeNiveau) {
        this.id = id;
        this.gradeCode = gradeCode;
        this.gradeLibelle = gradeLibelle;
        this.gradeDescription = gradeDescription;
        this.gradeNiveau = gradeNiveau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeDescription() {
        return this.gradeDescription;
    }

    public void setGradeDescription(String gradeDescription) {
        this.gradeDescription = gradeDescription;
    }

    public String getGradeLibelle() {
        return this.gradeLibelle;
    }

    public void setGradeLibelle(String gradeLibelle) {
        this.gradeLibelle = gradeLibelle;
    }

    public String getGradeNiveau() {
        return this.gradeNiveau;
    }

    public void setGradeNiveau(String gradeNiveau) {
        this.gradeNiveau = gradeNiveau;
    }

}
