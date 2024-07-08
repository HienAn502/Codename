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
@Builder
@Entity(name = "c_user")
@SQLDelete(sql = "UPDATE c_user SET is_deleted = true WHERE id=?")
@FilterDef(name="deletedUserFilter", parameters = @ParamDef(name = "is_deleted", type = Boolean.class))
@Filter(name = "deletedUserFilter", condition = "is_deleted = :isDeleted")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    @Column(nullable=false)
    private String email;

    private String password;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    private boolean isDeleted = Boolean.FALSE;
}