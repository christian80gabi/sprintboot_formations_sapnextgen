package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.DomainStudy;
import tn.gov.douane.formations.api.model.FormationSection;
import tn.gov.douane.formations.api.model.LevelFormation;

public class FormationDto {

    private int id;
    private String formationCode;
    private String formationDescription;
    private String formationDocument;
    private String formationLink;
    private String formationName;
    private String formationPlace;
    private Integer formationQuota;
    private String formationResult;
    private Integer formationStatut;
    private String formationPeriodStart;
    private String formationPeriodEnd;
    private int domainStudyId;
    private int levelFormationId;
    private int formationSectionId;
    private DomainStudy domainStudy;
    private LevelFormation levelFormation;
    private FormationSection formationSection;

    public FormationDto() {
    }

    public FormationDto(String formationCode, String formationDescription, String formationDocument, String formationLink,
                        String formationName, String formationPlace, Integer formationQuota, String formationResult,
                        Integer formationStatut, String formationPeriodStart, String formationPeriodEnd,
                        int domainStudyId, int levelFormationId, int formationSectionId,
                        DomainStudy domainStudy, LevelFormation levelFormation, FormationSection formationSection) {
        this.formationCode = formationCode;
        this.formationDescription = formationDescription;
        this.formationDocument = formationDocument;
        this.formationLink = formationLink;
        this.formationName = formationName;
        this.formationPlace = formationPlace;
        this.formationQuota = formationQuota;
        this.formationResult = formationResult;
        this.formationStatut = formationStatut;
        this.formationPeriodStart = formationPeriodStart;
        this.formationPeriodEnd = formationPeriodEnd;
        this.domainStudyId = domainStudyId;
        this.levelFormationId = levelFormationId;
        this.formationSectionId = formationSectionId;
        this.domainStudy = domainStudy;
        this.levelFormation = levelFormation;
        this.formationSection = formationSection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormationCode() {
        return formationCode;
    }

    public void setFormationCode(String formationCode) {
        this.formationCode = formationCode;
    }

    public String getFormationDescription() {
        return formationDescription;
    }

    public void setFormationDescription(String formationDescription) {
        this.formationDescription = formationDescription;
    }

    public String getFormationDocument() {
        return formationDocument;
    }

    public void setFormationDocument(String formationDocument) {
        this.formationDocument = formationDocument;
    }

    public String getFormationLink() {
        return formationLink;
    }

    public void setFormationLink(String formationLink) {
        this.formationLink = formationLink;
    }

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public String getFormationPlace() {
        return formationPlace;
    }

    public void setFormationPlace(String formationPlace) {
        this.formationPlace = formationPlace;
    }

    public Integer getFormationQuota() {
        return formationQuota;
    }

    public void setFormationQuota(Integer formationQuota) {
        this.formationQuota = formationQuota;
    }

    public String getFormationResult() {
        return formationResult;
    }

    public void setFormationResult(String formationResult) {
        this.formationResult = formationResult;
    }

    public Integer getFormationStatut() {
        return formationStatut;
    }

    public void setFormationStatut(Integer formationStatut) {
        this.formationStatut = formationStatut;
    }

    public String getFormationPeriodStart() {
        return formationPeriodStart;
    }

    public void setFormationPeriodStart(String formationPeriodStart) {
        this.formationPeriodStart = formationPeriodStart;
    }

    public String getFormationPeriodEnd() {
        return formationPeriodEnd;
    }

    public void setFormationPeriodEnd(String formationPeriodEnd) {
        this.formationPeriodEnd = formationPeriodEnd;
    }

    public int getDomainStudyId() {
        return domainStudyId;
    }

    public void setDomainStudyId(int domainStudyId) {
        this.domainStudyId = domainStudyId;
    }

    public int getLevelFormationId() {
        return levelFormationId;
    }

    public void setLevelFormationId(int levelFormationId) {
        this.levelFormationId = levelFormationId;
    }

    public int getFormationSectionId() {
        return formationSectionId;
    }

    public void setFormationSectionId(int formationSectionId) {
        this.formationSectionId = formationSectionId;
    }

    public DomainStudy getDomainStudy() {
        return domainStudy;
    }

    public void setDomainStudy(DomainStudy domainStudy) {
        this.domainStudy = domainStudy;
    }

    public LevelFormation getLevelFormation() {
        return levelFormation;
    }

    public void setLevelFormation(LevelFormation levelFormation) {
        this.levelFormation = levelFormation;
    }

    public FormationSection getFormationSection() {
        return formationSection;
    }

    public void setFormationSection(FormationSection formationSection) {
        this.formationSection = formationSection;
    }
}
