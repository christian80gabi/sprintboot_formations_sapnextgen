package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.GradeDto;
import tn.gov.douane.formations.api.model.Grade;

import java.util.List;

public interface GradeService {
    public List<Grade> getAllGrade();
    public Grade getGradeById(long objId);
    public Grade getGradeByLabel(String code);
    public Grade createGrade(GradeDto gradeDto);
    public Grade updateGrade(GradeDto gradeDto, long objId);
    public ResponseEntity<Grade> deleteGrade(long objId);
}