package ink.organics.openjdk11.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "demo")
public class Demo extends BaseModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36)
    private String demoId;

    @Version
    private Long version;

    private String name;


}
