package br.edu.ifpb.projeto.utils;

import java.util.List;
import java.util.UUID;

public interface GenericCRUDService<T> {
    public T findById(UUID id);
    public List<T> findAll();
    public T save(T entity);
    public T update(T entity);
    public void delete(T entity);
    public void delete(UUID id);

}
