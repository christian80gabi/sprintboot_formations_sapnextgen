package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.PosteStatutDto;
import tn.gov.douane.formations.api.model.PosteStatut;

import java.util.List;

public interface PosteStatutService {
    public List<PosteStatut> getAllPosteStatut();
    public PosteStatut getPosteStatutById(long objId);
    public PosteStatut getPosteStatutByLabel(PosteStatutDto posteStatutDto);
    public PosteStatut createPosteStatut(PosteStatutDto posteStatutDto);
    public PosteStatut updatePosteStatut(PosteStatutDto posteStatutDto, long objId);
    public ResponseEntity<PosteStatut> deletePosteStatut(long objId);
}
