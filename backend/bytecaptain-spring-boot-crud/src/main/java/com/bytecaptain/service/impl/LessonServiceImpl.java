package com.bytecaptain.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytecaptain.exception.LessonNotFoundException;
import com.bytecaptain.model.Lesson;
import com.bytecaptain.repository.LessonRepository;
import com.bytecaptain.service.LessonService;
@Service
public class LessonServiceImpl implements LessonService  {
	
	Logger logger = LoggerFactory.getLogger(LessonServiceImpl.class);
	
    @Autowired 
    private LessonRepository courseRepository;

   	@Override
	public List<Lesson> getAllLessons(String username) {
   		logger.trace("Entered getAlllessons method");
   		
   		List<Lesson> lessons = courseRepository.findAll();

		return lessons;
	}

	@Override
	public Lesson getLesson(String username, long id) {
		return courseRepository.findById(id).orElseThrow(() -> new LessonNotFoundException(id));
	}

	@Override
	public void deleteLesson(String username, long id) {
		Optional<Lesson> course = courseRepository.findById(id);
		if(course.isPresent()) {
			courseRepository.deleteById(id);
		} else {
			throw new LessonNotFoundException(id);
		}
		
	}

	@Override
	public Lesson updateLesson(String username, long id, Lesson lesson) {
		Lesson lessonUpdated = courseRepository.save(lesson);
		return lessonUpdated;
	}

	@Override
	public Lesson createLesson(String username, Lesson lesson) {
		Lesson createdLesson = courseRepository.save(lesson);
		return createdLesson;
		
	}
}
