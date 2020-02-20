package frc.team6502.holo.widget;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

@Description(name = "Media View", dataTypes = String.class)
@ParametrizedController("MediaWidget.fxml")
public class MediaWidget extends SimpleAnnotatedWidget<String> {

    @FXML
    private Pane root;

    @FXML
    private MediaView mview;
    private MediaPlayer player = null;

    @FXML
    private void initialize() {

        mview.setPreserveRatio(true);
//        view.setFitWidth(root.getWidth());
//        view.setFitHeight(root.getHeight());

        dataOrDefault.addListener((observable, oldValue, newValue) -> {
            String mpath = dataOrDefault.get();
            if(player != null) {
                player.stop();
                player.dispose();
                mview.setMediaPlayer(null);
            }
            try {
//                InputStream is = Files.newInputStream(Paths.get(mpath));
                Media m = new Media(new File(mpath).toURI().toURL().toString());
                player = new MediaPlayer(m);
                player.setAutoPlay(true);
                player.setStartTime(Duration.ZERO);
                player.setStopTime(m.getDuration());
                player.setCycleCount(MediaPlayer.INDEFINITE);
                mview.setMediaPlayer(player);
            } catch (IOException e) {
                e.printStackTrace();
                mview.setMediaPlayer(null);
            }
        });

        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            mview.setFitWidth(newValue.doubleValue());
        });

        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            mview.setFitHeight(newValue.doubleValue());
        });
    }

    private double map(double x, double xmin, double xmax, double omin, double omax){
        return ((x-xmin)/(xmax-xmin)) * (omax-omin) + omin;
    }

    @FXML
    private void dispose() {
        if(player != null) {
            player.stop();
            player.dispose();
            mview.setMediaPlayer(null);
        }
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
