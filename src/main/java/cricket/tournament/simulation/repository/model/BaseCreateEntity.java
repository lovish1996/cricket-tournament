package cricket.tournament.simulation.repository.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@MappedSuperclass
public class BaseCreateEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "created_at")
    protected Long createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            this.createdAt = System.currentTimeMillis();
        }
    }
}
