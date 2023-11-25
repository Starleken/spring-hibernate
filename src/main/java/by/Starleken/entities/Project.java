package by.Starleken.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "github_URL")
    private String URL;

    @Column(name = "image_URL")
    private String imageURL;


    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            joinColumns = { @JoinColumn(name = "project_id")},
            inverseJoinColumns = { @JoinColumn(name = "tag_id")}
    )
    private List<Tag> tags;

    public Project() {
    }

    public Project(Long id, String name, String description, String URL, String imageURL, List<Comment> comments, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.URL = URL;
        this.imageURL = imageURL;
        this.comments = comments;
        this.tags = tags;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(description, project.description) && Objects.equals(URL, project.URL) && Objects.equals(imageURL, project.imageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, URL, imageURL);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", URL='" + URL + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
