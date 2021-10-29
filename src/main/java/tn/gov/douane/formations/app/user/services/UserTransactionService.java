package tn.gov.douane.formations.app.user.services;

import tn.gov.douane.formations.app.user.dao.interfaces.ITypeUserDao;
import tn.gov.douane.formations.app.user.dao.interfaces.IUserDao;
import tn.gov.douane.formations.app.user.dao.TypeUserDaoImpl;
import tn.gov.douane.formations.app.user.dao.UserDaoImpl;

public class UserTransactionService {

    private IUserDao userDao = new UserDaoImpl();
    private ITypeUserDao typeUserDao = new TypeUserDaoImpl();

    public UserTransactionService() {
    }

    public UserTransactionService(IUserDao userDao, ITypeUserDao typeUserDao) {
        this.userDao = userDao;
        this.typeUserDao = typeUserDao;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public ITypeUserDao getTypeUserDao() {
        return typeUserDao;
    }

    public void setTypeUserDao(ITypeUserDao typeUserDao) {
        this.typeUserDao = typeUserDao;
    }
}
