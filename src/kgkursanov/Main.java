package kgkursanov;

import kgkursanov.generator.GeneredId;
import kgkursanov.models.Group;
import kgkursanov.models.Lesson;
import kgkursanov.models.Student;
import kgkursanov.service.GroupService;
import kgkursanov.service.LessonService;
import kgkursanov.service.StudentService;
import kgkursanov.service.impl.GroupServiceImpl;
import kgkursanov.service.impl.LessonServiceImpl;
import kgkursanov.service.impl.StudentServiceImpl;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String globalEmail = "admin@gmail.com";
        String globalPassword = "admin";
        String masterPassword = "zarip";

        StudentService  studentService = new StudentServiceImpl();
        GroupService groupService = new GroupServiceImpl();
        LessonService lessonService = new LessonServiceImpl();


        Scanner scanner = new Scanner(System.in);

        while (true) {

            LocalTime localTime = LocalTime.now();

            if (localTime.isBefore(LocalTime.of(5, 0))) {
                System.out.println("Доброй ночи!");
            } else if (localTime.isBefore(LocalTime.of(10, 0))) {
                System.out.println("Доброе утро!");
            } else if (localTime.isBefore(LocalTime.of(18, 0))) {
                System.out.println("Добрый день!");
            } else {
                System.out.println("Добрый вечер!");
            }

            System.out.println("Катталган болсонуз 1ди басыныз, парольду сброс кылуу учун 2ни басыныз.");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Катталган email адресинизди жазыныз:");
                    String email = scanner.nextLine();
                    System.out.println("Паролун жазыныз:");
                    String password = scanner.nextLine();

                    if (email.equalsIgnoreCase(globalEmail) && password.equalsIgnoreCase(globalPassword)) {
                        handleAdminOperations(scanner, studentService, groupService, lessonService);
                    } else {
                        System.out.println("Неправильный email или пароль для администратора.");
                    }
                    break;

                case 2:
                    System.out.println("Мастер парольду жазыныз:");
                    String masterPass = scanner.nextLine();
                    if (masterPass.equalsIgnoreCase(masterPassword)) {
                        System.out.println("Жаңы парольду жазыныз:");
                        globalPassword = scanner.nextLine();
                        System.out.println("Пароль ийгиликтүү өзгөрдү.");
                    } else {
                        System.out.println("Мастер пароль жалбарыз.");
                    }
                    break;

                default:
                    System.out.println("Туура тандоо жасалган эмес. 1 же 2 танданыз.");
            }
        }
    }

    private static void handleAdminOperations(Scanner scanner, StudentService studentService,
                                              GroupService groupService, LessonService lessonService) {
        while (true) {
            System.out.println("""
                    1. Группа кошуу
                    2. Группаны аты менен алуу
                    3. Группанын атын озгортуу
                    4. Баардык группаны алуу
                    5. Гуппаны аты аркылуу очуруу
                    6. Группага студент кошуу.
                    7. Студенттин маалыматын озгортуу
                    8. Студентти аты аркылуу табуу
                    9. Группадагы баардык студенттерди алуу
                    10. Баардык студенттердин сабактарын алуу
                    11. Студентти очуруу
                    12. Группага сабак кошуу
                    13. Сабакты аты менен алуу 
                    14. Группадагы баардык сабактарды алуу
                    15. Сабакты аты менен очуруу
                    0. Чыгуу
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();
            Student student = new Student();
            switch (choice) {
                case 1 -> {
                    Group group = new Group();
                    group.setId(GeneredId.idGeneratorGroup());
                    System.out.println("Группанын атын жазыныз: ");
                    group.setGroupName(new Scanner(System.in).nextLine());
                    System.out.println("Группанын суроттомосун жазыныз: ");
                    group.setDescription(new Scanner(System.in).nextLine());


                    groupService.addGroup(group);


                }
                case 2 -> {
                    System.out.println("Группанын атын жазыныз: ");
                    groupService.getGroupByName(new Scanner(System.in).nextLine());
                    break;

                }
                case 3 -> {
                    System.out.println("Группанын атын жазыныз: ");
                    String searchName = new Scanner(System.in).nextLine();
                    System.out.println("Группага жаны ат жазыныз: ");
                    String newName = new Scanner(System.in).nextLine();
                    groupService.updateGroupName(searchName, newName);
                    break;
                }
                case 4 -> {
                    groupService.getAllGroups();
                    break;
                }
                case 5 -> {
                    System.out.println("Группанын атын жазыныз: ");
                    String at = new Scanner(System.in).nextLine();
                    groupService.deleteGroup(at);
                    break;
                }
                case 6 -> {
                    System.out.println("Группанын атын жазыныз: ");
                    String groupName = new Scanner(System.in).nextLine();
                    Student student1 = new Student();
                    student1.setId(GeneredId.idGeneratorStudent());
                    System.out.println("Студенттин атын жазыныз: ");
                    String nameStudent = new Scanner(System.in).nextLine();
                    student1.setFirstName(nameStudent);
                    System.out.println("Студенттин фамилиясы: ");
                    student1.setLastName(new Scanner(System.in).nextLine());
                    System.out.println("Студенттин email(@ камтысын!): ");
                    String email = new Scanner(System.in).nextLine();
                    if (!email.contains("@")) {
                        System.out.println("@ камтысын!");
                    } else if (email.contains("@")) {
                        student1.setEmail(email);
                    }
                    System.out.println("Студенттин паролун(не менее 8 симолов!): ");
                    String password = new Scanner(System.in).nextLine();
                    if (password.length() >= 8) {
                        student1.setPassword(password);
                    } else System.out.println("Не менее 8 симолов!");
                    System.out.println(studentService.addNewStudentToGroup(groupName, student1));
                }
                case 7 -> {
                    System.out.println("Студенеттин email жазыныз: ");
                    String email = new Scanner(System.in).nextLine();
                    System.out.println("Студенттин паролун(не менее 8 симолов!): ");
                    String passwordNew1 = new Scanner(System.in).nextLine();
                    System.out.println("Студенттин жаны атын жазыныз: ");
                    String nameStudent = new Scanner(System.in).nextLine();
                    student.setFirstName(nameStudent);
                    System.out.println("Студенттин жаны фамилиясы: ");
                    student.setLastName(new Scanner(System.in).nextLine());
                    System.out.println("Студенттин жаны email(@ камтысын!): ");
                    String emailNew = new Scanner(System.in).nextLine();
                    if (!emailNew.contains("@")) {
                        System.out.println("@ камтысын!");
                    } else if (emailNew.contains("@")) {
                        student.setEmail(emailNew);
                    }
                    System.out.println("Студенттин жаны паролун(не менее 8 симолов!): ");
                    String passwordNew = new Scanner(System.in).nextLine();

                    if (passwordNew.length() >= 8) {
                        student.setPassword(passwordNew);
                    } else System.out.println("Не менее 8 симолов!");
                    studentService.updateStudent(email, passwordNew1, student);
                }
                case 8 -> {
                    System.out.println("Студенттин атын жазыныз!");
                    String at = new Scanner(System.in).nextLine();
                    studentService.findStudentByName(at);
                }
                case 9 -> {
                    System.out.println("Гpуппанын атын жазыныз:");
                    String nameGroup = new Scanner(System.in).nextLine();
                    studentService.getAllStudentsByGroupName(nameGroup);
                }
                case 10 -> {
                    studentService.getAllStudentsLesson();
                }
                case 11 -> {
                    System.out.println("Студенеттин email жазыныз: ");
                    String email = new Scanner(System.in).nextLine();
                    System.out.println("Студенттин паролун(не менее 8 симолов!): ");
                    String password = new Scanner(System.in).nextLine();
                    studentService.deleteStudent(email, password);
                }
                case 12 -> {
                    Lesson lesson = new Lesson();
                    System.out.println("Группанын атын жазыныз: ");
                    String nameGroup = new Scanner(System.in).nextLine();
                    lesson.setId(GeneredId.idGeneratorLesson());
                    System.out.println("Сабактын атын жазыныз: ");
                    String taskName = new Scanner(System.in).nextLine();
                    lesson.setNameTask(taskName);
                    System.out.println("Cабактын суроттомосун жазыныз: ");
                    String description = new Scanner(System.in).nextLine();
                    lesson.setDescriptionTask(description);
                    lessonService.addNewLessonToGroup(nameGroup, lesson);
                }
                case 13 -> {
                    System.out.println("Сабактын атын жазыныз: ");
                    lessonService.getLessonByName(new Scanner(System.in).nextLine());
                }
                case 14 -> {
                    System.out.println("Группанын атын жазыныз: ");
                    lessonService.getAllLessonByGroupName(new Scanner(System.in).nextLine());
                }
                case 15 -> {
                    System.out.println("Сабактын атын жазыныз: ");
                    lessonService.deleteLesson(new Scanner(System.in).nextLine());
                }

                case 0 ->{
                    return;

                }
                default -> {
                    System.out.println("Туура тандоо жасалган эмес. Кайталаныз.");
                }
            }
        }
    }
}
