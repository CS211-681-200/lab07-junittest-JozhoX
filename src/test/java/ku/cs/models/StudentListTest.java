package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    static StudentList studentList;

    @BeforeAll
    static void init() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("เพิ่มนักเรียน")
    void testAddStudent() {
        studentList.addNewStudent("99", "New Student");
        Student student = studentList.findStudentById("99");
        assertEquals("99", student.getId());
        assertEquals("New Student", student.getName());
        assertEquals(0, student.getScore());
    }

    @Test
    @DisplayName("เพิ่มนักเรียนพร้อมคะแนน")
    void testAddStudentWithScore() {
        studentList.addNewStudent("101", "Potch", 71);
        Student student = studentList.findStudentById("101");

        assertEquals("101", student.getId());
        assertEquals("Potch", student.getName());
        assertEquals(71, student.getScore());
    }

    @Test
    void testFilterStudents() {
        studentList.addNewStudent("200", "Brondi");
        studentList.addNewStudent("201", "Arceno");
        studentList.addNewStudent("202", "Valdi");
        studentList.addNewStudent("203", "Arcon");
        StudentList students = studentList.filterByName("Arc");
        assertEquals(2, students.getStudents().size());
    }

    @Test
    @DisplayName("ให้คะแนนนักเรียน")
    void testGiveScoreToId() {
        studentList.addNewStudent("100", "Jozho");

        studentList.giveScoreToId("100", 55);
        Student student = studentList.findStudentById("100");
        assertEquals(55, student.getScore());

        studentList.giveScoreToId("100", 2);
        assertEquals(57, student.getScore());
    }

    @Test
    void testViewGradeOfId() {
        studentList.addNewStudent("300", "Kafka", 80);
        assertEquals("A", studentList.viewGradeOfId("300"));
    }

}