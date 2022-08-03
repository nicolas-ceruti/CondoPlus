package com.mycompany.zcondo;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 500, 400);
        stage.setScene(scene);
        stage.setTitle("CondoPlus");
        stage.setResizable(false);
        stage.setWidth(700);
        stage.setHeight(500);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    static void showModal(String fxml) throws IOException {
        // Obtém a tela atual
        Window primaryStage = scene.getRoot().getScene().getWindow();

        // Carrega a nova tela
        Scene sceneModal = new Scene(loadFXML(fxml));

        // Abre o modal
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setScene(sceneModal);
        dialog.showAndWait();
    }

    static void closeCurrentWindow() {
        ((Stage) scene.getRoot().getScene().getWindow()).close();
    }

    static void closeWindow(Stage stage) {
        stage.close();
    }

}
