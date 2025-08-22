package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    static StudentHardCodeDatasource datasource;
    static StudentList studentList;

    @BeforeAll
    static void init() {
        datasource = new StudentHardCodeDatasource();
        studentList = datasource.readData();
    }

    @Test
    @DisplayName("อ่านข้อมูล")
    void testReadData() {
        assertNotEquals(0, studentList.getStudents().size());
    }

    @Test
    @DisplayName("หาการมีอยู่ของนักเรียนในข้อมูลตัวอย่าง")
    void testFindSampleStudent() {
        Student student = studentList.findStudentById("6710400003");
        assertNotEquals(null, student);
    }
}