package com.example.app1;
public class Student {
    private String id;
    private String name;
    private int age;
    private double gpa;
    public Student(String id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    public String getRank() {
        if (gpa >= 8.5) {
            return "Giỏi";
        } else if (gpa >= 7.0) {
            return "Khá";
        } else if (gpa >= 5.0) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
    public String displayInfo() {
        return "Mã số: " + id + "\n" +
               "Họ tên: " + name + "\n" +
               "Tuổi: " + age + "\n" +
               "Điểm GPA: " + gpa + "\n" +
               "Xếp loại: " + getRank() + "\n" +
               "-----------------------------------\n";
    }
}
