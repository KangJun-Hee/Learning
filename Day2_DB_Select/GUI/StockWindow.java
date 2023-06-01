package GUI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StockWindow extends JFrame implements ActionListener {
	JLabel labelId = new JLabel("     id");
    JLabel labelname = new JLabel("     상품명");
    JLabel labelStock = new JLabel("     재고");
    JLabel labelPrice = new JLabel("     가격");
    JTextField textFieldlId = new JTextField(10);
    JTextField textFieldname = new JTextField(10);
    JTextField textFieldStock = new JTextField(10);
    JTextField textFieldPrice = new JTextField(10);
    JButton buttonaccept = new JButton("");
    Item item;
    String text;

    public StockWindow(String text) {
        super(text);
        this.text = text;
        display();
        setSize(300, 300);
        setVisible(true);
    }

    public StockWindow(String text, Item item) {
        super(text);
        this.item = item;
        this.text = text;
        display();
        setSize(300, 300);
        setVisible(true);
    }

    public void display() {
        Container c = getContentPane();
        JPanel p = new JPanel(new GridLayout(4, 2));
        buttonaccept.setText(text);
        textFieldlId.setEditable(false);

        // item bean이 null이 아닐경우
        if (item != null) {
            textFieldlId.setText(String.valueOf(item.getId()));
            textFieldname.setText(item.getItem_name());
            textFieldStock.setText(String.valueOf(item.getItem_stock()));
            textFieldPrice.setText(String.valueOf(item.getItem_price()));
        }
        c.add(p, BorderLayout.CENTER);
        c.add(buttonaccept, BorderLayout.SOUTH);

        p.add(labelId);
        p.add(textFieldlId);

        p.add(labelname);
        p.add(textFieldname);

        p.add(labelStock);
        p.add(textFieldStock);

        p.add(labelPrice);
        p.add(textFieldPrice);

        c.add(p, BorderLayout.CENTER);
        c.add(buttonaccept, BorderLayout.SOUTH);

        buttonaccept.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String state = buttonaccept.getText();
        String id;
        String name;
        String stock;
        String price;
        boolean result;

        switch (state) {
            case "등록":

                name = textFieldname.getText();
                stock = textFieldStock.getText();
                price = textFieldPrice.getText();
                Item register = new Item();
                register.setItem_name(name);
                register.setItem_stock(Integer.parseInt(stock));
                register.setItem_price(Integer.parseInt(price));

                result = ItemDAO.getInstance().insertStock(register);

                System.out.println("Window = " + result);
                break;
            case "수정":
                id = textFieldlId.getText();
                name = textFieldname.getText();
                stock = textFieldStock.getText();
                price = textFieldPrice.getText();

                item.setId(Integer.parseInt(id));
                item.setItem_name(name);
                item.setItem_stock(Integer.parseInt(stock));
                item.setItem_price(Integer.parseInt(price));

                result = ItemDAO.getInstance().updateitem(item);
                if (result) {
                    JOptionPane.showMessageDialog(null, "수정에 성공하였습니다", "성공", JOptionPane.INFORMATION_MESSAGE);

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "수정에 실패하였습니다 입력된 값을 확인 하세요", "경고!!", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "삭제":
                id = textFieldlId.getText();
                name = textFieldname.getText();
                stock = textFieldStock.getText();
                price = textFieldPrice.getText();

                item.setId(Integer.parseInt(id));
                item.setItem_name(name);
                item.setItem_stock(Integer.parseInt(stock));
                item.setItem_price(Integer.parseInt(price));


                int res;

                res = JOptionPane.showConfirmDialog(null, "선택한 상품명 " + name + "을 데이터베이스에서 삭제하시겠습니까?");
                //예를 눌렀을시
                if (res == 0) {
                    ItemDAO.getInstance().DeleteItem(Integer.parseInt(id));
                    dispose();
                    JOptionPane.showMessageDialog(null, "삭제하려는 " + name + "을 \n삭제하였습니다.");

                } else {
                    JOptionPane.showMessageDialog(null, "삭제를 취소하였습니다");

                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }
}
