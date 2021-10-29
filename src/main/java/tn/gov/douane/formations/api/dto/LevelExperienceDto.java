package tn.gov.douane.formations.api.dto;

public class LevelExperienceDto {

    private int id;
    private String levelExpCode;
    private String levelExpDescription;
    private int levelExpPoids;

    public LevelExperienceDto() {
    }

    public LevelExperienceDto(int id, String levelExpCode, String levelExpDescription, int levelExpPoids) {
        this.id = id;
        this.levelExpCode = levelExpCode;
        this.levelExpDescription = levelExpDescription;
        this.levelExpPoids = levelExpPoids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevelExpCode() {
        return this.levelExpCode;
    }

    public void setLevelExpCode(String levelExpCode) {
        this.levelExpCode = levelExpCode;
    }

    public String getLevelExpDescription() {
        return this.levelExpDescription;
    }

    public void setLevelExpDescription(String levelExpDescription) {
        this.levelExpDescription = levelExpDescription;
    }

    public int getLevelExpPoids() {
        return this.levelExpPoids;
    }

    public void setLevelExpPoids(int levelExpPoids) {
        this.levelExpPoids = levelExpPoids;
    }

}
