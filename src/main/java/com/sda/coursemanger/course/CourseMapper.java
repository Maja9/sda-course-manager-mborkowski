package com.sda.coursemanger.course;

import com.sda.coursemanger.course.model.Course;
import com.sda.coursemanger.course.model.dto.CourseDetailsDto;
import com.sda.coursemanger.course.model.dto.CourseDto;
import com.sda.coursemanger.lesson.LessonMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public static List<CourseDto> mapCourseToDtoList(List<Course> courses) {
        return courses.stream()
                .map(CourseMapper::mapCourseToDto)
                .collect(Collectors.toList());
    }

    public static CourseDto mapCourseToDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());

        int hourCount = course.getLessonBlocks().stream()
                .mapToInt(block -> block.getLessons().size() * 8)
                .sum();
        courseDto.setCourseLength(hourCount);

        return courseDto;
    }

    public static CourseDetailsDto mapCourseToDetailsDto(Course course) {
        CourseDetailsDto courseDto = new CourseDetailsDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setLessonBlocks(LessonMapper.mapLoessonBlockToDtoList(course.getLessonBlocks()));

        return courseDto;
    }
}
