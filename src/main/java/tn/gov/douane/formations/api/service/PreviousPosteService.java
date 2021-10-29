package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.PreviousPosteDto;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.PreviousPoste;

import java.util.List;

public interface PreviousPosteService {
    public List<PreviousPoste> getAllPreviousPoste();
    public PreviousPoste getPreviousPosteById(long objId);
    public List<Poste> getPreviousPosteByPoste(long posteId);
    public PreviousPoste createPreviousPoste(PreviousPosteDto previousPosteDto);
    public PreviousPoste updatePreviousPoste(PreviousPosteDto previousPosteDto, long objId);
    public ResponseEntity<PreviousPoste> deletePreviousPoste(long objId);
}
