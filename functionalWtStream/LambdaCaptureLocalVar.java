package functionalWtStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class validates that anonymous class and lambda expression store copy of local variable in the class.
 * thus, by modifying variable it causes compile error - for local variable
 * or cause nullPointException when the button are pressed - for class variables
 */
public class LambdaCaptureLocalVar {

    private final static int FIELD_WIDTH = 20;
    private static JTextField staticTextField;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        staticTextField = new JTextField(FIELD_WIDTH);
        staticTextField.setText("Static field");

        JTextField localTextField = new JTextField(FIELD_WIDTH);
        localTextField.setText("local variable");

        JButton helloButton = new JButton("Say Hello");
        helloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staticTextField.setText("Hello World!");
                localTextField.setText("Hello World!");
            }
        });

        JButton goodbyeButton = new JButton("Say Goodbye");
        goodbyeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staticTextField.setText("Goodbye World!");
                localTextField.setText("Goodbye World!");
            }
        });

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(staticTextField);
        contentPane.add(localTextField);
        contentPane.add(helloButton);
        contentPane.add(goodbyeButton);
        //by reassigning the varialbles
        //staticTextField = null;
        //localTextField = null;

        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
