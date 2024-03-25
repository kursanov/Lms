package kgkursanov.db;

import kgkursanov.models.Student;
import kgkursanov.models.Group;
import kgkursanov.models.Lesson;

import java.util.LinkedList;
import java.util.List;

public class DataBase {

    public static List<Student> students = new LinkedList<>();
    public static List<Group> groups = new LinkedList<>();
    public static List<Lesson> lessons = new LinkedList<>();
}
