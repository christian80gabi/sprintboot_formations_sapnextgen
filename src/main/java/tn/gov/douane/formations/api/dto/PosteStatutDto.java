package tn.gov.douane.formations.api.dto;

public class PosteStatutDto {

    private int id;
    private String posteStatutLabel;
    private boolean posteStatutFlag;


    public PosteStatutDto() {
        this.posteStatutFlag = true;
    }

    public PosteStatutDto(String posteStatutLabel, boolean posteStatutFlag) {
        this.posteStatutLabel = posteStatutLabel;
        this.posteStatutFlag = posteStatutFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosteStatutLabel() {
        return posteStatutLabel;
    }

    public void setPosteStatutLabel(String posteStatutLabel) {
        this.posteStatutLabel = posteStatutLabel;
    }

    public boolean isPosteStatutFlag() {
        return posteStatutFlag;
    }

    public void setPosteStatutFlag(boolean posteStatutFlag) {
        this.posteStatutFlag = posteStatutFlag;
    }
}
