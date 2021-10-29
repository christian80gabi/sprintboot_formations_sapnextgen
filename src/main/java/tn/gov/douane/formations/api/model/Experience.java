package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "experience", uniqueConstraints = @UniqueConstraint(name = "unique_exp_code", columnNames = {"exp_code"}))
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;

    @Column(name = "exp_code")
    private String experienceCode;

    @Column(name = "exp_name")
    private String experienceName;

    @Column(name = "exp_description")
    private String experienceDescription;

    @Column(name = "exp_place")
    private String experiencePlace;

    @Column(name = "exp_document")
    private String experienceDocument;

    @Column(name = "exp_link")
    private String experienceLink;

    @Column(name = "exp_point")
    private int experiencePoint;

    @Column(name = "exp_period_start")
    private Date experiencePeriodStart;

    @Column(name = "exp_period_end")
    private Date experiencePeriodEnd;

    @Column(name = "exp_create_at")
    private Timestamp experienceCreateAt;

    @Column(name = "exp_update_at")
    private Timestamp experienceUpdateAt;

    @Column(name = "exp_delete_at")
    private Timestamp experienceDeleteAt;

    @Column(name = "exp_statut")
    private int statut;

    @ManyToOne
    @JoinColumn(name = "level_exp_id")
    private LevelExperience levelExperienceId;

    @ManyToOne
    @JoinColumn(name = "type_emp_id")
    private TypeEmploi typeEmploiId;

    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste posteId;

    public Experience() {
    }

    public Experience(String experienceCode, String experienceName, String experienceDescription,
                      String experiencePlace, String experienceDocument, String experienceLink,
                      int experiencePoint, Date experiencePeriodStart, Date experiencePeriodEnd,
                      Timestamp experienceCreateAt, Timestamp experienceUpdateAt, Timestamp experienceDeleteAt,
                      int statut) {
        this.experienceCode = experienceCode;
        this.experienceName = experienceName;
        this.experienceDescription = experienceDescription;
        this.experiencePlace = experiencePlace;
        this.experienceDocument = experienceDocument;
        this.experienceLink = experienceLink;
        this.experiencePoint = experiencePoint;
        this.experiencePeriodStart = experiencePeriodStart;
        this.experiencePeriodEnd = experiencePeriodEnd;
        this.experienceCreateAt = experienceCreateAt;
        this.experienceUpdateAt = experienceUpdateAt;
        this.experienceDeleteAt = experienceDeleteAt;
        this.statut = statut;
    }

    public Experience(Experience experience) {
        this.id = experience.id;
        this.experienceCode = experience.experienceCode;
        this.experienceName = experience.experienceName;
        this.experienceDescription = experience.experienceDescription;
        this.experiencePlace = experience.experiencePlace;
        this.experienceDocument = experience.experienceDocument;
        this.experienceLink = experience.experienceLink;
        this.experiencePoint = experience.experiencePoint;
        this.experiencePeriodStart = experience.experiencePeriodStart;
        this.experiencePeriodEnd = experience.experiencePeriodEnd;
        this.experienceCreateAt = experience.experienceCreateAt;
        this.experienceUpdateAt = experience.experienceUpdateAt;
        this.experienceDeleteAt = experience.experienceDeleteAt;
        this.statut = experience.statut;
        this.levelExperienceId = experience.levelExperienceId;
        this.typeEmploiId = experience.typeEmploiId;
        this.posteId = experience.posteId;
    }

    public long getId() {
        return id;
    }

    public String getExperienceCode() {
        return experienceCode;
    }

    public void setExperienceCode(String experienceCode) {
        this.experienceCode = experienceCode;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public String getExperienceDescription() {
        return experienceDescription;
    }

    public void setExperienceDescription(String experienceDescription) {
        this.experienceDescription = experienceDescription;
    }

    public String getExperiencePlace() {
        return experiencePlace;
    }

    public void setExperiencePlace(String experiencePlace) {
        this.experiencePlace = experiencePlace;
    }

    public String getExperienceDocument() {
        return experienceDocument;
    }

    public void setExperienceDocument(String experienceDocument) {
        this.experienceDocument = experienceDocument;
    }

    public String getExperienceLink() {
        return experienceLink;
    }

    public void setExperienceLink(String experienceLink) {
        this.experienceLink = experienceLink;
    }

    public int getExperiencePoint() {
        return experiencePoint;
    }

    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public Date getExperiencePeriodStart() {
        return experiencePeriodStart;
    }

    public void setExperiencePeriodStart(Date experiencePeriodStart) {
        this.experiencePeriodStart = experiencePeriodStart;
    }

    public Date getExperiencePeriodEnd() {
        return experiencePeriodEnd;
    }

    public void setExperiencePeriodEnd(Date experiencePeriodEnd) {
        this.experiencePeriodEnd = experiencePeriodEnd;
    }

    public Timestamp getExperienceCreateAt() {
        return experienceCreateAt;
    }

    public void setExperienceCreateAt(Timestamp experienceCreateAt) {
        this.experienceCreateAt = experienceCreateAt;
    }

    public Timestamp getExperienceUpdateAt() {
        return experienceUpdateAt;
    }

    public void setExperienceUpdateAt(Timestamp experienceUpdateAt) {
        this.experienceUpdateAt = experienceUpdateAt;
    }

    public Timestamp getExperienceDeleteAt() {
        return experienceDeleteAt;
    }

    public void setExperienceDeleteAt(Timestamp experienceDeleteAt) {
        this.experienceDeleteAt = experienceDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public LevelExperience getLevelExperienceId() {
        return levelExperienceId;
    }

    public void setLevelExperienceId(LevelExperience levelExperienceId) {
        this.levelExperienceId = levelExperienceId;
    }

    public TypeEmploi getTypeEmploiId() {
        return typeEmploiId;
    }

    public void setTypeEmploiId(TypeEmploi typeEmploiId) {
        this.typeEmploiId = typeEmploiId;
    }

    public Poste getPosteId() {
        return posteId;
    }

    public void setPosteId(Poste posteId) {
        this.posteId = posteId;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", experienceCode='" + experienceCode + '\'' +
                ", experienceName='" + experienceName + '\'' +
                ", experienceDescription='" + experienceDescription + '\'' +
                ", experiencePlace='" + experiencePlace + '\'' +
                ", experienceDocument='" + experienceDocument + '\'' +
                ", experienceLink='" + experienceLink + '\'' +
                ", experiencePoint=" + experiencePoint +
                ", experiencePeriodStart=" + experiencePeriodStart +
                ", experiencePeriodEnd=" + experiencePeriodEnd +
                ", experienceCreateAt=" + experienceCreateAt +
                ", experienceUpdateAt=" + experienceUpdateAt +
                ", experienceDeleteAt=" + experienceDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Experience)) return false;
        Experience that = (Experience) o;
        return getId() == that.getId() &&
                getExperiencePoint() == that.getExperiencePoint() &&
                getStatut() == that.getStatut() &&
                getExperienceCode().equals(that.getExperienceCode()) &&
                getExperienceName().equals(that.getExperienceName()) &&
                getExperienceDescription().equals(that.getExperienceDescription()) &&
                getExperiencePlace().equals(that.getExperiencePlace()) &&
                getExperienceDocument().equals(that.getExperienceDocument()) &&
                getExperienceLink().equals(that.getExperienceLink()) &&
                getExperiencePeriodStart().equals(that.getExperiencePeriodStart()) &&
                getExperiencePeriodEnd().equals(that.getExperiencePeriodEnd()) &&
                getExperienceCreateAt().equals(that.getExperienceCreateAt()) &&
                getExperienceUpdateAt().equals(that.getExperienceUpdateAt()) &&
                getExperienceDeleteAt().equals(that.getExperienceDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getExperienceCode(), getExperienceName(), getExperienceDescription(), getExperiencePlace(), getExperienceDocument(), getExperienceLink(), getExperiencePoint(), getExperiencePeriodStart(), getExperiencePeriodEnd(), getExperienceCreateAt(), getExperienceUpdateAt(), getExperienceDeleteAt(), getStatut());
    }
}
