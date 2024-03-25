package kgkursanov.models;

public class Lesson {
    private Long id;

    private String nameTask;

    private String descriptionTask;

    public Lesson(Long id, String nameTask, String descriptionTask) {
        this.id = id;
        this.nameTask = nameTask;
        this.descriptionTask = descriptionTask;
    }

    public Lesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", nameTask='" + nameTask + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                '}';
    }
}
