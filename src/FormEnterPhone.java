import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class FormEnterPhone {
    private JPanel formEnterPhone;
    private JPanel topPanel;
    private JPanel centrPanel;
    private JButton numberPhoneButton;
    private JFormattedTextField numberPhoneField;

    FormEnterPhone () {

    }

    public JPanel getFormEnterPhone() {
        return formEnterPhone;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    private void createUIComponents() {
        try {
            MaskFormatter mf = new MaskFormatter("+7 (###) ###-##-##");
            numberPhoneField = new JFormattedTextField(mf);
            numberPhoneField.setFocusLostBehavior(numberPhoneField.COMMIT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getNumber() {
        try {
            numberPhoneField.commitEdit();
            return numberPhoneField.getValue().toString().replaceAll("\\D", "");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JButton getNumberPhoneButton() {
        return numberPhoneButton;
    }
}
