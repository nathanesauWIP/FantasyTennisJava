import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// tested
public class LoadBracketDialog extends JFrame {

    JLabel fileLabel;
    JComboBox fileComboBox;
    JButton okButton;
    FlowLayout mainLayout;

    LoadBracketDialog() {
        super(); // invoke parent constructor

        // widgets
        this.fileLabel = new JLabel();
        this.fileLabel.setText("Select bracket to load");
        String[] cbItems = LoadBracketDialog.getFileComboBoxItems();
        this.fileComboBox = new JComboBox(cbItems);
        this.okButton = new JButton();
        this.okButton.setText("OK");

        // layout
        this.mainLayout = new FlowLayout();
        this.setLayout(this.mainLayout);
        this.add(this.fileLabel);
        this.add(this.fileComboBox);
        this.add(this.okButton);

        // event listeners
        this.okButton.addActionListener((event) -> this.onOKButtonPressed());

        // frame
        ImageIcon logo = new ImageIcon("images/icon.png");
        this.setIconImage(logo.getImage());
        this.setTitle("Select Bracket");
        this.setSize(400, 500);
    }

    void onOKButtonPressed() {
        // todo: load bracket
        JOptionPane.showMessageDialog(this, "Bracket has been loaded");
    }

    static String[] getFileComboBoxItems() {
        // todo: walk through root, directories, files in data directory to fill cbItems
        String[] cbItems = {"us_open.db", "french_open.db", "rogers_cup.db"};
        return cbItems;
    }
}