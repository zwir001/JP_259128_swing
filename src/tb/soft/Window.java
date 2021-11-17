package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Window extends JFrame {

    private final Map<String, String> user_data = new HashMap<>();

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
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.white);

        setBounds(450, 300, 300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel log_in_label = new JLabel("User: ");
        set_element(panel, log_in_label, 0, 0);

        JTextField name = new JTextField(10);
        set_element(panel, name, 1, 0);

        JLabel password = new JLabel("Password: ");
        set_element(panel, password, 0, 1);

        JPasswordField key = new JPasswordField(10);
        set_element(panel, key, 1, 1);

        JButton log_in = new JButton("Login");
        JButton cancel = new JButton("Cancel");

        log_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_data(name, key, panel);
            }
        });
        set_element(panel, log_in,0, 2);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset(name, key, panel);
            }
        });
        set_element(panel, cancel, 1, 2);
    }

    private void add_user(String name, String password){
        this.user_data.put(name, password);
    }

    private void set_element(JPanel panel, JComponent element, int x, int y){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        panel.add(element, c);
    }

    private void check_data( JTextField name, JPasswordField password, JPanel panel ) {
            String login = name.getText();
            String key = new String(password.getPassword());
            if(user_data.containsKey(key) && user_data.containsValue(login)){
            panel.setBackground(Color.green);
            }
            else{
            panel.setBackground(Color.red);
            }
    }

    private void reset(JTextField name, JPasswordField password, JPanel panel){
        name.setText("");
        password.setText("");
        panel.setBackground(Color.white);
    }

    private void test_users(){
        add_user("student", "student");
        add_user("teacher", "1234");
        add_user("admin", "admin");
        add_user("boss", "king");
    }
}
