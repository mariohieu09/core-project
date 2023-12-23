package model;

import builder.IStudentBuilder;
import model.Classroom;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Student implements IStudentBuilder {
    private int id;
    private String name;
    private String address;

    private Classroom classroom;

    public Student() {
    }

    public Student(int id, String name, String address, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public Student id(int id) {
        this.id = id;
        return this;
    }

    @Override
    public Student name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Student address(String address) {
        this.address  = address;
        return this;
    }

    @Override
    public Student classroom(Classroom classroom) {
        this.classroom = classroom;
        return this;
    }

    @Override
    public Student build() {
        return this;
    }

    public static Student createStudent(List<Classroom> classes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã học sinh");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên học sinh: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        Optional<Classroom> classroomOptional = Optional.empty();
        while(classroomOptional.isEmpty()){
            System.out.println("Nhập tên lớp: ");
            String className = scanner.nextLine();
            classroomOptional = classes.stream()
                    .filter(s -> s.getName().equals(className)).findFirst();
        }
        Student student = new Student()
                .id(id)
                .name(name)
                .address(address)
                .classroom(classroomOptional.get())
                .build();
        classroomOptional.get().getStudents().add(student);
        System.out.println("Tạo mới thành công!");
        System.out.println(student);
        return student;
    }

    public void showProfile(){

    }



    @Override
    public String toString() {
        return "Mã học sinh: " + this.id + "\n" +
                "Tên học sinh: " + this.name.toUpperCase() + "\n" +
                "Địa chỉ: " + this.address + "\n" +
                "Lớp: " + this.classroom.getName();
    }
}
