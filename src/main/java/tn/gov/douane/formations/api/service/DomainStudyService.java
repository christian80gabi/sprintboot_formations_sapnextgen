package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.DomainStudyDto;
import tn.gov.douane.formations.api.model.DomainStudy;

import java.util.List;

public interface DomainStudyService {
    public List<DomainStudy> getAllDomainStudy();
    public DomainStudy getDomainStudyById(long objId);
    public DomainStudy getDomainStudyByLabel(String label);
    public DomainStudy createDomainStudy(DomainStudyDto domainStudyDto);
    public DomainStudy updateDomainStudy(DomainStudyDto domainStudyDto, long objId);
    public ResponseEntity<DomainStudy> deleteDomainStudy(long objId);
}
