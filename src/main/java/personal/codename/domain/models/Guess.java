package personal.codename.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import personal.codename.domain.enums.GuessResult;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "c_guess")
@SQLDelete(sql = "UPDATE c_guess SET is_deleted = true WHERE id=?")
@FilterDef(name="deletedGuessFilter", parameters = @ParamDef(name = "is_deleted", type = Boolean.class))
@Filter(name = "deletedGuessFilter", condition = "is_deleted = :isDeleted")
public class Guess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private GuessResult guessResult;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private GameSession session;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player guesser;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    private boolean isDeleted = Boolean.FALSE;
}