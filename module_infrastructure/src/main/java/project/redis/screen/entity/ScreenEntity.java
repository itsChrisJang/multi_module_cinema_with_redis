package project.redis.screen.entity;

import jakarta.persistence.*;
import lombok.*;
import project.redis.common.entity.BaseEntity;

@Entity
@Table(name = "SCREEN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
