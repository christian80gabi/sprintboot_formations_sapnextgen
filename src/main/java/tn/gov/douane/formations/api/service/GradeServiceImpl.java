package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.GradeDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.Grade;
import tn.gov.douane.formations.api.repository.GradeRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService{

    @Autowired
    private GradeRepository repo;

    public GradeServiceImpl() {
        super();
    }

    public GradeServiceImpl(GradeRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Grade> getAllGrade() {
        return repo.findAll();
    }

    @Override
    public Grade getGradeById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Grade not found with id :"+objId)
                );
    }

    @Override
    public Grade getGradeByLabel(String code) {

        List<Grade> grades = repo.findAll();
        Grade resultat = null;
        for (Grade obj : grades) {
            if (code.equalsIgnoreCase(obj.getGradeCode())){
                resultat = new Grade(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public Grade createGrade(GradeDto gradeDto) {

        Timestamp time = GDate.precisionDateTime;
        Grade grade = new Grade();
        grade.setGradeCode(gradeDto.getGradeCode());
        grade.setGradeDescription(gradeDto.getGradeDescription());
        grade.setGradeLibelle(gradeDto.getGradeLibelle());
        grade.setGradeNiveau(gradeDto.getGradeNiveau());
        grade.setGradeCreateAt(time);
        grade.setGradeUpdateAt(time);
        grade.setGradeDeleteAt(time);
        grade.setStatut(GStatutObj.ADD);
        return this.repo.save(grade);
    }

    @Override
    public Grade updateGrade(GradeDto gradeDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        Grade existingGrade = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Grade not found with id :"+objId));
        existingGrade.setGradeCode(gradeDto.getGradeCode());
        existingGrade.setGradeDescription(gradeDto.getGradeDescription());
        existingGrade.setGradeLibelle(gradeDto.getGradeLibelle());
        existingGrade.setGradeNiveau(gradeDto.getGradeNiveau());
        existingGrade.setGradeUpdateAt(time);
        existingGrade.setStatut(GStatutObj.UPDATE);
        return this.repo.save(existingGrade);
    }

    @Override
    public ResponseEntity<Grade> deleteGrade(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        Grade existingGrade = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Grade not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingGrade);
        return ResponseEntity.ok().build();
    }
}
