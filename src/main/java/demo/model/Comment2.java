package demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "Comment")
@Data
@EqualsAndHashCode(of = {}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment2 extends BaseUUIDEntity {


    @Column()
    String content;

    @Column(nullable = false)
    OffsetDateTime createdAt;

}
