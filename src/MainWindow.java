import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {


    public  MainWindow(){
        super("University Management System");
        setSize(650, 600);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.gray);

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowsize = getSize();

        this.setBounds((screensize.width - windowsize.width) / 2, (screensize.height - windowsize.height) / 2, windowsize.width, windowsize.height);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
