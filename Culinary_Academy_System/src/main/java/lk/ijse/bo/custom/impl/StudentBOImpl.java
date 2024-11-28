package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.StudentDto;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.STUDENT);


    @Override
    public List<User> getUserIds() {
        return studentDAO.getid();




    }

    @Override
    public boolean save(StudentDto studentDto) {
        return studentDAO.save(new Student(studentDto.getStudentId(), studentDto.getStudentFirstName(),studentDto.getStudentLastName(),studentDto.getStudentPhone(),studentDto.getStudentEmail(),studentDto.getUserID()));
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> all = studentDAO.getAll();
        for (Student student : all){
            studentDtos.add(new StudentDto(student.getStudentId(),student.getStudentFirstName(),student.getStudentLastName(),student.getStudentPhone(),student.getStudentEmail(),student.getUser()));
        }
        return studentDtos;
    }

    @Override
    public boolean update(StudentDto studentDto) {
        return studentDAO.update(new Student(studentDto.getStudentId(), studentDto.getStudentFirstName(),studentDto.getStudentLastName(),studentDto.getStudentPhone(),studentDto.getStudentEmail(),studentDto.getUserID()));
    }

    @Override
    public boolean delete(StudentDto studentDto) {
        return studentDAO.delete(new Student(studentDto.getStudentId(), studentDto.getStudentFirstName(),studentDto.getStudentLastName(),studentDto.getStudentPhone(),studentDto.getStudentEmail(),studentDto.getUserID()));
    }

    @Override
    public String getCurrentId() {
        return studentDAO.getCurrentID();
    }

    @Override
    public List<StudentDto> getAllCouseStudent() {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<StudentDto> all = studentDAO.getAllRegistrStudent();
        for (StudentDto student : all){
            studentDtos.add(new StudentDto(student.getStudentId(),student.getStudentFirstName()));
        }
        return studentDtos;
    }
}