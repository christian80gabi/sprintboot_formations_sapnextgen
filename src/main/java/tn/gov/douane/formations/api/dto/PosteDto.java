package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Grade;
import tn.gov.douane.formations.api.model.PosteStatut;

public class PosteDto {

    private int id;
    private String posteCode;
    private String posteDescription;
    private String posteLabel;
    private int posteStatutId;
    private int gradeId;
    private PosteStatut posteStatut;
    private Grade grade;

    public PosteDto() {
    }

    public PosteDto(int id, String posteCode, String posteDescription, String posteLabel, int posteStatutId, int gradeId) {
        this.id = id;
        this.posteCode = posteCode;
        this.posteDescription = posteDescription;
        this.posteLabel = posteLabel;
        this.posteStatutId = posteStatutId;
        this.gradeId = gradeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosteCode() {
        return this.posteCode;
    }

    public void setPosteCode(String posteCode) {
        this.posteCode = posteCode;
    }

    public String getPosteDescription() {
        return this.posteDescription;
    }

    public void setPosteDescription(String posteDescription) {
        this.posteDescription = posteDescription;
    }

    public String getPosteLabel() {
        return this.posteLabel;
    }

    public void setPosteLabel(String posteLabel) {
        this.posteLabel = posteLabel;
    }

    public int getPosteStatutId() {
        return this.posteStatutId;
    }

    public void setPosteStatutId(int posteStatutId) {
        this.posteStatutId = posteStatutId;
    }

    public int getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public PosteStatut getPosteStatut() {
        return posteStatut;
    }

    public void setPosteStatut(PosteStatut posteStatut) {
        this.posteStatut = posteStatut;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
