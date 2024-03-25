package kgkursanov.service.impl;

import kgkursanov.db.DataBase;
import kgkursanov.models.Group;
import kgkursanov.models.Lesson;
import kgkursanov.service.LessonService;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LessonServiceImpl implements LessonService {
    @Override
    public String addNewLessonToGroup(String groupName,Lesson lesson) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                group.addLesson(lesson);
                return groupName + " successfully";
            }
        }
        return "not added!";
    }

    @Override
    public Lesson getLessonByName(String nameLesson) {
        for (Group group : DataBase.groups) {
            for (Lesson lesson : group.getLessons()) {
                if (lesson.getNameTask().equalsIgnoreCase(nameLesson)){
                    System.out.println(lesson);
                }
            }
        }
        return null;

    }

    @Override
    public List<Lesson> getAllLessonByGroupName(String groupName) {
        List<Lesson> lessons = new LinkedList<>();
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)){
                System.out.println(group.getLessons());
                lessons.addAll(group.getLessons());
            }
        }
        System.out.println(lessons);
        return lessons;
    }

    @Override
    public String deleteLesson(String lessonName) {
        for (Group group : DataBase.groups) {
            Iterator<Lesson> iterator =group.getLessons().iterator();
            while (iterator.hasNext()){
                Lesson lesson = iterator.next();
                if (lesson.getNameTask().equalsIgnoreCase(lessonName)){
                    iterator.remove();
                    return "Lesson deleted";
                }
            }

        }
        return "Student not found";
    }
}
