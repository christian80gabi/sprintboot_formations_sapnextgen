package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "poste_statut", uniqueConstraints = @UniqueConstraint(name = "unique_poste_statut_label", columnNames = {"poste_statut_label"}))
public class PosteStatut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poste_statut_id")
    private long id;

    @Column(name = "poste_statut_label")
    private String posteStatutLabel;

    @Column(name = "poste_statut_flag")
    private boolean posteStatutFlag;

    @Column(name = "poste_statut_create_at")
    private Timestamp createAt;

    @Column(name = "poste_statut_update_at")
    private Timestamp updateAt;

    @Column(name = "poste_statut_delete_at")
    private Timestamp deleteAt;

    @Column(name = "poste_statut_statut")
    private int statut;

    public PosteStatut() {
    }

    public PosteStatut(String posteStatutLabel, boolean posteStatutFlag, Timestamp createAt, Timestamp updateAt, Timestamp deleteAt, int statut) {
        this.posteStatutLabel = posteStatutLabel;
        this.posteStatutFlag = posteStatutFlag;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleteAt = deleteAt;
        this.statut = statut;
    }

    public PosteStatut(PosteStatut posteStatut){
        this.id = posteStatut.id;
        this.posteStatutLabel = posteStatut.posteStatutLabel;
        this.posteStatutFlag = posteStatut.posteStatutFlag;
        this.createAt = posteStatut.createAt;
        this.updateAt = posteStatut.updateAt;
        this.deleteAt = posteStatut.deleteAt;
        this.statut = posteStatut.statut;
    }

    public long getId() {
        return id;
    }

    public String getPosteStatutLabel() {
        return posteStatutLabel;
    }

    public void setPosteStatutLabel(String posteStatutLabel) {
        this.posteStatutLabel = posteStatutLabel;
    }

    public boolean isPosteStatutFlag() {
        return posteStatutFlag;
    }

    public void setPosteStatutFlag(boolean posteStatutFlag) {
        this.posteStatutFlag = posteStatutFlag;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Timestamp getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Timestamp deleteAt) {
        this.deleteAt = deleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "PosteStatut{" +
                "id=" + id +
                ", posteStatutLabel='" + posteStatutLabel + '\'' +
                ", posteStatutFlag=" + posteStatutFlag +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleteAt=" + deleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PosteStatut)) return false;
        PosteStatut that = (PosteStatut) o;
        return getId() == that.getId() &&
                isPosteStatutFlag() == that.isPosteStatutFlag() &&
                getStatut() == that.getStatut() &&
                getPosteStatutLabel().equals(that.getPosteStatutLabel()) &&
                getCreateAt().equals(that.getCreateAt()) &&
                getUpdateAt().equals(that.getUpdateAt()) &&
                getDeleteAt().equals(that.getDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPosteStatutLabel(), isPosteStatutFlag(), getCreateAt(), getUpdateAt(), getDeleteAt(), getStatut());
    }
}
