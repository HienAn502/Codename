package personal.codename.domain.models.practice;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "p_address")
@SQLDelete(sql = "UPDATE p_address SET is_deleted = true WHERE id=?")
@FilterDef(name="deletedAddressFilter", parameters = @ParamDef(name = "is_deleted", type = Boolean.class))
@Filter(name = "deletedAddressFilter", condition = "is_deleted = :isDeleted")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Employee employee;
}
