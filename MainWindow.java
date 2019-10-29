import javax.swing.*;
import java.awt.*; // FlowLayout

// tested
public class MainWindow extends JFrame {

    // widgets
    JButton button;

    // menus
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem downloadBracketItem;
    JMenuItem convertHTMLToDbItem;
    JMenuItem loadBracketItem;
    JMenu editMenu;
    JMenuItem preferencesItem;
    JMenu predictionsMenu;
    JMenuItem savePredictionsItem;
    JMenuItem loadPredictionsItem;

    MainWindow() {
        super(); // invoke parent constructor

        // widgets
        this.button = new JButton("Click");
        this.button.setBounds(130, 100, 100, 100); // x, y, width, height
        this.add(button);

        // menu items
        this.downloadBracketItem = new JMenuItem();
        this.downloadBracketItem.setText("Download Bracket");
        this.convertHTMLToDbItem = new JMenuItem();
        this.convertHTMLToDbItem.setText("Convert HTML to DB");
        this.loadBracketItem = new JMenuItem();
        this.loadBracketItem.setText("Load Bracket");
        this.preferencesItem = new JMenuItem();
        this.preferencesItem.setText("Preferences");
        this.savePredictionsItem = new JMenuItem();
        this.savePredictionsItem.setText("Save Predictions");
        this.loadPredictionsItem = new JMenuItem();
        this.loadPredictionsItem.setText("Load Predictions");

        // event handlers
        this.downloadBracketItem.addActionListener((event) -> this.onDownloadBracket());
        this.convertHTMLToDbItem.addActionListener((event) -> this.onConvertHTMLToDb());
        this.loadBracketItem.addActionListener((event) -> this.onLoadBracket());
        this.preferencesItem.addActionListener((event) -> this.onPreferences());
        this.savePredictionsItem.addActionListener((event) -> this.onSavePredictions());
        this.loadPredictionsItem.addActionListener((event) -> this.onLoadPredictions());

        // menus
        this.fileMenu = new JMenu();
        this.fileMenu.setText("File");
        this.fileMenu.add(this.downloadBracketItem);
        this.fileMenu.add(this.convertHTMLToDbItem);
        this.fileMenu.add(this.loadBracketItem);
        this.editMenu = new JMenu();
        this.editMenu.setText("Edit");
        this.editMenu.add(this.preferencesItem);
        this.predictionsMenu = new JMenu();
        this.predictionsMenu.setText("Predictions");
        this.predictionsMenu.add(this.savePredictionsItem);
        this.predictionsMenu.add(this.loadPredictionsItem);

        // menu bar
        this.menuBar = new JMenuBar();
        this.menuBar.add(this.fileMenu);
        this.menuBar.add(this.editMenu);
        this.menuBar.add(this.predictionsMenu);
        
        // frame
        ImageIcon logo = new ImageIcon("images/icon.png");
        this.setIconImage(logo.getImage());
        this.setSize(400,500);
        this.setLayout(null);
        this.setTitle("Fantasy Tennis");
        this.setJMenuBar(this.menuBar);
    }

    // tested
    void onDownloadBracket() {
        DownloadDialog.downloadArchive(2019, "out");
        String[] downloadOptions = DownloadDialog.getDownloadOptions("tmp");
        DownloadDialog dialog = new DownloadDialog(downloadOptions, "out.html");
        dialog.setVisible(true);
    }
    
    // not tested
    void onConvertHTMLToDb() {
        ConvertHTMLDialog dialog = new ConvertHTMLDialog();
        dialog.setVisible(true);
    }

    // tested
    void onLoadBracket() {
        LoadBracketDialog dialog = new LoadBracketDialog();
        dialog.setVisible(true);
    }

    // not tested
    void onPreferences() {
        PreferencesDialog dialog = new PreferencesDialog();
        dialog.setVisible(true);
    }

    // not tested
    void onSavePredictions() {
        SavePredictionsDialog dialog = new SavePredictionsDialog("out.db");
        dialog.setVisible(true);
    }

    // tested
    void onLoadPredictions() {
        LoadPredictionsDialog dialog = new LoadPredictionsDialog();
        dialog.setVisible(true);
    }

    public static void main(String[] args) {        
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}