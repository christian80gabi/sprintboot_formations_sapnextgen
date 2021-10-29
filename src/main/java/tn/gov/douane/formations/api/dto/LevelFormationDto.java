package tn.gov.douane.formations.api.dto;

public class LevelFormationDto {

    private int id;
    private String levelFormationCode;
    private String levelFormationDescription;
    private int levelFormationPoids;

    public LevelFormationDto() {
    }

    public LevelFormationDto(int id, String levelFormationCode, String levelFormationDescription, int levelFormationPoids) {
        this.id = id;
        this.levelFormationCode = levelFormationCode;
        this.levelFormationDescription = levelFormationDescription;
        this.levelFormationPoids = levelFormationPoids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevelFormationCode() {
        return this.levelFormationCode;
    }

    public void setLevelFormationCode(String levelFormationCode) {
        this.levelFormationCode = levelFormationCode;
    }

    public String getLevelFormationDescription() {
        return this.levelFormationDescription;
    }

    public void setLevelFormationDescription(String levelFormationDescription) {
        this.levelFormationDescription = levelFormationDescription; }

    public int getLevelFormationPoids() {
        return this.levelFormationPoids;
    }

    public void setLevelFormationPoids(int levelFormationPoids) {
        this.levelFormationPoids = levelFormationPoids;
    }

}
