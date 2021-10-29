package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "grade", uniqueConstraints = @UniqueConstraint(name = "unique_grade_code", columnNames = {"grade_code"}))
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private long id;

    @Column(name = "grade_code")
    private String gradeCode;

    @Column(name = "grade_libelle")
    private String gradeLibelle;

    @Column(name = "grade_description")
    private String gradeDescription;

    @Column(name = "grade_niveau")
    private String gradeNiveau;

    @Column(name = "grade_create_at")
    private Timestamp gradeCreateAt;

    @Column(name = "grade_update_at")
    private Timestamp gradeUpdateAt;

    @Column(name = "grade_delete_at")
    private Timestamp gradeDeleteAt;

    @Column(name = "grade_statut")
    private int statut;

    public Grade() {
    }

    public Grade(String gradeCode, String gradeLibelle, String gradeDescription, String gradeNiveau, Timestamp gradeCreateAt, Timestamp gradeUpdateAt, Timestamp gradeDeleteAt, int statut) {
        this.gradeCode = gradeCode;
        this.gradeLibelle = gradeLibelle;
        this.gradeDescription = gradeDescription;
        this.gradeNiveau = gradeNiveau;
        this.gradeCreateAt = gradeCreateAt;
        this.gradeUpdateAt = gradeUpdateAt;
        this.gradeDeleteAt = gradeDeleteAt;
        this.statut = statut;
    }

    public Grade(Grade grade){
        this.id = grade.id;
        this.gradeCode = grade.gradeCode;
        this.gradeLibelle = grade.gradeLibelle;
        this.gradeDescription = grade.gradeDescription;
        this.gradeNiveau = grade.gradeNiveau;
        this.gradeCreateAt = grade.gradeCreateAt;
        this.gradeUpdateAt = grade.gradeUpdateAt;
        this.gradeDeleteAt = grade.gradeDeleteAt;
        this.statut = grade.statut;
    }

    public long getId() {
        return id;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeLibelle() {
        return gradeLibelle;
    }

    public void setGradeLibelle(String gradeLibelle) {
        this.gradeLibelle = gradeLibelle;
    }

    public String getGradeDescription() {
        return gradeDescription;
    }

    public void setGradeDescription(String gradeDescription) {
        this.gradeDescription = gradeDescription;
    }

    public String getGradeNiveau() {
        return gradeNiveau;
    }

    public void setGradeNiveau(String gradeNiveau) {
        this.gradeNiveau = gradeNiveau;
    }

    public Timestamp getGradeCreateAt() {
        return gradeCreateAt;
    }

    public void setGradeCreateAt(Timestamp gradeCreateAt) {
        this.gradeCreateAt = gradeCreateAt;
    }

    public Timestamp getGradeUpdateAt() {
        return gradeUpdateAt;
    }

    public void setGradeUpdateAt(Timestamp gradeUpdateAt) {
        this.gradeUpdateAt = gradeUpdateAt;
    }

    public Timestamp getGradeDeleteAt() {
        return gradeDeleteAt;
    }

    public void setGradeDeleteAt(Timestamp gradeDeleteAt) {
        this.gradeDeleteAt = gradeDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeCode='" + gradeCode + '\'' +
                ", gradeLibelle='" + gradeLibelle + '\'' +
                ", gradeDescription='" + gradeDescription + '\'' +
                ", gradeNiveau='" + gradeNiveau + '\'' +
                ", gradeCreateAt=" + gradeCreateAt +
                ", gradeUpdateAt=" + gradeUpdateAt +
                ", gradeDeleteAt=" + gradeDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;
        Grade grade = (Grade) o;
        return getId() == grade.getId() &&
                getStatut() == grade.getStatut() &&
                getGradeCode().equals(grade.getGradeCode()) &&
                getGradeLibelle().equals(grade.getGradeLibelle()) &&
                getGradeDescription().equals(grade.getGradeDescription()) &&
                getGradeNiveau().equals(grade.getGradeNiveau()) &&
                getGradeCreateAt().equals(grade.getGradeCreateAt()) &&
                getGradeUpdateAt().equals(grade.getGradeUpdateAt()) &&
                getGradeDeleteAt().equals(grade.getGradeDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGradeCode(), getGradeLibelle(), getGradeDescription(), getGradeNiveau(), getGradeCreateAt(), getGradeUpdateAt(), getGradeDeleteAt(), getStatut());
    }
}
