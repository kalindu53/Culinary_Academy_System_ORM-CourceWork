package lk.ijse.dao;

import lk.ijse.entity.User;

import java.util.List;

public interface CrudDAO <T> extends SuperDAO {


    boolean save(T object);

    List<T> getAll();

    boolean delete(T object);

    boolean update(T object);
}
