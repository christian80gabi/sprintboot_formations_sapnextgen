package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.CategorySkillDto;
import tn.gov.douane.formations.api.model.CategorySkill;

import java.util.List;

public interface CategorySkillService {
    public List<CategorySkill> getAllCategorySkill();
    public CategorySkill getCategorySkillById(long objId);
    public CategorySkill getOneByName(String name);
    public CategorySkill createCategorySkill(CategorySkillDto categorySkillDto);
    public CategorySkill updateCategorySkill(CategorySkillDto categorySkillDto, long objId);
    public ResponseEntity<CategorySkill> deleteCategorySkill(long objId);
}
