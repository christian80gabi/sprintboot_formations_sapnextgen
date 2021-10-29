package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.TypeEmploiDto;
import tn.gov.douane.formations.api.model.TypeEmploi;

import java.util.List;

public interface TypeEmploiService {
    public List<TypeEmploi> getAllTypeEmploi();
    public TypeEmploi getTypeEmploiById(long objId);
    public TypeEmploi getTypeEmploiByLibelle(String libelle);
    public TypeEmploi createTypeEmploi(TypeEmploiDto typeEmploiDto);
    public TypeEmploi updateTypeEmploi(TypeEmploiDto typeEmploiDto, long objId);
    public ResponseEntity<TypeEmploi> deleteTypeEmploi(long objId);

}
