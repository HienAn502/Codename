package personal.codename.domain.models.practice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "p_department")
@SQLDelete(sql = "UPDATE p_department SET is_deleted = true WHERE id=?")
@FilterDef(name="deletedDepartmentFilter", parameters = @ParamDef(name = "is_deleted", type = Boolean.class))
@Filter(name = "deletedDepartmentFilter", condition = "is_deleted = :isDeleted")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
