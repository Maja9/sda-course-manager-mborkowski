package com.sda.coursemanger.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private List<LessonBlock> lessonBlocks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LessonBlock> getLessonBlocks() {
        return lessonBlocks;
    }

    public void setLessonBlocks(List<LessonBlock> lessonBlocks) {
        this.lessonBlocks = lessonBlocks;
    }
}
