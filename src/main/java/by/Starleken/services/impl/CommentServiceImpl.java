package by.Starleken.services.impl;

import by.Starleken.entities.Comment;
import by.Starleken.repositories.CommentRepository;
import by.Starleken.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment create(Comment entity) {
        return commentRepository.create(entity);
    }

    @Override
    public void update(Comment entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
