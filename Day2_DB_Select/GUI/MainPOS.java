package GUI;


import javax.swing.*;
import java.sql.SQLException;

public class MainPOS extends JFrame {
    public POS_pos pos = null;
    public POS_StockManagement stockManagement = null;


    public static void main(String[] args) throws SQLException {

    	MainPOS mainPOS = new MainPOS();
        mainPOS.setTitle("POS�ý���");

        mainPOS.pos = new POS_pos();
        mainPOS.stockManagement = new POS_StockManagement();

        JTabbedPane jtab = new JTabbedPane();

        jtab.add("POS", mainPOS.pos);
        jtab.add("������", mainPOS.stockManagement);

        mainPOS.add(jtab);
        mainPOS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPOS.setSize(550, 400);
        mainPOS.setVisible(true);
    }
}
