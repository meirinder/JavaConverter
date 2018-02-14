import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Calculate");
    private JTextField fromValuteField = new JTextField("USD", 5);
    private JTextField toValuteField = new JTextField("RUR", 5);
    private JTextField countField = new JTextField("100", 5);
    private JLabel fromValuteLabel = new JLabel("From:");
    private JLabel voidLabel1 = new JLabel("");
    private JLabel voidLabel2 = new JLabel("");
    private JLabel toValuteLabel = new JLabel("To");
    private JLabel countLabel = new JLabel("Count");
//    private JRadioButton radio1 = new JRadioButton("Select this");
//    private JRadioButton radio2 = new JRadioButton("Select that");
//    private JCheckBox check = new JCheckBox("Check", false);

    public SimpleGUI() {
        super("Currency Converter");
        this.setBounds(100,100,500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(fromValuteLabel);
        container.add(fromValuteField);
        container.add(voidLabel1);
        container.add(toValuteLabel);
        container.add(toValuteField);
        container.add(voidLabel2);
        container.add(countLabel);
        container.add(countField);



        ButtonGroup group = new ButtonGroup();
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String from = fromValuteField.getText();
            String to = toValuteField.getText();
            int count = Integer.parseInt(countField.getText());
            Converter converter = new Converter(from,to,count);
            String message = "";
            message += converter.getResult();
           // message += "Text is " + input.getText() + "\n";
//            message += (radio1.isSelected()?"Radio #1":"Radio #2")
//                    + " is selected\n";
//            message += "CheckBox is " + ((check.isSelected())
//                    ?"checked":"unchecked");
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }


}
