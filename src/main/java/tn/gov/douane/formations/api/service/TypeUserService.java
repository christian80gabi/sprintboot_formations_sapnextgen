package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.TypeUserDto;
import tn.gov.douane.formations.api.model.TypeUser;
import java.util.List;

public interface TypeUserService {
    public List<TypeUser> getAllTypeUser();
    public TypeUser getTypeUserById(long objId);
    public TypeUser getTypeUserByLibelle(String libelle);
    public TypeUser createTypeUser(TypeUserDto typeUserDto);
    public TypeUser updateTypeUser(TypeUserDto typeUserDto, long objId);
    public ResponseEntity<TypeUser> deleteTypeUser(long objId);
}