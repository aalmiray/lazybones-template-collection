package ${project_package_name};

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.inject.Inject;

public class ${project_capitalized_name}Presenter {
    @FXML
    private TextField name;

    @Inject
    ${project_capitalized_name}Service ${project_name}Service;

    public void sayHello() {
        // Watch out! this code is executed inside the UI thread.
        ${project_name}Service.sayHello(name.getText());
    }
}
