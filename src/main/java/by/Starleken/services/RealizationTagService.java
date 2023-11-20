package by.Starleken.services;

import by.Starleken.entities.Tag;
import by.Starleken.repositories.interfaces.TagRepository;
import by.Starleken.services.interfaces.TagService;
import by.Starleken.utils.EntityManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealizationTagService implements TagService {

    private TagRepository tagRepository;

    @Autowired
    public RealizationTagService(TagRepository tagRepository, EntityManagerUtils entityManagerUtils) {
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
