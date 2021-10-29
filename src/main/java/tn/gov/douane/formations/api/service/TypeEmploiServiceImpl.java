package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.TypeEmploiDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.TypeEmploi;
import tn.gov.douane.formations.api.repository.TypeEmploiRepository;
import java.sql.Timestamp;
import java.util.List;

@Service
public class TypeEmploiServiceImpl implements TypeEmploiService{

    @Autowired
    private TypeEmploiRepository repo;

    public TypeEmploiServiceImpl() {
        super();
    }

    public TypeEmploiServiceImpl(TypeEmploiRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<TypeEmploi> getAllTypeEmploi() {
        return this.repo.findAll();
    }

    @Override
    public TypeEmploi getTypeEmploiById(long objId) {
        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Type emploi not found with id :"+objId)
                );
    }

    @Override
    public TypeEmploi getTypeEmploiByLibelle(String libelle) {

        List<TypeEmploi> typeEmplois = repo.findAll();
        TypeEmploi resultat = null;

        for (TypeEmploi obj : typeEmplois) {
            if (libelle.equalsIgnoreCase(obj.getTypeEmploiLibelle())){
                resultat = new TypeEmploi(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public TypeEmploi createTypeEmploi(TypeEmploiDto typeEmploiDto) {

        Timestamp time = GDate.precisionDateTime;
        TypeEmploi typeEmploi = new TypeEmploi();

        typeEmploi.setTypeEmploiLibelle(typeEmploiDto.getTypeEmpLibelle());
        typeEmploi.setTypeEmploiDescription(typeEmploiDto.getTypeEmpDescription());
        typeEmploi.setTypeEmploiCreateAt(time);
        typeEmploi.setTypeEmploiUpdateAt(time);
        typeEmploi.setTypeEmploiDeleteAt(time);
        typeEmploi.setStatut(GStatutObj.ADD);

        return this.repo.save(typeEmploi);
    }

    @Override
    public TypeEmploi updateTypeEmploi(TypeEmploiDto typeEmploiDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        TypeEmploi existingTypeEmploi = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Type emploi not found with id :"+objId));

        existingTypeEmploi.setTypeEmploiLibelle(typeEmploiDto.getTypeEmpLibelle());
        existingTypeEmploi.setTypeEmploiDescription(typeEmploiDto.getTypeEmpDescription());
        existingTypeEmploi.setTypeEmploiUpdateAt(time);
        existingTypeEmploi.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingTypeEmploi);
    }

    @Override
    public ResponseEntity<TypeEmploi> deleteTypeEmploi(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        TypeEmploi existingTypeEmploi = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Type emploi not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingTypeEmploi);
        return ResponseEntity.ok().build();
    }
}
