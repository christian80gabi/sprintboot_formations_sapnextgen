package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "formation_section", uniqueConstraints = @UniqueConstraint(name = "unique_formation_section_code", columnNames = {"formation_section_code"}))
public class FormationSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formation_section_id")
    private long id;

    @Column(name = "formation_section_code")
    private String formationSectionCode;

    @Column(name = "formation_section_name")
    private String formationSectionName;

    @Column(name = "formation_section_description")
    private String formationSectionDescription;

    @Column(name = "formation_section_create_at")
    private Timestamp formationSectionCreateAt;

    @Column(name = "formation_section_update_at")
    private Timestamp formationSectionUpdateAt;

    @Column(name = "formation_section_delete_at")
    private Timestamp formationSectionDeleteAt;

    @Column(name = "formation_section_statut")
    private int statut;

    @ManyToOne
    @JoinColumn(name = "category_formation_id")
    private CategoryFormation categoryFormationId;

    public FormationSection() {
    }

    public FormationSection(String formationSectionCode, String formationSectionName,
                            String formationSectionDescription,
                            Timestamp formationSectionCreateAt, Timestamp formationSectionUpdateAt,
                            Timestamp formationSectionDeleteAt, int statut) {
        this.formationSectionCode = formationSectionCode;
        this.formationSectionName = formationSectionName;
        this.formationSectionDescription = formationSectionDescription;
        this.formationSectionCreateAt = formationSectionCreateAt;
        this.formationSectionUpdateAt = formationSectionUpdateAt;
        this.formationSectionDeleteAt = formationSectionDeleteAt;
        this.statut = statut;
    }

    public FormationSection(FormationSection formationSection) {
        this.id = formationSection.id;
        this.formationSectionCode = formationSection.formationSectionCode;
        this.formationSectionName = formationSection.formationSectionName;
        this.formationSectionDescription = formationSection.formationSectionDescription;
        this.formationSectionCreateAt = formationSection.formationSectionCreateAt;
        this.formationSectionUpdateAt = formationSection.formationSectionUpdateAt;
        this.formationSectionDeleteAt = formationSection.formationSectionDeleteAt;
        this.statut = formationSection.statut;
        this.categoryFormationId = formationSection.categoryFormationId;
    }

    public long getId() {
        return id;
    }

    public String getFormationSectionCode() {
        return formationSectionCode;
    }

    public void setFormationSectionCode(String formationSectionCode) {
        this.formationSectionCode = formationSectionCode;
    }

    public String getFormationSectionName() {
        return formationSectionName;
    }

    public void setFormationSectionName(String formationSectionName) {
        this.formationSectionName = formationSectionName;
    }

    public String getFormationSectionDescription() {
        return formationSectionDescription;
    }

    public void setFormationSectionDescription(String formationSectionDescription) {
        this.formationSectionDescription = formationSectionDescription;
    }

    public Timestamp getFormationSectionCreateAt() {
        return formationSectionCreateAt;
    }

    public void setFormationSectionCreateAt(Timestamp formationSectionCreateAt) {
        this.formationSectionCreateAt = formationSectionCreateAt;
    }

    public Timestamp getFormationSectionUpdateAt() {
        return formationSectionUpdateAt;
    }

    public void setFormationSectionUpdateAt(Timestamp formationSectionUpdateAt) {
        this.formationSectionUpdateAt = formationSectionUpdateAt;
    }

    public Timestamp getFormationSectionDeleteAt() {
        return formationSectionDeleteAt;
    }

    public void setFormationSectionDeleteAt(Timestamp formationSectionDelete) {
        this.formationSectionDeleteAt = formationSectionDelete;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public CategoryFormation getCategoryFormationId() {
        return categoryFormationId;
    }

    public void setCategoryFormationId(CategoryFormation categoryFormationId) {
        this.categoryFormationId = categoryFormationId;
    }

    @Override
    public String toString() {
        return "FormationSection{" +
                "id=" + id +
                ", formationSectionCode='" + formationSectionCode + '\'' +
                ", formationSectionName='" + formationSectionName + '\'' +
                ", formationSectionDescription='" + formationSectionDescription + '\'' +
                ", formationSectionCreateAt=" + formationSectionCreateAt +
                ", formationSectionUpdateAt=" + formationSectionUpdateAt +
                ", formationSectionDelete=" + formationSectionDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormationSection)) return false;
        FormationSection that = (FormationSection) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                getFormationSectionCode().equals(that.getFormationSectionCode()) &&
                getFormationSectionName().equals(that.getFormationSectionName()) &&
                getFormationSectionDescription().equals(that.getFormationSectionDescription()) &&
                getFormationSectionCreateAt().equals(that.getFormationSectionCreateAt()) &&
                getFormationSectionUpdateAt().equals(that.getFormationSectionUpdateAt()) &&
                getFormationSectionDeleteAt().equals(that.getFormationSectionDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFormationSectionCode(), getFormationSectionName(), getFormationSectionDescription(), getFormationSectionCreateAt(), getFormationSectionUpdateAt(), getFormationSectionDeleteAt(), getStatut());
    }
}
