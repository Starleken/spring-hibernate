package by.Starleken.services.impl;

import by.Starleken.entities.Tag;
import by.Starleken.repositories.TagRepository;
import by.Starleken.services.EntityManagerProvider;
import by.Starleken.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, EntityManagerProvider entityManagerProvider) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag create(Tag entity) {
        return tagRepository.create(entity);
    }

    @Override
    public void update(Tag entity) {
        tagRepository.update(entity);
    }

    @Override
    public void delete(Long id) {
        tagRepository.delete(id);
    }
}
