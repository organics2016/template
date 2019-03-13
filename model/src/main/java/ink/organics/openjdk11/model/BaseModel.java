package ink.organics.openjdk11.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Serializable {


    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createdDate;

    /**
     * 修改时间
     */
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
