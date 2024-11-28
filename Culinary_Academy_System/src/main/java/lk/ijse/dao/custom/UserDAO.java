package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO{

    String getCurrentId();


    String getUserRole(String userName);

    boolean checkCredentials(String username, String password);


    List<User> getSelectAll(String useName);
}
