package tn.gov.douane.formations.app.user.dao.interfaces;

import tn.gov.douane.formations.api.dto.TypeUserDto;
import tn.gov.douane.formations.api.model.TypeUser;
import java.util.List;

public interface ITypeUserDao {

    public TypeUser createTypeUser(TypeUserDto dto);
    public TypeUser updateTypeUser(TypeUserDto dto);
    public TypeUser getTypeUserById(long id);
    public TypeUser getTypeUserByLibelle(String libelle);
    public List<TypeUser> getAllTypeUser();
}
