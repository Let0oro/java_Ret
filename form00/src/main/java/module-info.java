module jmb.juanma.form00 {
    requires javafx.controls;
    requires javafx.fxml;

    exports jmb.juanma.form00.aplications;
    opens jmb.juanma.form00.aplications to javafx.graphics, javafx.fxml;

    opens jmb.juanma.form00.views to javafx.fxml;
    opens jmb.juanma.form00.models to javafx.fxml;
    opens jmb.juanma.form00.presenters to javafx.fxml;
}