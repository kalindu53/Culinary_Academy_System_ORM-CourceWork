package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;

import java.util.List;

public interface RegistrDAo extends CrudDAO {


    List<Program> getProgramid();

    String getCurrentId();

    List<Student> getStudentID();
}
