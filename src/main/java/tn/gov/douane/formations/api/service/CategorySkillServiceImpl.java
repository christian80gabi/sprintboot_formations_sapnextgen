package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.CategorySkillDto;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.CategorySkill;
import tn.gov.douane.formations.api.repository.CategorySkillRepository;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CategorySkillServiceImpl implements CategorySkillService{

    @Autowired
    private CategorySkillRepository repo;

    public CategorySkillServiceImpl() {
        super();
    }

    public CategorySkillServiceImpl(CategorySkillRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<CategorySkill> getAllCategorySkill() {
        return this.repo.findAll();
    }

    @Override
    public CategorySkill getCategorySkillById(long objId) {
        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Category Skill not found with id :"+objId)
                );
    }

    @Override
    public CategorySkill getOneByName(String name) {
        return null;
    }

    @Override
    public CategorySkill createCategorySkill(CategorySkillDto categorySkillDto) {

        Timestamp time = GDate.precisionDateTime;
        CategorySkill categorySkill = new CategorySkill();
        categorySkill.setCategorySkillCode(categorySkillDto.getCategorySkillCode());
        categorySkill.setCategorySkillName(categorySkillDto.getCategorySkillName());
        categorySkill.setCategorySkillDescription(categorySkillDto.getCategorySkillDescription());
        categorySkill.setCategorySkillCreateAt(time);
        categorySkill.setCategorySkillUpdateAt(time);
        categorySkill.setCategorySkillDeleteAt(time);
        categorySkill.setStatut(GStatutObj.ADD);
        return this.repo.save(categorySkill);
    }

    @Override
    public CategorySkill updateCategorySkill(CategorySkillDto categorySkillDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        CategorySkill existingCategorySkill = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Category Skill not found with id :"+objId));
        existingCategorySkill.setCategorySkillCode(categorySkillDto.getCategorySkillCode());
        existingCategorySkill.setCategorySkillName(categorySkillDto.getCategorySkillName());
        existingCategorySkill.setCategorySkillDescription(categorySkillDto.getCategorySkillDescription());
        existingCategorySkill.setCategorySkillUpdateAt(time);
        existingCategorySkill.setStatut(GStatutObj.UPDATE);
        return this.repo.save(existingCategorySkill);
    }

    @Override
    public ResponseEntity<CategorySkill> deleteCategorySkill(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        CategorySkill existingCategorySkill = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Category Skill not found with id :"+objId));
     /*   existingCategorySkill.setDeleteAt(time);
        existingCategorySkill.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingCategorySkill);
        return ResponseEntity.ok().build();

    }
}
