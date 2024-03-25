package kgkursanov.generator;

public class GeneredId {

    public static Long idStudent  = 0L;
    public static Long idGroup  = 0L;
    public static Long idLesson  = 0L;


    public static Long idGeneratorStudent(){
        return ++idStudent;
    }
    public static Long idGeneratorGroup(){
        return ++idGroup;
    }
    public static Long idGeneratorLesson(){
        return ++idLesson;
    }
}
