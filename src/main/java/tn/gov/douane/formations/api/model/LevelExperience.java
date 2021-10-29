package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "level_experience", uniqueConstraints = @UniqueConstraint(name = "unique_level_exp_code", columnNames = {"level_exp_code"}))
public class LevelExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_exp_id")
    private long id;

    @Column(name = "level_exp_code")
    private String levelExperienceCode;

    @Column(name = "level_exp_description")
    private String levelExperienceDescription;

    @Column(name = "level_exp_poids")
    private int levelExperiencePoids;

    @Column(name = "level_exp_create_at")
    private Timestamp levelExperienceCreateAt;

    @Column(name = "level_exp_update_at")
    private Timestamp levelExperienceUpdateAt;

    @Column(name = "level_exp_delete_at")
    private Timestamp levelExperienceDeleteAt;

    @Column(name = "level_exp_statut")
    private int statut;

    public LevelExperience() {
    }

    public LevelExperience(String levelExperienceCode, String levelExperienceDescription, int levelExperiencePoids, Timestamp levelExperienceCreateAt,
                           Timestamp levelExperienceUpdateAt, Timestamp levelExperienceDeleteAt, int statut) {
        this.levelExperienceCode = levelExperienceCode;
        this.levelExperienceDescription = levelExperienceDescription;
        this.levelExperiencePoids = levelExperiencePoids;
        this.levelExperienceCreateAt = levelExperienceCreateAt;
        this.levelExperienceUpdateAt = levelExperienceUpdateAt;
        this.levelExperienceDeleteAt = levelExperienceDeleteAt;
        this.statut = statut;
    }

    public LevelExperience(LevelExperience level) {
        this.id = level.id;
        this.levelExperienceCode = level.levelExperienceCode;
        this.levelExperienceDescription = level.levelExperienceDescription;
        this.levelExperiencePoids = level.levelExperiencePoids;
        this.levelExperienceCreateAt = level.levelExperienceCreateAt;
        this.levelExperienceUpdateAt = level.levelExperienceUpdateAt;
        this.levelExperienceDeleteAt = level.levelExperienceDeleteAt;
        this.statut = level.statut;
    }

    public long getId() {
        return id;
    }

    public String getLevelExperienceCode() {
        return levelExperienceCode;
    }

    public void setLevelExperienceCode(String levelExperienceCode) {
        this.levelExperienceCode = levelExperienceCode;
    }

    public String getLevelExperienceDescription() {
        return levelExperienceDescription;
    }

    public void setLevelExperienceDescription(String levelExperienceDescription) {
        this.levelExperienceDescription = levelExperienceDescription;
    }

    public int getLevelExperiencePoids() {
        return levelExperiencePoids;
    }

    public void setLevelExperiencePoids(int levelExperiencePoids) {
        this.levelExperiencePoids = levelExperiencePoids;
    }

    public Timestamp getLevelExperienceCreateAt() {
        return levelExperienceCreateAt;
    }

    public void setLevelExperienceCreateAt(Timestamp levelExperienceCreateAt) {
        this.levelExperienceCreateAt = levelExperienceCreateAt;
    }

    public Timestamp getLevelExperienceUpdateAt() {
        return levelExperienceUpdateAt;
    }

    public void setLevelExperienceUpdateAt(Timestamp levelExperienceUpdateAt) {
        this.levelExperienceUpdateAt = levelExperienceUpdateAt;
    }

    public Timestamp getLevelExperienceDeleteAt() {
        return levelExperienceDeleteAt;
    }

    public void setLevelExperienceDeleteAt(Timestamp levelExperienceDeleteAt) {
        this.levelExperienceDeleteAt = levelExperienceDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "LevelExperience{" +
                "id=" + id +
                ", levelExperienceCode='" + levelExperienceCode + '\'' +
                ", levelExperienceDescription='" + levelExperienceDescription + '\'' +
                ", levelExperiencePoids='" + levelExperiencePoids + '\'' +
                ", levelExperienceCreateAt=" + levelExperienceCreateAt +
                ", levelExperienceUpdateAt=" + levelExperienceUpdateAt +
                ", levelExperienceDeleteAt=" + levelExperienceDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LevelExperience)) return false;
        LevelExperience that = (LevelExperience) o;
        return getId() == that.getId() &&
                getLevelExperiencePoids() == that.getLevelExperiencePoids() &&
                getStatut() == that.getStatut() &&
                getLevelExperienceCode().equals(that.getLevelExperienceCode()) &&
                getLevelExperienceDescription().equals(that.getLevelExperienceDescription()) &&
                getLevelExperienceCreateAt().equals(that.getLevelExperienceCreateAt()) &&
                getLevelExperienceUpdateAt().equals(that.getLevelExperienceUpdateAt()) &&
                getLevelExperienceDeleteAt().equals(that.getLevelExperienceDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLevelExperienceCode(), getLevelExperienceDescription(), getLevelExperiencePoids(), getLevelExperienceCreateAt(), getLevelExperienceUpdateAt(), getLevelExperienceDeleteAt(), getStatut());
    }
}
