package by.Starleken.repositories;

import by.Starleken.entities.Tag;
import by.Starleken.interfaces.CRUD;

import java.util.List;

public interface TagRepository extends CRUD<Tag, Long> {

    public void save(List<Tag> tags);
}
