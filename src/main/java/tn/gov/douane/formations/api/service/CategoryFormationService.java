package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.CategoryFormationDto;
import tn.gov.douane.formations.api.model.CategoryFormation;

import java.util.List;

public interface CategoryFormationService {
    public List<CategoryFormation> getAllCategoryFormation();
    public CategoryFormation getCategoryFormationById(long objId);
    public CategoryFormation getCategoryFormationByLabel(String code);
    public CategoryFormation createCategoryFormation(CategoryFormationDto categoryFormationDto);
    public CategoryFormation updateCategoryFormation(CategoryFormationDto categoryFormationDto, long objId);
    public ResponseEntity<CategoryFormation> deleteCategoryFormation(long objId);
}

