package personal.codename.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import personal.codename.domain.enums.GameStatus;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "c_game_session")
@SQLDelete(sql = "UPDATE c_game_session SET is_deleted = true WHERE id=?")
@FilterDef(name="deletedSessionFilter", parameters = @ParamDef(name = "is_deleted", type = Boolean.class))
@Filter(name = "deletedSessionFilter", condition = "is_deleted = :isDeleted")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR(50)", unique = true)
    private String gameCode;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    private int numberOfPlayers;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Player creator;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    private boolean isDeleted = Boolean.FALSE;
}