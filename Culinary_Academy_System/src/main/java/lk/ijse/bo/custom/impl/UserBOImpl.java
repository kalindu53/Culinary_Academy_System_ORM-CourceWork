package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
   UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.USER);

    @Override
    public boolean save(UserDto userDto) {
      //  System.out.println(userDto.toString());
        return userDAO.save(new User(userDto.getUser_id(), userDto.getUserName(), userDto.getUserPassword(), userDto.getUserRole(), userDto.getUserPhoneNumber(), userDto.getUserEmailAddress()));
    }

    @Override
    public String getCurrentId() {

        return userDAO.getCurrentId();
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> all = userDAO.getAll();
        for (User user : all){
            userDtos.add(new UserDto(user.getUser_id(),user.getUserName(),user.getUserPassword(),user.getUserRole(),user.getUserPhoneNumber(),user.getUserEmailAddress()));
        }
        return userDtos;
    }

    @Override
    public boolean delete(UserDto userDto) {
        return userDAO.delete(new User(userDto.getUser_id(), userDto.getUserName(), userDto.getUserPassword(),  userDto.getUserRole(),userDto.getUserPhoneNumber(), userDto.getUserEmailAddress()));
    }

    @Override
    public boolean update(UserDto userDto) {
        return userDAO.update( new User(userDto.getUser_id(), userDto.getUserName(), userDto.getUserPassword(), userDto.getUserPhoneNumber(), userDto.getUserRole(), userDto.getUserEmailAddress()));
    }

    @Override
    public List<String> getIds() {
        return userDAO.getAll();
    }

    @Override
    public String getUserRole(String username) {
        return userDAO.getUserRole(username);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return userDAO.checkCredentials(username,  password);
    }

    @Override
    public List<User> getAll_detail(String useName) {
        return userDAO.getSelectAll(useName);

    }


}
