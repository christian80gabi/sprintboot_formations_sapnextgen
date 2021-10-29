package tn.gov.douane.formations.app.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import tn.gov.douane.formations.api.dto.TypeUserDto;
import tn.gov.douane.formations.api.model.TypeUser;
import tn.gov.douane.formations.app.URL_INFO;
import tn.gov.douane.formations.app.user.dao.interfaces.ITypeUserDao;

import java.util.Arrays;
import java.util.List;

public class TypeUserDaoImpl implements ITypeUserDao {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private static final String ALL_TYPE_USER_API = URL_INFO.url+"typeuser";
    private static final String TYPE_USER_BY_ID_API = URL_INFO.url+"typeuser"+"/"+"{id}";
    private static final String TYPE_USER_BY_LIBELLE_API = URL_INFO.url+"typeuser/"+"libelle/"+"{libelle}";
    private static final String CREATE_TYPE_USER_API = URL_INFO.url+"typeuser";
    private static final String UPDATE_TYPE_USER_API = URL_INFO.url+"typeuser"+"/"+"{id}";

    public TypeUserDaoImpl() {
    }

    @Override
    public TypeUser createTypeUser(TypeUserDto dto) {
        TypeUser typeUser = restTemplate.postForObject(CREATE_TYPE_USER_API, dto, TypeUser.class);

        return typeUser;
    }

    @Override
    public TypeUser updateTypeUser(TypeUserDto dto) {
        restTemplate.put(UPDATE_TYPE_USER_API, dto, dto.getId());
        TypeUser typeUser = restTemplate.getForObject(TYPE_USER_BY_ID_API, TypeUser.class, dto.getId());

        return typeUser;
    }

    @Override
    public TypeUser getTypeUserById(long id) {
        TypeUser typeUser = restTemplate.getForObject(TYPE_USER_BY_ID_API, TypeUser.class, id);

        return typeUser;
    }

    @Override
    public TypeUser getTypeUserByLibelle(String libelle) {
        TypeUser typeUser = restTemplate.getForObject(TYPE_USER_BY_LIBELLE_API, TypeUser.class, libelle);

        return typeUser;
    }

    @Override
    public List<TypeUser> getAllTypeUser() {
        TypeUser[] list = restTemplate.getForObject(ALL_TYPE_USER_API, TypeUser[].class);
        List<TypeUser> typeUsers = Arrays.asList(list);

        return typeUsers;
    }
}
