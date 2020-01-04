import repository.DatabaseRepository;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, head1, head2;
    JTextField t1;
    JPasswordField p1;
    JButton login;
    JButton signup;

    JLabel sl1, sl2, sl3;
    JTextField st1;
    JPasswordField sp1, sp2;


    public Login() {
        super("University Management System");
        setSize(450, 600);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.gray);

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowsize = getSize();

        this.setBounds((screensize.width - windowsize.width) / 2, (screensize.height - windowsize.height) / 2, windowsize.width, windowsize.height);

        head1 = new JLabel("Login");
        add(head1);
        head1.setBounds(50, 50, 100, 30);

        l1 = new JLabel("User Name");
        add(l1);
        l1.setBounds(60, 100, 100, 30);

        l2 = new JLabel("Password");
        add(l2);
        l2.setBounds(60, 175, 100, 30);


        t1 = new JTextField();
        add(t1);
        t1.setBounds(180, 100, 100, 30);

        p1 = new JPasswordField();
        add(p1);
        p1.setBounds(180, 175, 100, 30);


        login = new JButton("LOGIN");
        add(login);
        login.setBounds(280, 230, 80, 30);
        login.addActionListener(this);


        head2 = new JLabel("SignUp");
        add(head2);
        head2.setBounds(50, 280, 100, 30);


        sl1 = new JLabel("User Name");
        add(sl1);
        sl1.setBounds(60, 320, 150, 35);

        sl2 = new JLabel("Password");
        add(sl2);
        sl2.setBounds(60, 380, 150, 35);

        sl3 = new JLabel("Re-Type password");
        add(sl3);
        sl3.setBounds(60, 440, 150, 35);


        st1 = new JTextField();
        add(st1);
        st1.setBounds(200, 320, 180, 25);

        sp1 = new JPasswordField();
        add(sp1);
        sp1.setBounds(200, 380, 180, 25);


        sp2 = new JPasswordField();
        add(sp2);
        sp2.setBounds(200, 440, 180, 25);


        signup = new JButton("SIGN UP");
        add(signup);
        signup.setBounds(240, 480, 100, 30);
        signup.addActionListener(this);


    }


    public static void main(String[] args) {
        Login uadd = new Login();
        uadd.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String username = st1.getText();
        String password = sp1.getText();
        String conpassword = sp2.getText();

        String src = actionEvent.getActionCommand();
        if (src.equalsIgnoreCase("LOGIN")) {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            this.setVisible(false);
        } else if (src.equalsIgnoreCase("SIGN UP")) {
            if ((password != conpassword) || (username.equals(""))) {
                JOptionPane.showMessageDialog(null, "error");
                st1.setText("");
                sp1.setText("");
                sp2.setText("");
            } else {
            try {
                Repository repository = new DatabaseRepository();
                repository.userPost("insert into users values(?,?)", username, password);
            }catch (Exception e){
                e.getMessage();
            }
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
                this.setVisible(false);
            }
        }
    }
}