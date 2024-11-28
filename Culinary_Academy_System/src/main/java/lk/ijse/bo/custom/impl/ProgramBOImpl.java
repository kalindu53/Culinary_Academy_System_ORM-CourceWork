package lk.ijse.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dto.ProgramDto;
import lk.ijse.entity.Program;
import lk.ijse.entity.tm.ProgramTm;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.PROGRAM);


    @Override
    public List<ProgramDto> getAll() {
        List<ProgramDto> programDtos = new ArrayList<>();
        List<Program> all = programDAO.getAll();
        for (Program program : all){
            programDtos.add(new ProgramDto(program.getCourseId(),program.getCourseName(),program.getDuration(),program.getCourseFee()));
        }
        return programDtos;
    }

    @Override
    public boolean save(ProgramDto programDto) {
        return programDAO.save(new Program(programDto.getCourseId(),programDto.getCourseName(),programDto.getDuration(),programDto.getCourseFee()));
    }

    @Override
    public boolean update(ProgramDto programDto) {
        return  programDAO.update(new Program(programDto.getCourseId(),programDto.getCourseName(),programDto.getDuration(),programDto.getCourseFee()));
    }

    @Override
    public boolean delete(ProgramDto programDto) {
     return programDAO.delete(new Program(programDto.getCourseId(),programDto.getCourseName(),programDto.getDuration(), programDto.getCourseFee()));
    }

    @Override
    public String getCurrentId() {
        return programDAO.getCurrentId();
    }


}