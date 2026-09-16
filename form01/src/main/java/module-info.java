module jmb.juanma.form01 {
    requires javafx.controls;
    requires javafx.fxml;

    exports jmb.juanma.form01.aplications;
    opens jmb.juanma.form01.aplications to javafx.graphics, javafx.fxml;

    opens jmb.juanma.form01.views to javafx.fxml;
    opens jmb.juanma.form01.models to javafx.fxml;
    opens jmb.juanma.form01.presenters to javafx.fxml;
}