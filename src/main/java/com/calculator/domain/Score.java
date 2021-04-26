package com.calculator.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 23:19
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Score extends Auditable<UUID>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String studentId;
    private final String score;
}
