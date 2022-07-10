package com.cd.moyu.paper.manager.vo;

import com.cd.moyu.paper.manager.po.Major;
import com.cd.moyu.paper.manager.po.Student;
import com.cd.moyu.paper.manager.po.Teacher;
import com.cd.moyu.paper.manager.po.Topic;
import lombok.Data;

@Data
public class StudentVo {
    private Integer id;
    private String name;
    private String studentNumber;
    private String majorName;
    private String phoneNumber;
    private String teacherNumber;
    private String teacherName;
    private String topicTitle;
    private Integer topicId;

    public StudentVo(Student student, Major major) {
        this.id = student.getId();
        this.name = student.getName();
        this.studentNumber = student.getStudentNumber();
        this.majorName = major.getMajorName();
        this.phoneNumber = student.getPhoneNumber();
    }

    public StudentVo(Student student, Major major, Topic topic, Teacher teacher) {
        this(student, major);
        this.teacherName = teacher.getName();
        this.topicTitle = topic.getTitle();
        this.teacherNumber = teacher.getTeacherNumber();
        this.topicId = topic.getId();
    }
}
