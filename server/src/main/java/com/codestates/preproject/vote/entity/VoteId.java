//package com.codestates.preproject.vote.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//
//@Data
//@Embeddable
//@NoArgsConstructor
//@AllArgsConstructor
//public class VoteId implements Serializable {
//
//    @Column
//    private Long member_id;
//
//    @Column
//    private Long answer_id;
//}
package com.codestates.preproject.vote.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

//@Data
//@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class VoteId implements Serializable {

    //@Column
    @Id
    @EqualsAndHashCode.Include
    private Long member_id;

    //@Column
    @Id
    @EqualsAndHashCode.Include
    private Long answer_id;
}
