package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.DomainStudyDto;
import tn.gov.douane.formations.api.model.DomainStudy;
import tn.gov.douane.formations.api.service.DomainStudyServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/domainstudy")
public class DomainStudyControllerImpl implements DomainStudyController {

    @Autowired
    private DomainStudyServiceImpl service;

    public DomainStudyControllerImpl (){ super();}

    public DomainStudyControllerImpl(DomainStudyServiceImpl service) {
        super();
        this.service = service;
    }

    //get all DomainStudy
    @GetMapping
    public List<DomainStudy> getAllDomainStudy() {
        return this.service.getAllDomainStudy();
    }

    //get all DomainStudy by Id
    @GetMapping("/{id}")
    public DomainStudy getDomainStudyById(@PathVariable(value = "id") long objId) {
        return this.service.getDomainStudyById(objId);
    }

    //get all DomainStudy by label
    @GetMapping("/")
    @ResponseBody
    public DomainStudy getDomainStudyByLabel(@RequestParam String label) {
        return this.service.getDomainStudyByLabel(label);
    }

    //  create DomainStudy
    @PostMapping
    public DomainStudy createDomainStudy(@RequestBody DomainStudyDto domainStudyDto) {
        return this.service.createDomainStudy(domainStudyDto);
    }

    //  update DomainStudy
    @PutMapping("/{id}")
    public DomainStudy updateDomainStudy(@RequestBody DomainStudyDto domainStudyDto, @PathVariable(value = "id") long objId) {
        return this.service.updateDomainStudy(domainStudyDto, objId);
    }

    //delete domainStudy by id
    @DeleteMapping("/{id}")
    public ResponseEntity<DomainStudy> deleteDomainStudy(@PathVariable(value = "id") long objId) {
        return this.service.deleteDomainStudy(objId);
    }
}
