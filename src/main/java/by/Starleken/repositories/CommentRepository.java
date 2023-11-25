package by.Starleken.repositories;

import by.Starleken.entities.Comment;
import by.Starleken.interfaces.CRUD;

public interface CommentRepository extends CRUD<Comment, Long> {

    public void increaseRating(Long commentId);

    public void decreaseRating(Long commentId);
}
