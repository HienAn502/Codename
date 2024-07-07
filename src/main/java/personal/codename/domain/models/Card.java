package personal.codename.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import personal.codename.domain.enums.CardType;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "c_card")
@SQLDelete(sql = "UPDATE c_card SET is_deleted = true WHERE id=?")
@FilterDef(name="deletedCardFilter", parameters = @ParamDef(name = "is_deleted", type = Boolean.class))
@Filter(name = "deletedCardFilter", condition = "is_deleted = :isDeleted")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String word;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private GameSession session;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    private boolean isDeleted = Boolean.FALSE;
}