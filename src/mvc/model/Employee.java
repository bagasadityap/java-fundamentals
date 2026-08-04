package mvc.model;

public class Employee {
    private String name, idNumber, directorate;
    private int age;

    public Employee() {
    }

    public Employee(String name, String idNumber, int age, String directorate) {
        this.name = name;
        this.idNumber = idNumber;
        this.age = age;
        this.directorate = directorate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDirectorate() {
        return directorate;
    }

    public void setDirectorate(String directorate) {
        this.directorate = directorate;
    }
}
