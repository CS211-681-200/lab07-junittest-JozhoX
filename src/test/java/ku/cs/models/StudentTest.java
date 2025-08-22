package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    static Student s;

    @BeforeAll
    static void init() {
        s = new Student("420", "Test");
    }

    @Test
    @DisplayName("เพิ่มคะแนนนิสิต 49 และ 20 คะแนน")
    void testAddScore() {
        s.addScore(49);
        assertEquals(49, s.getScore());
        s.addScore(20);
        assertEquals(69, s.getScore());
    }

    @Test
    @DisplayName("แสดงเกรด")
    void testCalculateGrade() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(40);
        assertEquals("F", s.getGrade());

        s.addScore(10);
        assertEquals("D", s.getGrade());

        s.addScore(10);
        assertEquals("C", s.getGrade());

        s.addScore(10);
        assertEquals("B", s.getGrade());

        s.addScore(10);
        assertEquals("A", s.getGrade());
    }

    @Test
    @DisplayName("เปลี่ยนชื่อ")
    void testChangeName() {
        s.changeName("Dimitri");
        assertEquals("Dimitri", s.getName());
    }

    @Test
    @DisplayName("ส่วนประกอบของชื่อ")
    void testNameContains() {
        assertTrue(s.isNameContains("mitri"));
    }
}