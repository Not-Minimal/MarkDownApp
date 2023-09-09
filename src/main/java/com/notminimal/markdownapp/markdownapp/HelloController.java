package com.notminimal.markdownapp.markdownapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button openMarkdownJoinerButton;

    private HelloApplication mainApp;

    public void setMainApp(HelloApplication mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onOpenMarkdownJoinerButtonClick() {
        try {
            mainApp.showMarkdownJoinerView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinMarkdown() {
        System.out.println("ActionEvent");
    }

    public void clearTextArea() {
        System.out.println("Clear event");
    }
}
