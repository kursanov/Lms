package kgkursanov.service.impl;


import kgkursanov.db.DataBase;
import kgkursanov.models.Group;
import kgkursanov.models.Lesson;
import kgkursanov.models.Student;
import kgkursanov.service.StudentService;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public String addNewStudentToGroup(String nameGroup, Student student) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(nameGroup)) {
                group.addStudent(student);
                return student + " successfully";
            }
        }
        return "not added!";
    }

    @Override
    public Student updateStudent(String email, String password, Student student) {
        for (Group group : DataBase.groups) {
            for (Student groupStudent : group.getStudents()) {
                if(groupStudent.getEmail().equalsIgnoreCase(email) && groupStudent.getPassword().equalsIgnoreCase(password)) {
                    groupStudent.setFirstName(student.getFirstName());
                    groupStudent.setLastName(student.getLastName());
                    groupStudent.setEmail(student.getEmail());
                    groupStudent.setPassword(student.getPassword());
                    System.out.println("Студент обновлен: " + groupStudent);
                    return groupStudent;
                }
            }
        }
        System.out.println("Студент не найден");
        return null;
    }

    @Override
    public Student findStudentByName(String searchName) {
        for (Group group : DataBase.groups) {
            for (Student student : group.getStudents()) {
                if (student.getFirstName().equalsIgnoreCase(searchName)){
                    System.out.println(student);
                    return student;
                }

            }
        }
        System.out.println("This is " + searchName + " student not!");
        return null;
    }

    @Override
    public List<Student> getAllStudentsByGroupName(String groupName) {
        List<Student> students = new LinkedList<>();
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName) && !group.getStudents().isEmpty()){
                students.addAll(group.getStudents());

            }
        }
        System.out.println(students);
        return null;
    }

    @Override
    public List<Lesson> getAllStudentsLesson() {
        List<Lesson> lessons = DataBase.lessons;
        for (Group group : DataBase.groups) {
            for (Lesson lesson : group.getLessons()) {
                lessons.add(lesson);
            }
        }
        System.out.println(lessons);
        return null;
    }

    @Override
    public String deleteStudent(String email, String password) {
        for (Group group : DataBase.groups) {
            Iterator<Student> iterator = group.getStudents().iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getEmail().equalsIgnoreCase(email) && student.getPassword().equalsIgnoreCase(password)) {
                    iterator.remove();
                    return "Student deleted";
                }
            }
        }
        return "Student not found";
    }

}