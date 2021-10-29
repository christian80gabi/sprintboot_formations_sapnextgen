package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "skill_section", uniqueConstraints = @UniqueConstraint(name = "unique_skill_section_code", columnNames = {"skill_section_code"}))
public class SkillSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_section_id")
    private long id;

    @Column(name = "skill_section_code")
    private String skillSectionCode;

    @Column(name = "skill_section_name")
    private String skillSectionName;

    @Column(name = "skill_section_description")
    private String skillSectionDescription;

    @Column(name = "skill_section_create_at")
    private Timestamp skillSectionCreateAt;

    @Column(name = "skill_section_update_at")
    private Timestamp skillSectionUpdateAt;

    @Column(name = "skill_section_delete_at")
    private Timestamp skillSectionDeleteAt;

    @Column(name = "skill_section_statut")
    private int statut;

    @ManyToOne
    @JoinColumn(name = "category_skill_id")
    private CategorySkill categorySkillId;

    public SkillSection() {}

    public SkillSection(String skillSectionCode, String skillSectionName, String skillSectionDescription,
                        Timestamp skillSectionCreateAt, Timestamp skillSectionUpdateAt,
                        Timestamp skillSectionDeleteAt, int statut) {
        this.skillSectionCode = skillSectionCode;
        this.skillSectionName = skillSectionName;
        this.skillSectionDescription = skillSectionDescription;
        this.skillSectionCreateAt = skillSectionCreateAt;
        this.skillSectionUpdateAt = skillSectionUpdateAt;
        this.skillSectionDeleteAt = skillSectionDeleteAt;
        this.statut = statut;
    }

    public SkillSection(SkillSection skillSection) {
        this.id = skillSection.id;
        this.skillSectionCode = skillSection.skillSectionCode;
        this.skillSectionName = skillSection.skillSectionName;
        this.skillSectionDescription = skillSection.skillSectionDescription;
        this.skillSectionCreateAt = skillSection.skillSectionCreateAt;
        this.skillSectionUpdateAt = skillSection.skillSectionUpdateAt;
        this.skillSectionDeleteAt = skillSection.skillSectionDeleteAt;
        this.statut = skillSection.statut;
        this.categorySkillId = skillSection.categorySkillId;
    }

    public long getId() {
        return id;
    }

    public String getSkillSectionCode() {
        return skillSectionCode;
    }

    public void setSkillSectionCode(String skillSectionCode) {
        this.skillSectionCode = skillSectionCode;
    }

    public String getSkillSectionName() {
        return skillSectionName;
    }

    public void setSkillSectionName(String skillSectionName) {
        this.skillSectionName = skillSectionName;
    }

    public String getSkillSectionDescription() {
        return skillSectionDescription;
    }

    public void setSkillSectionDescription(String skillSectionDescription) {
        this.skillSectionDescription = skillSectionDescription;
    }

    public Timestamp getSkillSectionCreateAt() {
        return skillSectionCreateAt;
    }

    public void setSkillSectionCreateAt(Timestamp skillSectionCreateAt) {
        this.skillSectionCreateAt = skillSectionCreateAt;
    }

    public Timestamp getSkillSectionUpdateAt() {
        return skillSectionUpdateAt;
    }

    public void setSkillSectionUpdateAt(Timestamp skillSectionUpdateAt) {
        this.skillSectionUpdateAt = skillSectionUpdateAt;
    }

    public Timestamp getSkillSectionDeleteAt() {
        return skillSectionDeleteAt;
    }

    public void setSkillSectionDeleteAt(Timestamp skillSectionDeleteAt) {
        this.skillSectionDeleteAt = skillSectionDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public CategorySkill getCategorySkillId() {
        return categorySkillId;
    }

    public void setCategorySkillId(CategorySkill categorySkillId) {
        this.categorySkillId = categorySkillId;
    }

    @Override
    public String toString() {
        return "SkillSection{" +
                "id=" + id +
                ", skillSectionCode='" + skillSectionCode + '\'' +
                ", skillSectionName='" + skillSectionName + '\'' +
                ", skillSectionDescription='" + skillSectionDescription + '\'' +
                ", skillSectionCreateAt=" + skillSectionCreateAt +
                ", skillSectionUpdateAt=" + skillSectionUpdateAt +
                ", skillSectionDeleteAt=" + skillSectionDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillSection)) return false;
        SkillSection that = (SkillSection) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                getSkillSectionCode().equals(that.getSkillSectionCode()) &&
                getSkillSectionName().equals(that.getSkillSectionName()) &&
                getSkillSectionDescription().equals(that.getSkillSectionDescription()) &&
                getSkillSectionCreateAt().equals(that.getSkillSectionCreateAt()) &&
                getSkillSectionUpdateAt().equals(that.getSkillSectionUpdateAt()) &&
                getSkillSectionDeleteAt().equals(that.getSkillSectionDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSkillSectionCode(), getSkillSectionName(), getSkillSectionDescription(), getSkillSectionCreateAt(), getSkillSectionUpdateAt(), getSkillSectionDeleteAt(), getStatut());
    }
}
