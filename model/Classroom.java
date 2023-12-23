package model;

import builder.IClassroomBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Classroom implements IClassroomBuilder {
    private int id;
    private String name;

    private List<Student> students;

    public Classroom() {
    }

    public Classroom(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public Classroom id(int id) {
        this.id = id;
        return this;
    }

    @Override
    public Classroom name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Classroom students(List<Student> students) {
        this.students = students;
        return this;
    }

    @Override
    public Classroom build() {
        return this;
    }

    public static void createClass(List<Classroom> classes){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã lớp");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên lớp: ");
        String name = sc.nextLine();
         classes.add(new Classroom()
                 .id(id)
                 .name(name)
                 .students(new ArrayList<>())
                 .build());
        System.out.println("Tạo mới thành công!");
    }

    public void getProfile(){
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public static void showListStudents(List<Classroom> CLASSES, String name){
        Optional<Classroom> classroom;
        classroom = CLASSES.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
        if(classroom.isEmpty()){
            System.out.println("Lớp không tồn tại");
            return;
        }
        System.out.println("---------------------------------------");
        System.out.println("Danh sách học sinh lớp: " + classroom.get().getName());
        for(Student student : classroom.get().getStudents()){
            System.out.println(student);
        }
        System.out.println("---------------------------------------");
    }
    public static void showAll(List<Classroom> CLASSES){
        for(Classroom classroom : CLASSES){
            Classroom.showListStudents(CLASSES, classroom.getName());
        }
    }
}
