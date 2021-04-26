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
public class StudentScoreDetail extends Auditable<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @NotBlank(message = "请选择孩子的入学年份")
    private String startYear;

    @NotBlank(message = "请选择您的身份类型")
    private String identityType;

    @NotBlank(message = "请选择您的产证登记时间")
    private String registrationTime;

    @NotBlank(message = "请选择孩子的落户时间")
    private String registrationTimeForChild;

    @NotBlank(message = "请填写父母是否共有产权100%")
    private String commonProperty;

    //父母是否一年以上并且户籍在青
    @NotBlank(message = "该项不得为空")
    private String localAndOneYear;

    //父母是否为第二批外来人员
    @NotBlank(message = "您是否为第二批外来务工人员")
    private String secondWave;

    //缴纳社保时间
    private String monthsPaySecurity;

    //在同一区域满一年
    private String isAYear;

    //居住证领取时间
    @NotBlank(message = "请填写居住证领取时间")
    private String mothsHoldPaper;

    private String educationalBackground;


}
