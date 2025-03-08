package de.validas.nlx.view.fxviews.semantics.util;

import de.validas.nlx.constants.Neo4jConstants;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class AttribUtils {
  public static Boolean createAttrEntry(final VBox box, final Node source, final Node target, final Relationship relationship) {
    boolean _xblockexpression = false;
    {
      final HBox hbox = new HBox();
      final Label label = new Label();
      final ComboBox<String> combo = new ComboBox<String>();
      label.setText(relationship.type());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[");
      String _get = ((String[])Conversions.unwrapArray(target.labels(), String.class))[0];
      _builder.append(_get);
      _builder.append(": ");
      String _asString = target.get(Neo4jConstants._NAME).asString();
      _builder.append(_asString);
      _builder.append("]");
      combo.setValue(_builder.toString());
      boolean _xifexpression = false;
      boolean _isFxApplicationThread = Platform.isFxApplicationThread();
      if (_isFxApplicationThread) {
        _xifexpression = AttribUtils.assign(label, combo, hbox, box);
      } else {
        final Runnable _function = () -> {
          AttribUtils.assign(label, combo, hbox, box);
        };
        Platform.runLater(_function);
      }
      _xblockexpression = _xifexpression;
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public static boolean assign(final Label label, final ComboBox<String> combo, final HBox hbox, final VBox box) {
    boolean _xblockexpression = false;
    {
      hbox.getChildren().add(label);
      hbox.getChildren().add(combo);
      _xblockexpression = box.getChildren().add(hbox);
    }
    return _xblockexpression;
  }
}
