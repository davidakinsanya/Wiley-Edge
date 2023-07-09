package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {
  private final UserIO io = new UserIOConsoleImpl();
  private final ClassRosterDao dao = new ClassRosterDaoFileImpl();
  private final ClassRosterView view = new ClassRosterView();

  public void run() {
    boolean keepGoing = true;
    int menuSelection = 0;
    while (keepGoing) {
      io.print("Main Menu");
      io.print("1. List Student IDs");
      io.print("2. Create a Student");
      io.print("3. View a Student");
      io.print("4. Remove a Student");
      io.print("5. Exit");

      menuSelection = io.readInt("Please select from the above choices ", 1, 5);

      switch (menuSelection) {
        case 1:
          listStudents();
          break;
        case 2:
          createStudent();
          break;
        case 3:
          viewStudent();
          break;
        case 4:
          io.print("4. Remove a Student");
          break;
        case 5:
          io.print("5. Exit");
          break;
        default:
          io.print("UNKNOWN COMMAND");
      }

    }
    io.print("GOOD BYE");
  }

  private void createStudent() {
    view.displayCreateStudentBanner();
    Student newStudent = view.getNewStudentInfo();
    dao.addStudent(newStudent.getStudentId(), newStudent);
    view.displayCreateSuccessBanner();
  }

  private void listStudents() {
    view.displayAllStudentsBanner();
    List<Student> studentList = dao.getAllStudents();
    view.displayStudentList(studentList);
  }

  private void viewStudent() {
    view.displayDisplayStudentBanner();
    String studentId = view.getStudentIdChoice();
    Student student = dao.getStudent(studentId);
    view.displayStudent(student);
  }
}
