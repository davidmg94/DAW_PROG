module prog10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens prog10 to javafx.fxml;
    exports prog10;
}
