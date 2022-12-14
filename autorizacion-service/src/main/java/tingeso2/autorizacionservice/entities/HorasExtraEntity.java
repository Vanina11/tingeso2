package tingeso2.autorizacionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "horas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorasExtraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Integer horas;
    private String mes;
    private String rutEmpleado;
}
