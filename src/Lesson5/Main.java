package Lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = getEmployees();
        printInfoEmployeesOlderThan(40, employees);
    }

    private static void printInfoEmployeesOlderThan(int age, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            if (emp.age > age) {
                emp.employeeInfo();
            }
        }

    }


    public static Employee[] getEmployees() {
        //4 Создать массив из 5 сотрудников
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Mr Black", "owner", "black@mail.ru", 7444444,
                500, 43);
        employees[1] = new Employee("Mr White", "loyer", "white@mail.ru", 8444444,
                600, 30);
        employees[2] = new Employee("Mr Blue", "engeneer", "bluee@mail.ru", 9444444,
                6100, 45);
        employees[3] = new Employee("Mr Green", "cleaner", "green@mail.ru", 5444444,
                200, 25);
        employees[4] = new Employee("Mr Yellow", "security", "yellow@mail.ru", 4444444,
                300, 50);
        return employees;
    }
}

