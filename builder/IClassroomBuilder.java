package builder;

import model.Classroom;
import model.Student;

import java.util.List;

public interface IClassroomBuilder {
    Classroom id(int id);
    Classroom name(String name);
    Classroom students(List<Student> students);
    Classroom build();
}
