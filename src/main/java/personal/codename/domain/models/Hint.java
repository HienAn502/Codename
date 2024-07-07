package personal.codename.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "c_hint")
@SQLDelete(sql = "UPDATE c_hint SET is_deleted = true WHERE id=?")
@FilterDef(name="deletedHintFilter", parameters = @ParamDef(name = "is_deleted", type = Boolean.class))
@Filter(name = "deletedHintFilter", condition = "is_deleted = :isDeleted")
public class Hint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String value;

    private int numberOfGuesses;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private GameSession session;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Player creator;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    private boolean isDeleted = Boolean.FALSE;
}
