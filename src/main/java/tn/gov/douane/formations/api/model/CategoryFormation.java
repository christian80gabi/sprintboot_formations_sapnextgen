package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "category_formation", uniqueConstraints = @UniqueConstraint(name = "unique_category_formation_code", columnNames = {"category_formation_code"}))
public class CategoryFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_formation_id")
    private long id;

    @Column(name = "category_formation_code")
    private String categoryFormationCode;

    @Column(name = "category_formation_name")
    private String categoryFormationName;

    @Column(name = "category_formation_description")
    private String categoryFormationDescription;

    @Column(name = "category_formation_create_at")
    private Timestamp categoryFormationCreateAt;

    @Column(name = "category_formation_update_at")
    private Timestamp categoryFormationUpdateAt;

    @Column(name = "category_formation_delete_at")
    private Timestamp categoryFormationDeleteAt;

    @Column(name = "category_formation_statut")
    private int statut;

    public CategoryFormation() {
    }

    public CategoryFormation(String categoryFormationCode, String categoryFormationName, String categoryFormationDescription, Timestamp categoryFormationCreateAt,
                             Timestamp categoryFormationUpdateAt, Timestamp categoryFormationDeleteAt, int statut) {
        this.categoryFormationCode = categoryFormationCode;
        this.categoryFormationName = categoryFormationName;
        this.categoryFormationDescription = categoryFormationDescription;
        this.categoryFormationCreateAt = categoryFormationCreateAt;
        this.categoryFormationUpdateAt = categoryFormationUpdateAt;
        this.categoryFormationDeleteAt = categoryFormationDeleteAt;
        this.statut = statut;
    }

    public CategoryFormation(CategoryFormation categoryFormation) {
        this.id = categoryFormation.id;
        this.categoryFormationCode = categoryFormation.categoryFormationCode;
        this.categoryFormationName = categoryFormation.categoryFormationName;
        this.categoryFormationDescription = categoryFormation.categoryFormationDescription;
        this.categoryFormationCreateAt = categoryFormation.categoryFormationCreateAt;
        this.categoryFormationUpdateAt = categoryFormation.categoryFormationUpdateAt;
        this.categoryFormationDeleteAt = categoryFormation.categoryFormationDeleteAt;
        this.statut = categoryFormation.statut;
    }

    public long getId() {
        return id;
    }

    public String getCategoryFormationCode() {
        return categoryFormationCode;
    }

    public void setCategoryFormationCode(String categoryFormationCode) {
        this.categoryFormationCode = categoryFormationCode;
    }

    public String getCategoryFormationName() {
        return categoryFormationName;
    }

    public void setCategoryFormationName(String categoryFormationName) {
        this.categoryFormationName = categoryFormationName;
    }

    public String getCategoryFormationDescription() {
        return categoryFormationDescription;
    }

    public void setCategoryFormationDescription(String categoryFormationDescription) {
        this.categoryFormationDescription = categoryFormationDescription;
    }

    public Timestamp getCategoryFormationCreateAt() {
        return categoryFormationCreateAt;
    }

    public void setCategoryFormationCreateAt(Timestamp categoryFormationCreateAt) {
        this.categoryFormationCreateAt = categoryFormationCreateAt;
    }

    public Timestamp getCategoryFormationUpdateAt() {
        return categoryFormationUpdateAt;
    }

    public void setCategoryFormationUpdateAt(Timestamp categoryFormationUpdateAt) {
        this.categoryFormationUpdateAt = categoryFormationUpdateAt;
    }

    public Timestamp getCategoryFormationDeleteAt() {
        return categoryFormationDeleteAt;
    }

    public void setCategoryFormationDeleteAt(Timestamp categoryFormationDeleteAt) {
        this.categoryFormationDeleteAt = categoryFormationDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "CategoryFormation{" +
                "id=" + id +
                ", categoryFormationCode='" + categoryFormationCode + '\'' +
                ", categoryFormationName='" + categoryFormationName + '\'' +
                ", categoryFormationDescription='" + categoryFormationDescription + '\'' +
                ", categoryFormationCreateAt=" + categoryFormationCreateAt +
                ", categoryFormationUpdateAt=" + categoryFormationUpdateAt +
                ", categoryFormationDeleteAt=" + categoryFormationDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryFormation)) return false;
        CategoryFormation that = (CategoryFormation) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                getCategoryFormationCode().equals(that.getCategoryFormationCode()) &&
                getCategoryFormationName().equals(that.getCategoryFormationName()) &&
                getCategoryFormationDescription().equals(that.getCategoryFormationDescription()) &&
                getCategoryFormationCreateAt().equals(that.getCategoryFormationCreateAt()) &&
                getCategoryFormationUpdateAt().equals(that.getCategoryFormationUpdateAt()) &&
                getCategoryFormationDeleteAt().equals(that.getCategoryFormationDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategoryFormationCode(), getCategoryFormationName(), getCategoryFormationDescription(), getCategoryFormationCreateAt(), getCategoryFormationUpdateAt(), getCategoryFormationDeleteAt(), getStatut());
    }
}
