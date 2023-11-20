package by.Starleken.interfaces;

import java.util.List;

public interface CRUD<T, Key> {

    public List<T> findAll();

    public T findById(Key id);

    public T create(T entity);

    public void update(T entity);

    public void delete(Key id);
}
