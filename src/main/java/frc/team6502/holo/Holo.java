package frc.team6502.holo;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;
import frc.team6502.holo.widget.ImageWidget;
import frc.team6502.holo.widget.MediaWidget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.crypto.Data;

@Description(group = "frc.team6502", name="Holo", version = "0.0.2", summary = "Shuffleboard image and media display")
public class Holo extends Plugin {

    @Override
    public List<DataType> getDataTypes(){
        return new ArrayList<>();
    }

    @Override
    public List<ComponentType> getComponents(){
        return List.of(
//                WidgetType.forAnnotatedWidget(Point2DWidget.class),
                WidgetType.forAnnotatedWidget(ImageWidget.class),
                WidgetType.forAnnotatedWidget(MediaWidget.class)
        );
    }

    @Override
    public Map<DataType, ComponentType> getDefaultComponents() {
        return new HashMap<>();
    }
}
