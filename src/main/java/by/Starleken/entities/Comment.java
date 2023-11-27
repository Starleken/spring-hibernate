package by.Starleken.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Comment() {
    }

    public Comment(Long id, String message, Integer rating, Date createdDate, User user, Project project) {
        this.id = id;
        this.message = message;
        this.rating = rating;
        this.createdDate = createdDate;
        this.user = user;
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(message, comment.message) && Objects.equals(rating, comment.rating) && Objects.equals(createdDate, comment.createdDate) && Objects.equals(user, comment.user) && Objects.equals(project, comment.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, rating, createdDate, user, project);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", rating=" + rating +
                ", createdDate=" + createdDate +
                ", user=" + user +
                ", project=" + project +
                '}';
    }
}
