package tn.gov.douane.formations.app.user.controllers.interfaces;

public interface IProfilController extends IProfilFormationController, IProfilExperienceController, IProfilCompetenceController{
    public String change_profil_photo();
    public String reset_identifier();
}
