package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;

import java.util.List;

public interface ClassRosterDao {

  Student addStudent(String studentId, Student student);
  List<Student> getAllStudents();
  Student getStudent(String studentId);
  Student removeStudent(String studentId);

}
