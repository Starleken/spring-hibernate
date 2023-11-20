package by.Starleken.repositories;

import by.Starleken.entities.Comment;
import by.Starleken.repositories.interfaces.CommentRepository;
import by.Starleken.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealizationCommentRepository implements CommentRepository {

    private EntityManagerUtils entityManagerUtils;

    @Autowired
    public RealizationCommentRepository(EntityManagerUtils entityManagerUtils) {
        this.entityManagerUtils = entityManagerUtils;
    }

    @Override
    public List<Comment> findAll() {
        EntityManager em = entityManagerUtils.getEntityManager();

        List<Comment> comments = em.createNativeQuery("SELECT * FROM comments", Comment.class).getResultList();

        em.close();
        return comments;
    }

    @Override
    public Comment findById(Long id) {
        EntityManager em = entityManagerUtils.getEntityManager();

        Comment comment = em.find(Comment.class, id);

        em.close();
        return comment;
    }

    @Override
    public Comment create(Comment entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();
        em.close();

        return entity;
    }

    @Override
    public void update(Comment entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        Comment comment = em.find(Comment.class, entity.getId());
        comment.setMessage(entity.getMessage());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        Comment comment = em.find(Comment.class, id);
        em.remove(comment);

        em.close();
    }

    @Override
    public void increaseRating(Long commentId) {
        addCommentRating(commentId, 1);
    }

    @Override
    public void decreaseRating(Long commentId) {
        addCommentRating(commentId, -1);
    }

    private void addCommentRating(Long id, int value){
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        Comment comment = em.find(Comment.class, id);
        comment.setRating(comment.getRating() + value);

        em.getTransaction().commit();
        em.close();
    }
}
