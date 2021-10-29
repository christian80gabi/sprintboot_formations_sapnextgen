package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "level_formation", uniqueConstraints = @UniqueConstraint(name = "unique_level_formation_code", columnNames = {"level_formation_code"}))
public class LevelFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_formation_id")
    private long id;

    @Column(name = "level_formation_code")
    private String levelFormationCode;

    @Column(name = "level_formation_description")
    private String levelFormationDescription;

    @Column(name = "level_formation_poids")
    private int levelFormationPoids;

    @Column(name = "level_formation_create_at")
    private Timestamp levelFormationCreateAt;

    @Column(name = "level_formation_update_at")
    private Timestamp levelFormationUpdateAt;

    @Column(name = "level_formation_delete_at")
    private Timestamp levelFormationDeleteAt;

    @Column(name = "level_formation_statut")
    private int statut;

    public LevelFormation() {
    }

    public LevelFormation(String levelFormationCode, String levelFormationDescription, int levelFormationPoids, Timestamp levelFormationCreateAt, Timestamp levelFormationUpdateAt, Timestamp levelFormationDeleteAt, int statut) {
        this.levelFormationCode = levelFormationCode;
        this.levelFormationDescription = levelFormationDescription;
        this.levelFormationPoids = levelFormationPoids;
        this.levelFormationCreateAt = levelFormationCreateAt;
        this.levelFormationUpdateAt = levelFormationUpdateAt;
        this.levelFormationDeleteAt = levelFormationDeleteAt;
        this.statut = statut;
    }

    public LevelFormation(LevelFormation level) {
        this.id = level.id;
        this.levelFormationCode = level.levelFormationCode;
        this.levelFormationDescription = level.levelFormationDescription;
        this.levelFormationPoids = level.levelFormationPoids;
        this.levelFormationCreateAt = level.levelFormationCreateAt;
        this.levelFormationUpdateAt = level.levelFormationUpdateAt;
        this.levelFormationDeleteAt = level.levelFormationDeleteAt;
        this.statut = level.statut;
    }

    public long getId() {
        return id;
    }

    public String getLevelFormationCode() {
        return levelFormationCode;
    }

    public void setLevelFormationCode(String levelFormationCode) {
        this.levelFormationCode = levelFormationCode;
    }

    public String getLevelFormationDescription() {
        return levelFormationDescription;
    }

    public void setLevelFormationDescription(String levelFormationDescription) {
        this.levelFormationDescription = levelFormationDescription;
    }

    public int getLevelFormationPoids() {
        return levelFormationPoids;
    }

    public void setLevelFormationPoids(int levelFormationPoids) {
        this.levelFormationPoids = levelFormationPoids;
    }

    public Timestamp getLevelFormationCreateAt() {
        return levelFormationCreateAt;
    }

    public void setLevelFormationCreateAt(Timestamp levelFormationCreateAt) {
        this.levelFormationCreateAt = levelFormationCreateAt;
    }

    public Timestamp getLevelFormationUpdateAt() {
        return levelFormationUpdateAt;
    }

    public void setLevelFormationUpdateAt(Timestamp levelFormationUpdateAt) {
        this.levelFormationUpdateAt = levelFormationUpdateAt;
    }

    public Timestamp getLevelFormationDeleteAt() {
        return levelFormationDeleteAt;
    }

    public void setLevelFormationDeleteAt(Timestamp levelFormationDeleteAt) {
        this.levelFormationDeleteAt = levelFormationDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "LevelFormation{" +
                "id=" + id +
                ", levelFormationCode='" + levelFormationCode + '\'' +
                ", levelFormationDescription='" + levelFormationDescription + '\'' +
                ", levelFormationPoids='" + levelFormationPoids + '\'' +
                ", levelFormationCreateAt=" + levelFormationCreateAt +
                ", levelFormationUpdateAt=" + levelFormationUpdateAt +
                ", levelFormationDeleteAt=" + levelFormationDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LevelFormation)) return false;
        LevelFormation that = (LevelFormation) o;
        return getId() == that.getId() &&
                getLevelFormationPoids() == that.getLevelFormationPoids() &&
                getStatut() == that.getStatut() &&
                getLevelFormationCode().equals(that.getLevelFormationCode()) &&
                getLevelFormationDescription().equals(that.getLevelFormationDescription()) &&
                getLevelFormationCreateAt().equals(that.getLevelFormationCreateAt()) &&
                getLevelFormationUpdateAt().equals(that.getLevelFormationUpdateAt()) &&
                getLevelFormationDeleteAt().equals(that.getLevelFormationDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLevelFormationCode(), getLevelFormationDescription(), getLevelFormationPoids(), getLevelFormationCreateAt(), getLevelFormationUpdateAt(), getLevelFormationDeleteAt(), getStatut());
    }
}
