module com.notminimal.markdownapp.markdownapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.notminimal.markdownapp.markdownapp to javafx.fxml;
    exports com.notminimal.markdownapp.markdownapp;
}