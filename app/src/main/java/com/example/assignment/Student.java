package com.example.assignment;

public class Student {

    private String name;
        private String rollno;
        private String age;
        private String section;

        public Student(String name, String rollno, String age, String section) {
            this.name = name;
            this.rollno = rollno;
            this.age = age;
            this.section = section;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRollno(String rollno) {
            this.rollno = rollno;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getName() {
            return name;
        }

        public String getRollno() {
            return rollno;
        }

        public String getAge() {
            return age;
        }

        public String getSection() {
            return section;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rollno='" + rollno + '\'' +
                    ", age='" + age + '\'' +
                    ", section='" + section + '\'' +
                    '}';
        }
    }


