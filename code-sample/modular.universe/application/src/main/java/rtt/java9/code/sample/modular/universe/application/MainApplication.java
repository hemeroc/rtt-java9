package rtt.java9.code.sample.modular.universe.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rtt.java9.code.sample.modular.universe.service.SimpleUniverseService;
import rtt.java9.code.sample.modular.universe.service.UniverseService;
import rtt.java9.code.sample.modular.universe.ui.UniverseController;

public final class MainApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        // setup application
        primaryStage.setTitle("Universe Calculator");
        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);
        primaryStage.centerOnScreen();
        primaryStage.setOnCloseRequest(event -> System.out.println("Application shutdown initiated"));

        // initiate service and controller
        UniverseService universeService = new SimpleUniverseService();
        UniverseController universeController = new UniverseController(universeService);

        // prepare fxml loader to inject controller
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/universe.fxml"));
        fxmlLoader.setControllerFactory(param -> param.isInstance(universeController) ? universeController : null);
        primaryStage.setScene(new Scene(fxmlLoader.load()));

        // show application
        primaryStage.show();
        primaryStage.toFront();
        System.out.println("Application startup complete");
    }

    public static void main(String[] args) {
        System.out.println( "Application starting");
        Application.launch(MainApplication.class, args);
    }

}
