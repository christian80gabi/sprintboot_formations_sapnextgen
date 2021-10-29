package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.PosteDto;
import tn.gov.douane.formations.api.model.Poste;

import java.util.List;

public interface PosteService {
    public List<Poste> getAllPoste();
    public Poste getPosteById(long objId);
    public Poste getPosteByCode(String code);
    public Poste getPosteByLabel(String label);
    public List<Poste> getPosteByPreviousPoste(long previousPosteId);
    public Poste createPoste(PosteDto posteDto);
    public Poste updatePoste(PosteDto posteDto, long objId);
    public ResponseEntity<Poste> deletePoste(long objId);
}