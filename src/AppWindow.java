import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AppWindow extends Frame {
    public AppWindow(){

        addWindowListener(new MyWindowAdapter());
    }

    // создать окно
    public static void main(String[] args) {
        AppWindow appwin = new AppWindow();
        Button b = new Button();
        b.setBounds(50, 50, 100, 50);
        appwin.setSize(new Dimension(300,200));
        appwin.setTitle("An Awt-Based Application");
        appwin.setVisible(true);
        appwin.setLayout(null);
        appwin.add(b);
        b.setLabel("Exit");
        b.setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        //b.addMouseMotionListener(new MyMouseAdapter());
        b.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int x = getRandomNumberInRange(0, 1920 - 100);
                int y = getRandomNumberInRange(0, 1080 - 50);
                b.setBounds(x, y, 100, 50);
            }
        });

        appwin.add(b);
        appwin.setLayout(null);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}


class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent me) {
        System.exit(0);
    }
}

//class MyMouseAdapter extends MouseAdapter {
  //  public void mouseMoved(MouseEvent e){
    //    System.exit(0);
    //}
//}