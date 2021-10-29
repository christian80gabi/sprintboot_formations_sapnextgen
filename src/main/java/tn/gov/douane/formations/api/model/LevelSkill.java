package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "level_skill", uniqueConstraints = @UniqueConstraint(name = "unique_level_skill_code", columnNames = {"level_skill_code"}))
public class LevelSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_skill_id")
    private long id;

    @Column(name = "level_skill_code")
    private String levelSkillCode;

    @Column(name = "level_skill_description")
    private String levelSkillDescription;

    @Column(name = "level_skill_poids")
    private double levelSkillPoids;

    @Column(name = "level_skill_create_at")
    private Timestamp levelSkillCreateAt;

    @Column(name = "level_skill_update_at")
    private Timestamp levelSkillUpdateAt;

    @Column(name = "level_skill_delete_at")
    private Timestamp levelSkillDeleteAt;

    @Column(name = "level_skill_statut")
    private int statut;

    public LevelSkill() {
    }

    public LevelSkill(String levelSkillCode, String levelSkillDescription, double levelSkillPoids, Timestamp levelSkillCreateAt,
                      Timestamp levelSkillUpdateAt, Timestamp levelSkillDeleteAt, int statut) {
        this.levelSkillCode = levelSkillCode;
        this.levelSkillDescription = levelSkillDescription;
        this.levelSkillPoids = levelSkillPoids;
        this.levelSkillCreateAt = levelSkillCreateAt;
        this.levelSkillUpdateAt = levelSkillUpdateAt;
        this.levelSkillDeleteAt = levelSkillDeleteAt;
        this.statut = statut;
    }

    public LevelSkill(LevelSkill levelSkill) {
        this.id = levelSkill.id;
        this.levelSkillCode = levelSkill.levelSkillCode;
        this.levelSkillDescription = levelSkill.levelSkillDescription;
        this.levelSkillPoids = levelSkill.levelSkillPoids;
        this.levelSkillCreateAt = levelSkill.levelSkillCreateAt;
        this.levelSkillUpdateAt = levelSkill.levelSkillUpdateAt;
        this.levelSkillDeleteAt = levelSkill.levelSkillDeleteAt;
        this.statut = levelSkill.statut;
    }

    public long getId() {
        return id;
    }

    public String getLevelSkillCode() {
        return levelSkillCode;
    }

    public void setLevelSkillCode(String levelSkillCode) {
        this.levelSkillCode = levelSkillCode;
    }

    public String getLevelSkillDescription() {
        return levelSkillDescription;
    }

    public void setLevelSkillDescription(String levelSkillDescription) {
        this.levelSkillDescription = levelSkillDescription;
    }

    public double getLevelSkillPoids() {
        return levelSkillPoids;
    }

    public void setLevelSkillPoids(double levelSkillPoids) {
        this.levelSkillPoids = levelSkillPoids;
    }

    public Timestamp getLevelSkillCreateAt() {
        return levelSkillCreateAt;
    }

    public void setLevelSkillCreateAt(Timestamp levelSkillCreateAt) {
        this.levelSkillCreateAt = levelSkillCreateAt;
    }

    public Timestamp getLevelSkillUpdateAt() {
        return levelSkillUpdateAt;
    }

    public void setLevelSkillUpdateAt(Timestamp levelSkillUpdateAt) {
        this.levelSkillUpdateAt = levelSkillUpdateAt;
    }

    public Timestamp getLevelSkillDeleteAt() {
        return levelSkillDeleteAt;
    }

    public void setLevelSkillDeleteAt(Timestamp levelSkillDeleteAt) {
        this.levelSkillDeleteAt = levelSkillDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "LevelSkill{" +
                "id=" + id +
                ", levelSkillCode='" + levelSkillCode + '\'' +
                ", levelSkillDescription='" + levelSkillDescription + '\'' +
                ", levelSkillPoids='" + levelSkillPoids + '\'' +
                ", levelSkillCreateAt=" + levelSkillCreateAt +
                ", levelSkillUpdateAt=" + levelSkillUpdateAt +
                ", levelSkillDeleteAt=" + levelSkillDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LevelSkill)) return false;
        LevelSkill that = (LevelSkill) o;
        return getId() == that.getId() &&
                Double.compare(that.getLevelSkillPoids(), getLevelSkillPoids()) == 0 &&
                getStatut() == that.getStatut() &&
                getLevelSkillCode().equals(that.getLevelSkillCode()) &&
                getLevelSkillDescription().equals(that.getLevelSkillDescription()) &&
                getLevelSkillCreateAt().equals(that.getLevelSkillCreateAt()) &&
                getLevelSkillUpdateAt().equals(that.getLevelSkillUpdateAt()) &&
                getLevelSkillDeleteAt().equals(that.getLevelSkillDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLevelSkillCode(), getLevelSkillDescription(), getLevelSkillPoids(), getLevelSkillCreateAt(), getLevelSkillUpdateAt(), getLevelSkillDeleteAt(), getStatut());
    }
}
