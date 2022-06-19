module com.example.sae {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.sae to javafx.fxml;
    exports com.example.sae;
    exports modele;
    exports vue;
}
