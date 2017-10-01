package rtt.java9.code.sample.modular.universe.ui;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import rtt.java9.code.sample.modular.universe.service.UniverseService;


public class UniverseController {

    private static final double VISIBLE = 1.0;
    private static final double INVISIBLE = 0.0;

    private final FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1));
    private final FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(3));

    private final UniverseService universeService;

    @FXML
    private Button btnQuestion;

    @FXML
    private Label lblAnswer;

    public UniverseController(UniverseService universeService) {
        this.universeService = universeService;
        // some transitions for a visually appealing effect
        fadeOutTransition.setFromValue(VISIBLE);
        fadeOutTransition.setToValue(INVISIBLE);
        fadeInTransition.setFromValue(INVISIBLE);
        fadeInTransition.setToValue(VISIBLE);
    }

    @FXML
    private void calculateAnswerButtonPressed() {
        System.out.println("called calculateAnswerButtonPressed");
        // create a thread and task to prevent ui from freezing on when doing long running operations
        new Thread(new Task<String>() {
            @Override
            protected String call() {
                btnQuestion.disableProperty().setValue(true);
                return universeService.calculateAnswer();
            }

            @Override
            protected void succeeded() {
                super.succeeded();
                System.out.println("calculation succeeded with value " + getValue());
                // update ui with animation
                lblAnswer.setText(getValue());
                fadeOutTransition.setNode(btnQuestion);
                fadeInTransition.setNode(lblAnswer);
                new ParallelTransition(
                    fadeOutTransition,
                    fadeInTransition
                ).playFromStart();
            }
        }, "calculation").start();
    }

}
