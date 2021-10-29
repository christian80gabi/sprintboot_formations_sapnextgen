package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.DomainStudyDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.DomainStudy;
import tn.gov.douane.formations.api.repository.DomainStudyRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DomainStudyServiceImpl implements DomainStudyService{

    @Autowired
    private DomainStudyRepository repo;

    public DomainStudyServiceImpl() {
        super();
    }

    public DomainStudyServiceImpl(DomainStudyRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<DomainStudy> getAllDomainStudy() {
        return repo.findAll();
    }

    @Override
    public DomainStudy getDomainStudyById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Domain study not found with id :"+objId)
                );
    }

    @Override
    public DomainStudy getDomainStudyByLabel(String label) {

        List<DomainStudy> domaines = repo.findAll();
        DomainStudy resultat = null;
        for (DomainStudy obj : domaines) {
            if (label.equalsIgnoreCase(obj.getDomainStudyLabel())){
                resultat = new DomainStudy(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public DomainStudy createDomainStudy(DomainStudyDto domainStudyDto) {

        Timestamp time = GDate.precisionDateTime;
        DomainStudy domainStudy = new DomainStudy();
        domainStudy.setDomainStudyLabel(domainStudyDto.getDomainStudyLabel());
        domainStudy.setDomainStudyCreateAt(time);
        domainStudy.setDomainStudyUpdateAt(time);
        domainStudy.setDomainStudyDeleteAt(time);
        domainStudy.setStatut(GStatutObj.ADD);
        return this.repo.save(domainStudy);
    }

    @Override
    public DomainStudy updateDomainStudy(DomainStudyDto domainStudyDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        DomainStudy existingDomainStudy = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Domain study not found with id :"+objId));
        existingDomainStudy.setDomainStudyLabel(domainStudyDto.getDomainStudyLabel());
        existingDomainStudy.setDomainStudyUpdateAt(time);
        existingDomainStudy.setStatut(GStatutObj.UPDATE);
        return this.repo.save(existingDomainStudy);
    }

    @Override
    public ResponseEntity<DomainStudy> deleteDomainStudy(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        DomainStudy existingDomainStudy = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Domain study not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingDomainStudy);
        return ResponseEntity.ok().build();
    }
}
