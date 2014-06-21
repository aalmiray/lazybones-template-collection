package ${project_package_name};

public class ${project_capitalized_name}Service {
    public void sayHello(String name) {
        // simple check for empty String - replace with
        // your implementation of choice
        if ("".equals(name)) {
            System.out.println("Howdy stranger!");
        } else {
            System.out.println("Hello " + name);
        }
    }
}