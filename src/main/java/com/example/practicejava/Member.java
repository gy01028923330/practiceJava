package com.example.practicejava;

public class Member {

    //생성자 메소드 => Constructor
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //메소드 Overloading
    public Member() {

    }

    public Member(String name) {
        this.name = name;
    }

    //클래스 변수
    private String id;
    private String password;
    private String name;
    private int age;

    //메소드
    // Getter
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
    //Setter
    public void setName (String name){
        this.name = name;
    }

    public void setAge ( int age){
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



