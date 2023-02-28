public class Employees {

    private String name;
    private Integer age;

    public Employees(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Имя: " + name +" , возраст: " + age + ".";
    }
}
