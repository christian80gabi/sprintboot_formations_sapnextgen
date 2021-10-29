package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Poste;

import java.util.List;

public class PreviousPosteDto {

    private int posteId;
    private int postePreviousId;
    private Poste poste;
    private Poste previousPoste;
    private List<Poste> postes;
    private List<Poste> previousPostes;

    public PreviousPosteDto() {
    }

    public PreviousPosteDto(int posteId, int postePreviousId) {
        this.posteId = posteId;
        this.postePreviousId = postePreviousId;
    }

    public int getPosteId() {
        return posteId;
    }

    public void setPosteId(int posteId) {
        this.posteId = posteId;
    }

    public int getPostePreviousId() {
        return postePreviousId;
    }

    public void setPostePreviousId(int postePreviousId) {
        this.postePreviousId = postePreviousId;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Poste getPreviousPoste() {
        return previousPoste;
    }

    public void setPreviousPoste(Poste previousPoste) {
        this.previousPoste = previousPoste;
    }

    public List<Poste> getPostes() {
        return postes;
    }

    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }

    public List<Poste> getPreviousPostes() {
        return previousPostes;
    }

    public void setPreviousPostes(List<Poste> previousPostes) {
        this.previousPostes = previousPostes;
    }
}
