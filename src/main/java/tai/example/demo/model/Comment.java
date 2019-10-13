package tai.example.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Comment entity
 *
 * @author TuMV
 */
@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "article_id")
    private int articleId;

    @Column(name = "content")
    private String content;
}
