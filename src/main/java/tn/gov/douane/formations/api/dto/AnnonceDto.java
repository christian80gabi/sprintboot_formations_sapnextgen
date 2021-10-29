package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Poste;

public class AnnonceDto {

    private int id;
    private String annonceLabel;
    private String annonceDescription;
    private int posteId;
    private Poste poste;

    public AnnonceDto() {
    }

    public AnnonceDto(int id, String annonceLabel, String annonceDescription, int posteId) {
        this.id = id;
        this.annonceLabel = annonceLabel;
        this.annonceDescription = annonceDescription;
        this.posteId = posteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnnonceDescription() {
        return this.annonceDescription;
    }

    public void setAnnonceDescription(String annonceDescription) {
        this.annonceDescription = annonceDescription;
    }

    public String getAnnonceLabel() {
        return this.annonceLabel;
    }

    public void setAnnonceLabel(String annonceLabel) {
        this.annonceLabel = annonceLabel;
    }

    public int getPosteId() {
        return this.posteId;
    }

    public void setPosteId(int posteId) {
        this.posteId = posteId;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }
}
