package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.UserPosteDto;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserPoste;

import java.util.List;

public interface UserPosteService {

    public List<UserPoste> getAllUserPoste();
    public UserPoste getUserPosteById(long objId);
    public List<Poste> getPostesByUser(long userId);
    public List<User> getUsersByPoste(long posteId);
    public UserPoste createUserPoste(UserPosteDto userPosteDto);
    public UserPoste updateUserPoste(UserPosteDto userPosteDto, long objId);
    public ResponseEntity<UserPoste> deleteUserPoste(long objId);
}
