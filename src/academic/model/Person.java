package academic.model;
/**
 @author 12S22036 Jonathan Fransilo Hutabarat
         12S22030 Bryan Evans Simamora
 */
public class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}