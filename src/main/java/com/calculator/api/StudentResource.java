package com.calculator.api;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 17:49
 */
import com.calculator.domain.Student;
import lombok.Data;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;


import java.util.Date;
import java.util.UUID;

//拓展了这个接口，继承了一个Link对象的列表喝管理链接列表的功能
public class StudentResource extends RepresentationModel<StudentResource>{
    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final UUID createdBy;
    public StudentResource(Student student){
        this.name = student.getName();
        this.createdAt = student.getCreatedAt();
        this.createdBy = student.getCreatedBy();
    }

}
