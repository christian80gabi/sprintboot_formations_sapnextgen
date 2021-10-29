package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "skill", uniqueConstraints = @UniqueConstraint(name = "unique_skill_code", columnNames = {"skill_code"}))
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;

    @Column(name = "skill_code")
    private String skillCode;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_place")
    private String skillPlace;

    @Column(name = "skill_result")
    private String skillResult;

    @Column(name = "skill_document")
    private String skillDocument;

    @Column(name = "skill_link")
    private String skillLink;

    @Column(name = "skill_quota")
    private int skillQuota;

    @Column(name = "skill_period_start")
    private Date skillPeriodStart;

    @Column(name = "skill_period_end")
    private Date skillPeriodEnd;

    @Column(name = "skill_create_at")
    private Timestamp skillCreateAt;

    @Column(name = "skill_update_at")
    private Timestamp skillUpdateAt;

    @Column(name = "skill_delete_at")
    private Timestamp skillDeleteAt;

    @Column(name = "skill_statut")
    private int statut;

    @ManyToOne
    @JoinColumn(name = "skill_section_id")
    private SkillSection skillSectionId;

    @ManyToOne
    @JoinColumn(name = "level_skill_id")
    private LevelSkill levelSkillId;

    public Skill() {
    }

    public Skill(String skillCode, String skillName, String skillDescription,
                 String skillPlace, String skillResult, String skillDocument,
                 String skillLink, int skillQuota, Date skillPeriodStart, Date skillPeriodEnd,
                 Timestamp skillCreateAt, Timestamp skillUpdateAt, Timestamp skillDeleteAt, int statut) {
        this.skillCode = skillCode;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.skillPlace = skillPlace;
        this.skillResult = skillResult;
        this.skillDocument = skillDocument;
        this.skillLink = skillLink;
        this.skillQuota = skillQuota;
        this.skillPeriodStart = skillPeriodStart;
        this.skillPeriodEnd = skillPeriodEnd;
        this.skillCreateAt = skillCreateAt;
        this.skillUpdateAt = skillUpdateAt;
        this.skillDeleteAt = skillDeleteAt;
        this.statut = statut;
    }

    public Skill(Skill skill) {
        this.id = skill.id;
        this.skillCode = skill.skillCode;
        this.skillName = skill.skillName;
        this.skillDescription = skill.skillDescription;
        this.skillPlace = skill.skillPlace;
        this.skillResult = skill.skillResult;
        this.skillDocument = skill.skillDocument;
        this.skillLink = skill.skillLink;
        this.skillQuota = skill.skillQuota;
        this.skillPeriodStart = skill.skillPeriodStart;
        this.skillPeriodEnd = skill.skillPeriodEnd;
        this.skillCreateAt = skill.skillCreateAt;
        this.skillUpdateAt = skill.skillUpdateAt;
        this.skillDeleteAt = skill.skillDeleteAt;
        this.statut = skill.statut;
        this.levelSkillId = skill.levelSkillId;
        this.skillSectionId = skill.skillSectionId;
    }

    public long getId() {
        return id;
    }

    public String getSkillCode() {
        return skillCode;
    }

    public void setSkillCode(String skillCode) {
        this.skillCode = skillCode;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillPlace() {
        return skillPlace;
    }

    public void setSkillPlace(String skillPlace) {
        this.skillPlace = skillPlace;
    }

    public String getSkillResult() {
        return skillResult;
    }

    public void setSkillResult(String skillResult) {
        this.skillResult = skillResult;
    }

    public String getSkillDocument() {
        return skillDocument;
    }

    public void setSkillDocument(String skillDocument) {
        this.skillDocument = skillDocument;
    }

    public String getSkillLink() {
        return skillLink;
    }

    public void setSkillLink(String skillLink) {
        this.skillLink = skillLink;
    }

    public int getSkillQuota() {
        return skillQuota;
    }

    public void setSkillQuota(int skillQuota) {
        this.skillQuota = skillQuota;
    }

    public Date getSkillPeriodStart() {
        return skillPeriodStart;
    }

    public void setSkillPeriodStart(Date skillPeriodStart) {
        this.skillPeriodStart = skillPeriodStart;
    }

    public Date getSkillPeriodEnd() {
        return skillPeriodEnd;
    }

    public void setSkillPeriodEnd(Date skillPeriodEnd) {
        this.skillPeriodEnd = skillPeriodEnd;
    }

    public Timestamp getSkillCreateAt() {
        return skillCreateAt;
    }

    public void setSkillCreateAt(Timestamp skillCreateAt) {
        this.skillCreateAt = skillCreateAt;
    }

    public Timestamp getSkillUpdateAt() {
        return skillUpdateAt;
    }

    public void setSkillUpdateAt(Timestamp skillUpdateAt) {
        this.skillUpdateAt = skillUpdateAt;
    }

    public Timestamp getSkillDeleteAt() {
        return skillDeleteAt;
    }

    public void setSkillDeleteAt(Timestamp skillDeleteAt) {
        this.skillDeleteAt = skillDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public SkillSection getSkillSectionId() {
        return skillSectionId;
    }

    public void setSkillSectionId(SkillSection skillSectionId) {
        this.skillSectionId = skillSectionId;
    }

    public LevelSkill getLevelSkillId() {
        return levelSkillId;
    }

    public void setLevelSkillId(LevelSkill levelSkillId) {
        this.levelSkillId = levelSkillId;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillCode='" + skillCode + '\'' +
                ", skillName='" + skillName + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                ", skillPlace='" + skillPlace + '\'' +
                ", skillResult='" + skillResult + '\'' +
                ", skillDocument='" + skillDocument + '\'' +
                ", skillLink='" + skillLink + '\'' +
                ", skillQuota=" + skillQuota +
                ", skillPeriodStart=" + skillPeriodStart +
                ", skillPeriodEnd=" + skillPeriodEnd +
                ", skillCreateAt=" + skillCreateAt +
                ", skillUpdateAt=" + skillUpdateAt +
                ", skillDeleteAt=" + skillDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return getId() == skill.getId() &&
                getSkillQuota() == skill.getSkillQuota() &&
                getStatut() == skill.getStatut() &&
                getSkillCode().equals(skill.getSkillCode()) &&
                getSkillName().equals(skill.getSkillName()) &&
                getSkillDescription().equals(skill.getSkillDescription()) &&
                getSkillPlace().equals(skill.getSkillPlace()) &&
                getSkillResult().equals(skill.getSkillResult()) &&
                getSkillDocument().equals(skill.getSkillDocument()) &&
                getSkillLink().equals(skill.getSkillLink()) &&
                getSkillPeriodStart().equals(skill.getSkillPeriodStart()) &&
                getSkillPeriodEnd().equals(skill.getSkillPeriodEnd()) &&
                getSkillCreateAt().equals(skill.getSkillCreateAt()) &&
                getSkillUpdateAt().equals(skill.getSkillUpdateAt()) &&
                getSkillDeleteAt().equals(skill.getSkillDeleteAt()) &&
                getSkillSectionId().equals(skill.getSkillSectionId()) &&
                getLevelSkillId().equals(skill.getLevelSkillId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSkillCode(), getSkillName(), getSkillDescription(), getSkillPlace(), getSkillResult(), getSkillDocument(), getSkillLink(), getSkillQuota(), getSkillPeriodStart(), getSkillPeriodEnd(), getSkillCreateAt(), getSkillUpdateAt(), getSkillDeleteAt(), getStatut(), getSkillSectionId(), getLevelSkillId());
    }
}
