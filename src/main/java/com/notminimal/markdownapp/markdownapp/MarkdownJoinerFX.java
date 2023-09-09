package com.notminimal.markdownapp.markdownapp;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MarkdownJoinerFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivos Markdown");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos Markdown", "*.md"));

        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(primaryStage);

        if (selectedFiles != null && !selectedFiles.isEmpty()) {
            // Create a new mutable list and copy the selected files
            List<File> sortedFiles = new ArrayList<>(selectedFiles);

            // Sort the list alphabetically based on filenames
            sortedFiles.sort(Comparator.comparing(File::getName));

            String outputFileName = "output.md"; // Nombre del archivo de salida

            try (FileWriter writer = new FileWriter(outputFileName)) {
                for (File inputFile : sortedFiles) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            writer.write(line + "\n");
                        }
                    }
                }
                System.out.println("Archivos Markdown unidos con éxito en " + outputFileName);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error al unir los archivos Markdown.");
            }
        } else {
            System.out.println("No se seleccionaron archivos.");
        }
    }
}
