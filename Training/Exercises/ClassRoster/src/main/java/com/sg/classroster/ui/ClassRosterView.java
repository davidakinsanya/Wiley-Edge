package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;

import java.util.List;

public class ClassRosterView {
  private final UserIO io = new UserIOConsoleImpl();

  public Student getNewStudentInfo() {
    String studentId = io.readString("Please enter Student ID: ");
    String firstName = io.readString("Please enter First Name: ");
    String lastName = io.readString("Please enter Last Name: ");
    String cohort = io.readString("Please enter Cohort: ");
    Student currentStudent = new Student(studentId);
    currentStudent.setFirstName(firstName);
    currentStudent.setLastName(lastName);
    currentStudent.setCohort(cohort);
    return currentStudent;
  }

  public void displayCreateStudentBanner() {
    io.print("=== Create Student ===");
  }

  public void displayDisplayStudentBanner () {
    io.print("=== Display Student ===");
  }

  public void displayAllStudentsBanner() {
    io.print("=== Display All Students ===");
  }

  public void displayCreateSuccessBanner() {
    io.readString(
            "Student successfully created.  Please hit enter to continue ");
  }

  public void displayStudentList(List<Student> studentList) {
    for (Student currentStudent : studentList) {
      String studentInfo = String.format("#%s : %s %s",
              currentStudent.getStudentId(),
              currentStudent.getFirstName(),
              currentStudent.getLastName());
      io.print(studentInfo);
    }
    io.readString("Please hit enter to continue.");
  }

  public String getStudentIdChoice() {
    return io.readString("Please enter the Student ID.");
  }

  public void displayStudent(Student student) {
    if (student != null) {
      io.print(student.getStudentId());
      io.print(student.getFirstName() + " " + student.getLastName());
      io.print(student.getCohort());
      io.print("");
    } else {
      io.print("No such student.");
    }
    io.readString("Please hit enter to continue.");
  }
}
