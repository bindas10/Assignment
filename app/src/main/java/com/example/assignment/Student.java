package com.example.assignment;

public class Student {

    private String name;
        private String rollno;
        private int age;


        public Student(String name, String rollno, int age) {
            this.name = name;
            this.rollno = rollno;
            this.age = age;

        }

    public Student(String nameValue, int ageValue, String rollNoValue) {
        this.name = nameValue;
        this.rollno = rollNoValue;
        this.age = ageValue;
    }

    public void setName(String name) {
            this.name = name;
        }

        public void setRollno(String rollno) {
            this.rollno = rollno;
        }

        public void setAge(int age) {
            this.age = age;
        }


        public String getName() {
            return name;
        }

        public String getRollno() {
            return rollno;
        }

        public int getAge() {
            return age;
        }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno='" + rollno + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


}


