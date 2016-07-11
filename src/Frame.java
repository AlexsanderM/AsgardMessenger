import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

public class Frame extends JFrame {
    FormEnterPhone formEnterPhone = new FormEnterPhone();
    Telegram telegram = new Telegram();
    Point point = new Point();

    private int widthForm = 800;
    private int heightForm = 600;

    Frame() throws IOException {
        setContentPane(formEnterPhone.getFormEnterPhone());
        setSize(widthForm, heightForm);

        setLayout(new BoxLayout(formEnterPhone.getFormEnterPhone() ,BoxLayout.Y_AXIS));

        formEnterPhone.getTopPanek().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                point = e.getPoint();
            }
        });

        formEnterPhone.getTopPanek().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

                int thisX = getLocation().x;
                int thisY = getLocation().y;

                int xMoved = (thisX + e.getX()) - (thisX + point.x);
                int yMoved = (thisY + e.getY()) - (thisY + point.y);

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                setLocation(X, Y);
            }
        });
    }
}
