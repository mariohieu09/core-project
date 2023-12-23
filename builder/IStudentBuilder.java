package builder;
import model.Classroom;
import model.Student;
public interface IStudentBuilder {

    Student id(int id);
    Student name(String name);
    Student address(String address);
    Student classroom(Classroom classroom);

    Student build();

}
