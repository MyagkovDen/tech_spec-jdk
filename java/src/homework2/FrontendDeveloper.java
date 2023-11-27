package src.homework2;

public class FrontendDeveloper implements Frontender{
    private final String name;
    private final double salary;

    public FrontendDeveloper(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void developGUI() {
        System.out.println("Writing code for GUI");
    }
}
