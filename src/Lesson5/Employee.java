package Lesson5;

public class Employee {
//1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;

    String full_name;
    //String position;
    String email;
    int phone;
    //float salary;
    int age;
    private Position position;


    //2. Конструктор класса должен заполнять эти поля при создании объекта;
    public Employee(String fullName, String position, String email, int phone, float salary, int age) {
        this(fullName, age);
        //this.position = position;
        this.position = new Position(position, salary);
        this.email = email;
        this.phone = phone;
        //this.salary = salary;
    }

    public Employee(String fullName, int age) {
        full_name = fullName;
        this.age = age;
    }


    public String getPosition() {
        return position.name;
    }

    public void setPosition(String value) {
        position.name = value;
    }

    public float getSalary() {
        return position.salary;
    }

    public void setSalary(float value) {
        position.salary = value;
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void employeeInfo() {
        System.out.printf("Employee: %s, position: %s, email: %s, phone: %s, $ %.2f, age:%d%n",
                full_name, getPosition(), email, phone, getSalary(), age);
    }


}
