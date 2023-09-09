package com.notminimal.markdownapp.markdownapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private Pane rootLayout;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        initRootLayout();
        showHelloView();
    }

    public static void main(String[] args) {
        launch();
    }

    private void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        rootLayout = loader.load();

        // Get a reference to the HelloController
        HelloController helloController = loader.getController();

        // Set the mainApp field of the HelloController
        helloController.setMainApp(this);

        Scene scene = new Scene(rootLayout, 320, 240);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showHelloView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        Pane helloView = loader.load();

        // Replace the current content with the new view (hello-view.fxml)
        rootLayout.getChildren().setAll(helloView);
    }

    public void showMarkdownJoinerView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("MarkdownJoinerView.fxml"));
        Pane markdownJoinerView = loader.load();

        // Replace the current content with the new view (MarkdownJoinerView.fxml)
        rootLayout.getChildren().setAll(markdownJoinerView);
    }
}
