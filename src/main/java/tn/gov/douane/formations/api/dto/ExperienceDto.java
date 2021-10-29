package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.LevelExperience;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.TypeEmploi;

public class ExperienceDto {

    private int id;
    private String expCode;
    private String expDescription;
    private String expDocument;
    private String expLink;
    private String expName;
    private String expPlace;
    private int expPoint;
    private String expPeriodStart;
    private String expPeriodEnd;
    private int levelExpId;
    private int typeEmpId;
    private int posteId;
    private LevelExperience levelExp;
    private TypeEmploi typeEmp;
    private Poste poste;

    public ExperienceDto() {
    }

    public ExperienceDto(String expCode, String expDescription, String expDocument, String expLink,
                         String expName, String expPlace, int expPoint, String expPeriodStart,
                         String expPeriodEnd, int levelExpId, int typeEmpId, int posteId,
                         LevelExperience levelExp, TypeEmploi typeEmp, Poste poste) {
        this.expCode = expCode;
        this.expDescription = expDescription;
        this.expDocument = expDocument;
        this.expLink = expLink;
        this.expName = expName;
        this.expPlace = expPlace;
        this.expPoint = expPoint;
        this.expPeriodStart = expPeriodStart;
        this.expPeriodEnd = expPeriodEnd;
        this.levelExpId = levelExpId;
        this.typeEmpId = typeEmpId;
        this.posteId = posteId;
        this.levelExp = levelExp;
        this.typeEmp = typeEmp;
        this.poste = poste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpCode() {
        return expCode;
    }

    public void setExpCode(String expCode) {
        this.expCode = expCode;
    }

    public String getExpDescription() {
        return expDescription;
    }

    public void setExpDescription(String expDescription) {
        this.expDescription = expDescription;
    }

    public String getExpDocument() {
        return expDocument;
    }

    public void setExpDocument(String expDocument) {
        this.expDocument = expDocument;
    }

    public String getExpLink() {
        return expLink;
    }

    public void setExpLink(String expLink) {
        this.expLink = expLink;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpPlace() {
        return expPlace;
    }

    public void setExpPlace(String expPlace) {
        this.expPlace = expPlace;
    }

    public int getExpPoint() {
        return expPoint;
    }

    public void setExpPoint(int expPoint) {
        this.expPoint = expPoint;
    }

    public String getExpPeriodStart() {
        return expPeriodStart;
    }

    public void setExpPeriodStart(String expPeriodStart) {
        this.expPeriodStart = expPeriodStart;
    }

    public String getExpPeriodEnd() {
        return expPeriodEnd;
    }

    public void setExpPeriodEnd(String expPeriodEnd) {
        this.expPeriodEnd = expPeriodEnd;
    }

    public int getLevelExpId() {
        return levelExpId;
    }

    public void setLevelExpId(int levelExpId) {
        this.levelExpId = levelExpId;
    }

    public int getTypeEmpId() {
        return typeEmpId;
    }

    public void setTypeEmpId(int typeEmpId) {
        this.typeEmpId = typeEmpId;
    }

    public int getPosteId() {
        return posteId;
    }

    public void setPosteId(int posteId) {
        this.posteId = posteId;
    }

    public LevelExperience getLevelExp() {
        return levelExp;
    }

    public void setLevelExp(LevelExperience levelExp) {
        this.levelExp = levelExp;
    }

    public TypeEmploi getTypeEmp() {
        return typeEmp;
    }

    public void setTypeEmp(TypeEmploi typeEmp) {
        this.typeEmp = typeEmp;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }
}
