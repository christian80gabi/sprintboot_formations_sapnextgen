package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.CategoryFormationDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.CategoryFormation;
import tn.gov.douane.formations.api.repository.CategoryFormationRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CategoryFormationServiceImpl implements CategoryFormationService {

    @Autowired
    private CategoryFormationRepository repo;

    public CategoryFormationServiceImpl() {
        super();
    }

    public CategoryFormationServiceImpl(CategoryFormationRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<CategoryFormation> getAllCategoryFormation() {
        return this.repo.findAll();
    }

    @Override
    public CategoryFormation getCategoryFormationById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Category formation not found with id :"+objId)
                );
    }

    @Override
    public CategoryFormation getCategoryFormationByLabel(String code) {

        List<CategoryFormation> categoryFormations = repo.findAll();
        CategoryFormation resultat = null;

        for (CategoryFormation obj : categoryFormations) {

            if (code.equalsIgnoreCase(obj.getCategoryFormationCode())){
                resultat = new CategoryFormation(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public CategoryFormation createCategoryFormation(CategoryFormationDto categoryFormationDto) {

        Timestamp time = GDate.precisionDateTime;
        CategoryFormation categoryFormation = new CategoryFormation();
        categoryFormation.setCategoryFormationCode(categoryFormationDto.getCategoryFormationCode());
        categoryFormation.setCategoryFormationName(categoryFormationDto.getCategoryFormationName());
        categoryFormation.setCategoryFormationDescription(categoryFormationDto.getCategoryFormationDescription());
        categoryFormation.setCategoryFormationCreateAt(time);
        categoryFormation.setCategoryFormationUpdateAt(time);
        categoryFormation.setCategoryFormationDeleteAt(time);
        categoryFormation.setStatut(GStatutObj.ADD);
        return this.repo.save(categoryFormation);
    }

    @Override
    public CategoryFormation updateCategoryFormation(CategoryFormationDto categoryFormationDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        CategoryFormation existingCategoryFormation = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Category formation not found with id :"+objId));
        existingCategoryFormation.setCategoryFormationCode(categoryFormationDto.getCategoryFormationCode());
        existingCategoryFormation.setCategoryFormationName(categoryFormationDto.getCategoryFormationName());
        existingCategoryFormation.setCategoryFormationDescription(categoryFormationDto.getCategoryFormationDescription());
        existingCategoryFormation.setCategoryFormationUpdateAt(time);
        existingCategoryFormation.setStatut(GStatutObj.UPDATE);
        return this.repo.save(existingCategoryFormation);

    }
    @Override
    public ResponseEntity<CategoryFormation> deleteCategoryFormation(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        CategoryFormation existingCategoryFormation = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Category formation not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingCategoryFormation);
        return ResponseEntity.ok().build();
    }
}
