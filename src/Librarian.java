public class Librarian extends Person {
    private String employeeId;

    public Librarian(String name, String employeeId) {
        super(name);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
