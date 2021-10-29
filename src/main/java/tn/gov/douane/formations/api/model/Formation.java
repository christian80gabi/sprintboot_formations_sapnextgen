package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "formation", uniqueConstraints = @UniqueConstraint(name = "unique_formation_code", columnNames = {"formation_code"}))
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formation_id")
    private long id;

    @Column(name = "formation_code")
    private String formationCode;

    @Column(name = "formation_name")
    private String formationName;

    @Column(name = "formation_description")
    private String formationDescription;

    @Column(name = "formation_place")
    private String formationPlace;

    @Column(name = "formation_result")
    private String formationResult;

    @Column(name = "formation_document")
    private String formationDocument;

    @Column(name = "formation_link")
    private String formationLink;

    @Column(name = "formation_quota")
    private int formationQuota;

    @Column(name = "formation_period_start")
    private Date formationPeriodStart;

    @Column(name = "formation_period_end")
    private Date formationPeriodEnd;

    @Column(name = "formation_create_at")
    private Timestamp formationCreateAt;

    @Column(name = "formation_update_at")
    private Timestamp formationUpdateAt;

    @Column(name = "formation_delete_at")
    private Timestamp formationDeleteAt;

    @Column(name = "formation_statut")
    private int statut;

    @ManyToOne
    @JoinColumn(name = "level_formation_id")
    private LevelFormation formationLevelId;

    @ManyToOne
    @JoinColumn(name = "domain_study_id")
    private DomainStudy domainStudyId;

    @ManyToOne
    @JoinColumn(name = "formation_section_id")
    private FormationSection formationSectionId;

    public Formation() {
    }

    public Formation(String formationCode, String formationName, String formationDescription, String formationPlace, String formationResult, String formationDocument, String formationLink, int formationQuota, Date  formationPeriodStart, Date  formationPeriodEnd, Timestamp formationCreateAt, Timestamp formationUpdateAt, Timestamp formationDeleteAt, int statut) {
        this.formationCode = formationCode;
        this.formationName = formationName;
        this.formationDescription = formationDescription;
        this.formationPlace = formationPlace;
        this.formationResult = formationResult;
        this.formationDocument = formationDocument;
        this.formationLink = formationLink;
        this.formationQuota = formationQuota;
        this.formationPeriodStart = formationPeriodStart;
        this.formationPeriodEnd = formationPeriodEnd;
        this.formationCreateAt = formationCreateAt;
        this.formationUpdateAt = formationUpdateAt;
        this.formationDeleteAt = formationDeleteAt;
        this.statut = statut;
    }

    public Formation(Formation formation) {
        this.id = formation.id;
        this.formationCode = formation.formationCode;
        this.formationName = formation.formationName;
        this.formationDescription = formation.formationDescription;
        this.formationPlace = formation.formationPlace;
        this.formationResult = formation.formationResult;
        this.formationDocument = formation.formationDocument;
        this.formationLink = formation.formationLink;
        this.formationQuota = formation.formationQuota;
        this.formationPeriodStart = formation.formationPeriodStart;
        this.formationPeriodEnd = formation.formationPeriodEnd;
        this.formationCreateAt = formation.formationCreateAt;
        this.formationUpdateAt = formation.formationUpdateAt;
        this.formationDeleteAt = formation.formationDeleteAt;
        this.statut = formation.statut;
        this.domainStudyId = formation.domainStudyId;
        this.formationLevelId = formation.formationLevelId;
        this.formationSectionId = formation.formationSectionId;
    }

    public long getId() {
        return id;
    }

    public String getFormationCode() {
        return formationCode;
    }

    public void setFormationCode(String formationCode) {
        this.formationCode = formationCode;
    }

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public String getFormationDescription() {
        return formationDescription;
    }

    public void setFormationDescription(String formationDescription) {
        this.formationDescription = formationDescription;
    }

    public String getFormationPlace() {
        return formationPlace;
    }

    public void setFormationPlace(String formationPlace) {
        this.formationPlace = formationPlace;
    }

    public String getFormationResult() {
        return formationResult;
    }

    public void setFormationResult(String formationResult) {
        this.formationResult = formationResult;
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

    public int getFormationQuota() {
        return formationQuota;
    }

    public void setFormationQuota(int formationQuota) {
        this.formationQuota = formationQuota;
    }

    public Date  getFormationPeriodStart() {
        return formationPeriodStart;
    }

    public void setFormationPeriodStart(Date  formationPeriodStart) {
        this.formationPeriodStart = formationPeriodStart;
    }

    public Date  getFormationPeriodEnd() {
        return formationPeriodEnd;
    }

    public void setFormationPeriodEnd(Date  formationPeriodEnd) {
        this.formationPeriodEnd = formationPeriodEnd;
    }

    public Timestamp getFormationCreateAt() {
        return formationCreateAt;
    }

    public void setFormationCreateAt(Timestamp formationCreateAt) {
        this.formationCreateAt = formationCreateAt;
    }

    public Timestamp getFormationUpdateAt() {
        return formationUpdateAt;
    }

    public void setFormationUpdateAt(Timestamp formationUpdateAt) {
        this.formationUpdateAt = formationUpdateAt;
    }

    public Timestamp getFormationDeleteAt() {
        return formationDeleteAt;
    }

    public void setFormationDeleteAt(Timestamp formationDeleteAt) {
        this.formationDeleteAt = formationDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public LevelFormation getFormationLevelId() {
        return formationLevelId;
    }

    public void setFormationLevelId(LevelFormation formationLevelId) {
        this.formationLevelId = formationLevelId;
    }

    public DomainStudy getDomainStudyId() {
        return domainStudyId;
    }

    public void setDomainStudyId(DomainStudy domainStudyId) {
        this.domainStudyId = domainStudyId;
    }

    public FormationSection getFormationSectionId() {
        return formationSectionId;
    }

    public void setFormationSectionId(FormationSection formationSectionId) {
        this.formationSectionId = formationSectionId;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "id=" + id +
                ", formationCode='" + formationCode + '\'' +
                ", formationName='" + formationName + '\'' +
                ", formationDescription='" + formationDescription + '\'' +
                ", formationPlace='" + formationPlace + '\'' +
                ", formationResult='" + formationResult + '\'' +
                ", formationDocument='" + formationDocument + '\'' +
                ", formationLink='" + formationLink + '\'' +
                ", formationQuota=" + formationQuota +
                ", formationPeriodStart=" + formationPeriodStart +
                ", formationPeriodEnd=" + formationPeriodEnd +
                ", formationCreateAt=" + formationCreateAt +
                ", formationUpdateAt=" + formationUpdateAt +
                ", formationDeleteAt=" + formationDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formation)) return false;
        Formation formation = (Formation) o;
        return getId() == formation.getId() &&
                getFormationQuota() == formation.getFormationQuota() &&
                getStatut() == formation.getStatut() &&
                getFormationCode().equals(formation.getFormationCode()) &&
                getFormationName().equals(formation.getFormationName()) &&
                getFormationDescription().equals(formation.getFormationDescription()) &&
                getFormationPlace().equals(formation.getFormationPlace()) &&
                getFormationResult().equals(formation.getFormationResult()) &&
                getFormationDocument().equals(formation.getFormationDocument()) &&
                getFormationLink().equals(formation.getFormationLink()) &&
                getFormationPeriodStart().equals(formation.getFormationPeriodStart()) &&
                getFormationPeriodEnd().equals(formation.getFormationPeriodEnd()) &&
                getFormationCreateAt().equals(formation.getFormationCreateAt()) &&
                getFormationUpdateAt().equals(formation.getFormationUpdateAt()) &&
                getFormationDeleteAt().equals(formation.getFormationDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFormationCode(), getFormationName(), getFormationDescription(), getFormationPlace(), getFormationResult(), getFormationDocument(), getFormationLink(), getFormationQuota(), getFormationPeriodStart(), getFormationPeriodEnd(), getFormationCreateAt(), getFormationUpdateAt(), getFormationDeleteAt(), getStatut());
    }
}
