package kgkursanov.service;

import kgkursanov.models.Lesson;

import java.util.List;
import java.util.Set;

public interface LessonService {

    String addNewLessonToGroup(String groupName, Lesson lesson);

    Lesson getLessonByName(String nameLesson);

    List<Lesson> getAllLessonByGroupName(String groupName);

    String deleteLesson(String LessonName);



}
