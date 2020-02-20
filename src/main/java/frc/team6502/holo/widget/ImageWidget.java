package frc.team6502.holo.widget;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

@Description(name = "Image View", dataTypes = String.class)
@ParametrizedController("ImageWidget.fxml")
public class ImageWidget extends SimpleAnnotatedWidget<String> {

    @FXML
    private Pane root;

    @FXML
    private ImageView view;

    @FXML
    private void initialize() {

        view.setPreserveRatio(true);
//        view.setFitWidth(root.getWidth());
//        view.setFitHeight(root.getHeight());

        dataOrDefault.addListener((observable, oldValue, newValue) -> {
            String imgpath = dataOrDefault.get();
            try {
                InputStream is = Files.newInputStream(Paths.get(imgpath));
                Image img = new Image(is);

                view.setImage(img);
            } catch (IOException e) {
                e.printStackTrace();
                view.setImage(null);
            }
        });

        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            view.setFitWidth(newValue.doubleValue());
        });

        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            view.setFitHeight(newValue.doubleValue());
        });
    }

    private double map(double x, double xmin, double xmax, double omin, double omax){
        return ((x-xmin)/(xmax-xmin)) * (omax-omin) + omin;
    }

    /*private void drawCanvas(boolean clear){
        try {

            double hwRatio = img.getHeight() / img.getWidth();
            double rootHeight = root.heightProperty().get();
            if(rootHeight / root.widthProperty().get() >= hwRatio) {
                canvas.widthProperty().setValue(root.widthProperty().get());
                canvas.heightProperty().setValue(canvas.widthProperty().get() * hwRatio);
            } else {
                canvas.heightProperty().setValue(rootHeight);
                canvas.widthProperty().setValue(canvas.heightProperty().get() / hwRatio);
            }
            if(clear) clearCanvas(null);
            gc.drawImage(img, 0, 0, canvas.getWidth(), canvas.getHeight());
            is.close();
        } catch(Exception e) {
            e.printStackTrace();
            canvas.widthProperty().setValue(root.widthProperty().get());
            canvas.heightProperty().setValue(root.heightProperty().get());
            clearCanvas(null);
        }

    }*/

    @Override
    public Pane getView() {
        return root;
    }

    /*public void clearCanvas(ActionEvent actionEvent) {
        gc.setFill(Paint.valueOf("#ff00ff"));
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }*/
}
