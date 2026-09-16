package jmb.juanma.form01.aplications;

import jmb.juanma.form01.contracts.AplicacionContract;
import jmb.juanma.form01.views.AplicacionView;
import jmb.juanma.form01.presenters.AplicacionPresenter;
import jmb.juanma.form01.models.AplicacionModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AplicacionContract.View vista = new AplicacionView();
        AplicacionModel modelo = new AplicacionModel();
        new AplicacionPresenter(modelo,vista);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/aplicacion.fxml"));
        loader.setControllerFactory(type->vista);
        Parent root = loader.load();
        stage.setScene(new Scene(root));

        stage.setTitle("Formulario 1");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}