package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.StudentDto;
import lk.ijse.entity.User;

import java.util.List;

public interface StudentDAO extends CrudDAO{

    List<User> getid();

    String getCurrentID();

    List<StudentDto> getAllRegistrStudent();
}