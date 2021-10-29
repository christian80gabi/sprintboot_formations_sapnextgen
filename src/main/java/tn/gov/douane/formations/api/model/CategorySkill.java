package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "category_skill", uniqueConstraints = @UniqueConstraint(name = "unique_category_skill_code", columnNames = {"category_skill_code"}))
public class CategorySkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_skill_id")
    private long id;

    @Column(name = "category_skill_code")
    private String categorySkillCode;

    @Column(name = "category_skill_name")
    private String categorySkillName;

    @Column(name = "category_skill_description")
    private String categorySkillDescription;

    @Column(name = "category_skill_create_at")
    private Timestamp categorySkillCreateAt;

    @Column(name = "category_skill_update_at")
    private Timestamp categorySkillUpdateAt;

    @Column(name = "category_skill_delete_at")
    private Timestamp categorySkillDeleteAt;

    @Column(name = "category_skill_statut")
    private int statut;

    public CategorySkill() {
    }

    public CategorySkill(String categorySkillCode, String categorySkillName, String categorySkillDescription, Timestamp categorySkillCreateAt, Timestamp categorySkillUpdateAt, Timestamp categorySkillDeleteAt, int statut) {
        this.categorySkillCode = categorySkillCode;
        this.categorySkillName = categorySkillName;
        this.categorySkillDescription = categorySkillDescription;
        this.categorySkillCreateAt = categorySkillCreateAt;
        this.categorySkillUpdateAt = categorySkillUpdateAt;
        this.categorySkillDeleteAt = categorySkillDeleteAt;
        this.statut = statut;
    }

    public CategorySkill(CategorySkill categorySkill) {
        this.id = categorySkill.id;
        this.categorySkillCode = categorySkill.categorySkillCode;
        this.categorySkillName = categorySkill.categorySkillName;
        this.categorySkillDescription = categorySkill.categorySkillDescription;
        this.categorySkillCreateAt = categorySkill.categorySkillCreateAt;
        this.categorySkillUpdateAt = categorySkill.categorySkillUpdateAt;
        this.categorySkillDeleteAt = categorySkill.categorySkillDeleteAt;
        this.statut = categorySkill.statut;
    }

    public long getId() {
        return id;
    }

    public String getCategorySkillCode() {
        return categorySkillCode;
    }

    public void setCategorySkillCode(String categorySkillCode) {
        this.categorySkillCode = categorySkillCode;
    }

    public String getCategorySkillName() {
        return categorySkillName;
    }

    public void setCategorySkillName(String categorySkillName) {
        this.categorySkillName = categorySkillName;
    }

    public String getCategorySkillDescription() {
        return categorySkillDescription;
    }

    public void setCategorySkillDescription(String categorySkillDescription) {
        this.categorySkillDescription = categorySkillDescription;
    }

    public Timestamp getCategorySkillCreateAt() {
        return categorySkillCreateAt;
    }

    public void setCategorySkillCreateAt(Timestamp categorySkillCreateAt) {
        this.categorySkillCreateAt = categorySkillCreateAt;
    }

    public Timestamp getCategorySkillUpdateAt() {
        return categorySkillUpdateAt;
    }

    public void setCategorySkillUpdateAt(Timestamp categorySkillUpdateAt) {
        this.categorySkillUpdateAt = categorySkillUpdateAt;
    }

    public Timestamp getCategorySkillDeleteAt() {
        return categorySkillDeleteAt;
    }

    public void setCategorySkillDeleteAt(Timestamp categorySkillDeleteAt) {
        this.categorySkillDeleteAt = categorySkillDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "CategorySkill{" +
                "id=" + id +
                ", categorySkillCode='" + categorySkillCode + '\'' +
                ", categorySkillName='" + categorySkillName + '\'' +
                ", categorySkillDescription='" + categorySkillDescription + '\'' +
                ", categorySkillCreateAt=" + categorySkillCreateAt +
                ", categorySkillUpdateAt=" + categorySkillUpdateAt +
                ", categorySkillDeleteAt=" + categorySkillDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategorySkill)) return false;
        CategorySkill that = (CategorySkill) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                getCategorySkillCode().equals(that.getCategorySkillCode()) &&
                getCategorySkillName().equals(that.getCategorySkillName()) &&
                getCategorySkillDescription().equals(that.getCategorySkillDescription()) &&
                getCategorySkillCreateAt().equals(that.getCategorySkillCreateAt()) &&
                getCategorySkillUpdateAt().equals(that.getCategorySkillUpdateAt()) &&
                getCategorySkillDeleteAt().equals(that.getCategorySkillDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategorySkillCode(), getCategorySkillName(), getCategorySkillDescription(), getCategorySkillCreateAt(), getCategorySkillUpdateAt(), getCategorySkillDeleteAt(), getStatut());
    }
}
