package tn.gov.douane.formations.api.dto;

public class LevelSkillDto {

    private int id;
    private String levelSkillCode;
    private String levelSkillDescription;
    private double levelSkillPoids;

    public LevelSkillDto() {
    }

    public LevelSkillDto(int id, String levelSkillCode, String levelSkillDescription, double levelSkillPoids) {
        this.id = id;
        this.levelSkillCode = levelSkillCode;
        this.levelSkillDescription = levelSkillDescription;
        this.levelSkillPoids = levelSkillPoids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevelSkillCode() {
        return this.levelSkillCode;
    }

    public void setLevelSkillCode(String levelSkillCode) {
        this.levelSkillCode = levelSkillCode;
    }

    public String getLevelSkillDescription() {
        return this.levelSkillDescription;
    }

    public void setLevelSkillDescription(String levelSkillDescription) {
        this.levelSkillDescription = levelSkillDescription; }

    public double getLevelSkillPoids() {
        return this.levelSkillPoids;
    }

    public void setLevelSkillPoids(double levelSkillPoids) {
        this.levelSkillPoids = levelSkillPoids;
    }

}
