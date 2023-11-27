package by.Starleken.repositories.impl;

import by.Starleken.entities.Comment;
import by.Starleken.repositories.CommentRepository;
import by.Starleken.services.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private EntityManagerProvider entityManagerProvider;

    @Autowired
    public CommentRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public List<Comment> findAll() {
        EntityManager em = entityManagerProvider.getEntityManager();

        List<Comment> comments = em.createNativeQuery("SELECT * FROM comments", Comment.class).getResultList();

        em.close();
        return comments;
    }

    @Override
    public Comment findById(Long id) {
        EntityManager em = entityManagerProvider.getEntityManager();

        Comment comment = em.find(Comment.class, id);

        em.close();
        return comment;
    }

    @Override
    public Comment create(Comment entity) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();
        em.close();

        return entity;
    }

    @Override
    public void update(Comment entity) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        Comment comment = em.find(Comment.class, entity.getId());
        comment.setMessage(entity.getMessage());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        Comment comment = em.find(Comment.class, id);
        em.remove(comment);

        em.close();
    }

    @Override
    public void increaseRating(Long commentId) {
        updateCommentRating(commentId, 1);
    }

    @Override
    public void decreaseRating(Long commentId) {
        updateCommentRating(commentId, -1);
    }

    private void updateCommentRating(Long id, int diff){
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        Comment comment = em.find(Comment.class, id);
        comment.setRating(comment.getRating() + diff);

        em.getTransaction().commit();
        em.close();
    }
}
