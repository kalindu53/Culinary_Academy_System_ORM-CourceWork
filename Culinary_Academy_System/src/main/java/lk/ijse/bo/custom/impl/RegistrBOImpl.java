package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RegistrBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dao.custom.RegistrDAo;
import lk.ijse.dto.RegistrDto;
import lk.ijse.entity.Program;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class RegistrBOImpl implements RegistrBO {
    RegistrDAo registrDAo = (RegistrDAo) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.REGISTR);


    @Override
    public List<Program> getProgramIds() {
        return registrDAo.getProgramid();
    }

    @Override
    public List<RegistrDto> getAll() {
        List<Registration> all = registrDAo.getAll();
        List<RegistrDto> registrDtos = new ArrayList<>();
        for (Registration registration : all){
            registrDtos.add(new RegistrDto(registration.getRegistrationId(),registration.getStudent(),registration.getCourses(),registration.getAdvanced(),registration.getDate()));
        }
        return registrDtos;
    }

    @Override
    public boolean save(RegistrDto registrDto) {
        return registrDAo.save(new Registration(registrDto.getRegistrationId(),registrDto.getStudent(),registrDto.getCourses(),registrDto.getAdvanced(),registrDto.getDate()));
    }

    @Override
    public boolean update(RegistrDto registrDto) {
        return registrDAo.update(new Registration(registrDto.getRegistrationId(),registrDto.getStudent(),registrDto.getCourses(),registrDto.getAdvanced(),registrDto.getDate()));
    }

    @Override
    public String getCurrentId() {
       return  registrDAo.getCurrentId();
    }

    @Override
    public List<Student> getStudentIds() {
        return registrDAo.getStudentID();
    }

    @Override
    public boolean delete(RegistrDto registrDto) {
        return registrDAo.delete(new Registration(registrDto.getRegistrationId(),registrDto.getStudent(),registrDto.getCourses(),registrDto.getAdvanced(),registrDto.getDate()));

    }


}

