import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SimpleGUI extends JFrame {
    private String[] allCharCodes = new String[]{"AUD", "AZN", "GBP", "AMD", "BYN", "BGN",
            "BRL", "HUF", "HKD", "DKK", "USD", "EUR", "INR",
            "KZT", "CAD", "KGS", "CNY", "MDL", "NOK", "PLN",
            "RON", "XDR", "SGD", "TJS", "TRY", "TMT", "UZS",
            "UAH", "CZK", "SEK", "CHF", "ZAR", "KRW", "JPY"};

    private String  help = "";
    private int numberOfBank = 1;

    private JButton switchBankButton = new JButton("Choosing a Bank");
    private JButton calculateButton = new JButton("Calculate");
    private JButton helpButton = new JButton("Help");
    private JTextField fromValuteField = new JTextField("USD", 5);
    private JTextField toValuteField = new JTextField("RUB", 5);
    private JTextField countField = new JTextField("100", 5);
    private JLabel fromValuteLabel = new JLabel("                     From:");
    private JLabel voidLabel1 = new JLabel("");
    private JLabel bankLabel = new JLabel("   Russian Cenral Bank");
    private JLabel voidLabel3 = new JLabel("");
    private JLabel toValuteLabel = new JLabel("                         To:");
    private JLabel countLabel = new JLabel("                   Count:");
    //private JRadioButton radio1 = new JRadioButton("Select this");
  //  private JRadioButton radio2 = new JRadioButton("Select that");
   // private JCheckBox check = new JCheckBox("Check", false);


    public SimpleGUI() {
        super("Currency Converter");
        this.setBounds(100,100,600,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,4,2,2));
        container.add(fromValuteLabel);
        container.add(fromValuteField);
        container.add(toValuteLabel);
        container.add(toValuteField);
        container.add(countLabel);
        container.add(countField);
        container.add(voidLabel1);
        container.add(voidLabel3);


        ButtonGroup group = new ButtonGroup();
        helpButton.addActionListener(new ButtonHelpListner());
        container.add(helpButton);
        switchBankButton.addActionListener(new ButtonSwitchListner());
        container.add(switchBankButton);
        container.add(bankLabel);
        calculateButton.addActionListener(new ButtonEventListener());
        container.add(calculateButton);

    }

    class ButtonSwitchListner implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.yesButtonText", "Russian Central Bank");
            UIManager.put("OptionPane.noButtonText", "Europian Central Bank");
            int reply = JOptionPane.showConfirmDialog(null, "Which bank to use?", "Title", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
                numberOfBank = 1;
                bankLabel.setText("   Russian Cenral Bank");
            }else{
                numberOfBank = 2;
                bankLabel.setText("  Europian Cenral Bank");
            }
        }
    }



    class ButtonHelpListner implements  ActionListener{
        public void actionPerformed(ActionEvent e){
            Converter conv = new Converter("RUB","RUB",0,1);
            for (String allCharCode : allCharCodes) {
                String charCode = conv.itemStore.get(allCharCode).charCode;
                String name = conv.itemStore.get(allCharCode).name;
                help += charCode;
                help += " = ";
                help += name;
                help += "\n";
            }
            String message = help;
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String from = fromValuteField.getText();
            String to = toValuteField.getText();
            int count = Integer.parseInt(countField.getText());
            Converter converter = new Converter(from,to,count,numberOfBank);
            String message = "";
            message += converter.getResult(numberOfBank);
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
