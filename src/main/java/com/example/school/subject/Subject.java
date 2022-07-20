package com.example.school.subject;

import com.example.school.student.Student;
import com.example.school.teacher.Teacher;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(cascade = CascadeType.ALL) //Many Subjects to one teacher
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    @ManyToMany
    @JoinTable(
            name="student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents  = new HashSet<>();//this maps @ManyToMany(mappedBy = "enrolledStudents") in Student model Class
    private String name;

    public Subject() {
    }

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void assignSubjectToTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
