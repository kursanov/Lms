package kgkursanov.service;


import kgkursanov.models.Lesson;
import kgkursanov.models.Student;

import java.util.List;

public interface StudentService {

    String addNewStudentToGroup(String nameGroup, Student student);
    Student updateStudent (String email,String password, Student student);

    Student findStudentByName(String searchName);

    List<Student> getAllStudentsByGroupName(String groupName);

    List<Lesson> getAllStudentsLesson();

    String deleteStudent(String email,String password);









}
