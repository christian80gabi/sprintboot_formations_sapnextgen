package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.TypeUserDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.TypeUser;
import tn.gov.douane.formations.api.repository.TypeUserRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TypeUserServiceImpl implements TypeUserService {

    @Autowired
    private TypeUserRepository repo;

    public TypeUserServiceImpl() {
        super();
    }

    public TypeUserServiceImpl(TypeUserRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<TypeUser> getAllTypeUser() {
        return this.repo.findAll();
    }

    @Override
    public TypeUser getTypeUserById(long objId) {
        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Type user not found with id :"+objId)
                );
    }

    @Override
    public TypeUser getTypeUserByLibelle(String libelle) {

        List<TypeUser> typeUsers = repo.findAll();
        TypeUser resultat = null;

        for (TypeUser obj : typeUsers) {
            if (libelle.equalsIgnoreCase(obj.getTypeUserLibelle())){
                resultat = new TypeUser(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public TypeUser createTypeUser(TypeUserDto typeUserDto) {


        Timestamp time = GDate.precisionDateTime;
        TypeUser typeUser = new TypeUser();

        typeUser.setTypeUserLibelle(typeUserDto.getTypeUserLibelle());
        typeUser.setTypeUserDescription(typeUserDto.getTypeUserDescription());
        typeUser.setTypeUserCreateAt(time);
        typeUser.setTypeUserUpdateAt(time);
        typeUser.setTypeUserDeleteAt(time);
        typeUser.setStatut(GStatutObj.ADD);

        return this.repo.save(typeUser);
    }

    @Override
    public TypeUser updateTypeUser(TypeUserDto typeUserDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        TypeUser existingTypeUser = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Type user not found with id :"+objId));

        existingTypeUser.setTypeUserLibelle(typeUserDto.getTypeUserLibelle());
        existingTypeUser.setTypeUserDescription(typeUserDto.getTypeUserDescription());
        existingTypeUser.setTypeUserUpdateAt(time);
        existingTypeUser.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingTypeUser);
    }

    @Override
    public ResponseEntity<TypeUser> deleteTypeUser(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        TypeUser existingTypeUser = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Type user not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingTypeUser);
        return ResponseEntity.ok().build();
    }
}
