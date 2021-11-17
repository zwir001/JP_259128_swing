package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Window extends JFrame {

    private final Set<User> user_data = new HashSet<>();

    public Window() throws HeadlessException {
        this("Undefined");
    }

    public Window(String title) throws HeadlessException {
        super(title);
        test_users();
        build_UI();
    }

    private void build_UI(){
        JPanel panel= new JPanel();
        add(panel);

        setBounds(450, 300, 600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel log_in_label = new JLabel("Login: ");

        JButton log_in = new JButton("Zaloguj");

        log_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void add_user(String name, String password){
        User user=new User(name, password);
        this.user_data.add(user);
    }

    private void test_users(){
        add_user("student", "student");
        add_user("teacher", "1234");
        add_user("admin", "admin");
        add_user("boss", "king");
    }
}
