public class Staff {
    private Integer staff_id,age;
    private String first_name,last_name,address;

    public Staff(Integer id, String firstName, String lastName, Integer age, String address) {
    }

    public Staff() {
    }

    public Staff(int staff_id, String first_name, String last_name, int age, String address) {
        this.staff_id = staff_id;
        this.age = age;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;

    }
}
