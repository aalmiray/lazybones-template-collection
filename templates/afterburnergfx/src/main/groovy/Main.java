package ${project_package_name};

import com.airhacks.afterburner.injection.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ${project_capitalized_name}Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        ${project_capitalized_name}View view = new ${project_capitalized_name}View();
        Scene scene = new Scene(view.getView(), 390, 80);
        stage.setTitle("${project_name}");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        Injector.forgetAll();
    }
}
