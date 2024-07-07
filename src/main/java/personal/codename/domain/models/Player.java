package personal.codename.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import personal.codename.domain.enums.PlayerRole;
import personal.codename.domain.enums.Team;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "c_player")
@SQLDelete(sql = "UPDATE c_player SET is_deleted = true WHERE id=?")
@FilterDef(name="deletedPlayerFilter", parameters = @ParamDef(name = "is_deleted", type = Boolean.class))
@Filter(name = "deletedPlayerFilter", condition = "is_deleted = :isDeleted")
public class Player {
    @Id
    @GeneratedValue(strategy
            = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private GameSession session;

    @Enumerated(EnumType.STRING)
    private PlayerRole role;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    private boolean isDeleted = Boolean.FALSE;
}