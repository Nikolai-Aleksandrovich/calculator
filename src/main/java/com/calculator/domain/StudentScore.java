package com.calculator.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 2:41
 */
@Data
@Entity
@Table(name = "Student_Score")
public class StudentScore extends Auditable<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @NotBlank(message = "入学年份不得为空")
    private String


}
