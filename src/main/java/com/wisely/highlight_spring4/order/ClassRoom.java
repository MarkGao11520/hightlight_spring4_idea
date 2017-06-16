package com.wisely.highlight_spring4.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/4/30.
 */
@Component
public class ClassRoom {
    @Autowired
    private List<Person> classroomlist;

    public List<Person> getClassroomlist() {
        return classroomlist;
    }

}
