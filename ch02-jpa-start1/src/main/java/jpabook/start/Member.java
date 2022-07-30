package jpabook.start;

//**
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

/**
 * User: HolyEyE
 * Date: 13. 5. 24. Time: 오후 7:43
 */
@Getter
@Setter
@Entity
@Table(name="MEMBER")
public class Member {

    @Id
//    @SequenceGenerator(name="BOARD_SEQ_GENERATOR", sequenceName = "BOARD_SEQ", initialValue = 1,allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME",nullable = false, length = 10)
    private String username;

    private Integer age;
}
