import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerClear implements ActionListener {
    private DrawPanel panel;

    public ActionListenerClear(DrawPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.clearGrid();
    }
}