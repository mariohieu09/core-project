import model.Classroom;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static  Scanner SC;
    private static  List<Classroom> CLASSES;
    static {
            SC = new Scanner(System.in);
            CLASSES = new ArrayList<>();
    }
    public static void main(String[] args) {
        boolean remain = true;
        while (remain){
            System.out.println("""
                    1. Tạo mới học sinh\s
                    2. Tạo mới lớp học\s
                    3. Xem học sinh ở một lớp\s
                    4. Xem học sinh ở tất cả lớp\s
                    5. Xem thông tin học sinh\s
                    6. Thoát""");
            int choice = SC.nextInt();
            SC.nextLine();
            switch (choice) {
                case 1 -> {
                    Student student = Student.createStudent(CLASSES);
                }
                case 2 -> Classroom.createClass(CLASSES);
                case 3 -> {
                    System.out.println("Nhập tên lớp: ");
                    String name = SC.nextLine();
                    Classroom.showListStudents(CLASSES, name);
                }
                case 4 -> Classroom.showAll(CLASSES);

                case 6 -> remain = false;
            }
        }
    }
}
