package GUI;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class POS_pos extends JPanel implements ActionListener {
    private JLabel labelItemName;
    private JLabel labelItemStock;
    private JComboBox comboBoxItem;
    private JTextField jTextFieldStock;
    private JButton buttonItemAdd;
    private JButton buttonPay;
    private JButton buttonCancer;
    private JTable jTableBasket;
    private JLabel labelTotal;
    private JTextField jTextFieldTotal;
    private JButton buttonRefresh;

    public POS_pos() throws SQLException {
        ItemDAO itemdao = ItemDAO.getInstance();

        //콤보박스 세팅
        setLayout(null);
        
        //상품 라벨
        labelItemName = new JLabel("상품");
        labelItemName.setSize(100, 30);
        labelItemName.setLocation(20, 90);

        //상품 콤보박스
        DefaultComboBoxModel combomodel = combo_model_update();

        comboBoxItem = new JComboBox(combomodel);
        comboBoxItem.setSize(200, 30);
        comboBoxItem.setLocation(70, 90);


        //상품 수량
        labelItemStock = new JLabel("수량");
        labelItemStock.setBounds(20, 140, 100, 30);

        //상품 구매수량 텍스트필드
        jTextFieldStock = new JTextField();
        jTextFieldStock.setBounds(70, 140, 200, 30);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("상품명");
        model.addColumn("구매개수");
        model.addColumn("물품가격");
        jTableBasket = new JTable(model);
        jTableBasket.setBounds(300, 20, 210, 210);
        jTableBasket.setEnabled(false);

        //상품 총가격
        labelTotal = new JLabel("총가격");
        labelTotal.setBounds(20, 250, 100, 40);
        jTextFieldTotal = new JTextField();
        jTextFieldTotal.setBounds(70, 250, 200, 40);
        jTextFieldTotal.setEditable(false);

        //장바구니 추가 버튼
        buttonItemAdd = new JButton("추가");
        buttonItemAdd.setBounds(170, 190, 100, 40);
        
        //상품목록 새로고침
        buttonRefresh = new JButton("제품 불러오기");
        buttonRefresh.setBounds(20, 20, 140, 40);
        
        //장바구니 결제 버튼
        buttonPay = new JButton("결제");
        buttonPay.setBounds(300, 250, 100, 40);

        //주문 취소 버튼
        buttonCancer = new JButton("취소");
        buttonCancer.setBounds(410, 250, 100, 40);


        add(labelItemName);
        add(labelItemStock);
        add(comboBoxItem);
        add(jTextFieldStock);
        add(buttonItemAdd);
        add(buttonRefresh);
        add(buttonPay);
        add(buttonCancer);
        add(jTableBasket);
        add(labelTotal);
        add(jTextFieldTotal);
        //추가버튼 리스너
        buttonItemAdd.addActionListener(this);
        buttonRefresh.addActionListener(this);
        buttonCancer.addActionListener(this);
        buttonPay.addActionListener(this);
        //취소버튼

    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        String item = comboBoxItem.getSelectedItem().toString(); //필드에서 아이템 가져오기
        String qty = jTextFieldStock.getText(); //수량가져오기
        String stockprice = ItemDAO.getInstance().getprice(item);//재고상품 가격
        String stock = ItemDAO.getInstance().getStock(item);//상품재고 수량
        DefaultTableModel model = (DefaultTableModel) jTableBasket.getModel();
        DefaultComboBoxModel combomodel = (DefaultComboBoxModel) comboBoxItem.getModel();

        if (obj == buttonItemAdd) {


            int index = model.getRowCount() + 1;
            if (qty.equals("") || item.equals("")) {
                JOptionPane.showMessageDialog(null, "상품이나 수량을 입력해주세요", "경고!!", JOptionPane.WARNING_MESSAGE);
            } else if (Integer.parseInt(qty) > Integer.parseInt(stock)) {
                JOptionPane.showMessageDialog(null, "물품의 수량이 남은 재고수량 보다 많습니다.", "경고!!", JOptionPane.WARNING_MESSAGE);
            } else {
                int price = Integer.parseInt(qty) * Integer.parseInt(stockprice);

                Vector<String> in = makeInVector(new String[]{(String.valueOf(index)), item, qty, String.valueOf(price)});
                int total = 0;
                System.out.println(isCheck(item, model));


                if (!isCheck(item, model)) {
                    JOptionPane.showMessageDialog(null, "이미 선택한 상품입니다.", "경고!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    //중복검사후 jtable에 요소 추가
                    model.addRow(in);
                }

                //장바구니 총합구하기
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Integer.parseInt((String) model.getValueAt(i, 3));
                    jTextFieldTotal.setText(String.valueOf(total));
                }

            }
        } else if (obj == buttonRefresh) { //새로고침 버튼 클릭
            combomodel.removeAllElements();
            try {
                DefaultComboBoxModel defaultComboBoxModel = combo_model_update();
                System.out.println("defalutCombo size = " + defaultComboBoxModel.getSize());
                System.out.println(defaultComboBoxModel.getElementAt(1));
                for (int i = 0; i < defaultComboBoxModel.getSize(); i++) {
                    String a = (String) defaultComboBoxModel.getElementAt(i);
                    combomodel.addElement(a);
                    System.out.println(combomodel.getElementAt(i));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } else if (obj == buttonCancer) {//취소버튼 클릭
            int result;
            result = JOptionPane.showConfirmDialog(null, "주문을 취소하시겠습니까?");
            //예를 눌렀을시
            if (result == 0) {
                clear();
            }
        } else if (obj == buttonPay) { //결제버튼 클릭
            if (jTextFieldTotal.getText().equals("") || jTextFieldTotal.getText().equals(null)) {
                JOptionPane.showMessageDialog(null, "상품을 선택해주세요", "경고!!", JOptionPane.WARNING_MESSAGE);
            } else {
                int total = Integer.parseInt(jTextFieldTotal.getText()); //지불해야할 금액
                int input; //지불한금액
                int res; //거스름돈
                int result;

                result = JOptionPane.showConfirmDialog(null, "결제 하시겠습니까?");
                //예를 눌렀을시
                if (result == 0) {
                    input = Integer.parseInt(JOptionPane.showInputDialog("총 금액은" + total + "입니다.\n얼마를 지불하시겠습니까?"));
                    System.out.println(input);

                    if (input >= total) {
                        res = input - total;
                        JOptionPane.showMessageDialog(null, "지불하신 금액은" + input + "\n 상품의 합계는" + total + "\n 거스름돈은" + res + "입니다");

                        System.out.println(res);
                        stock_update(model);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "결제를 취소하였습니다");

                }

            }
        }
    }

    //String을 vector로 변환
    private Vector<String> makeInVector(String[] array) {
        Vector<String> in = new Vector<>();
        for (String data : array) {
            in.add(data);
        }
        return in;
    }

    //Jtable의 모든 요소 삭제
    private void clear() {
        DefaultTableModel model = (DefaultTableModel) jTableBasket.getModel();
        jTextFieldTotal.setText("");
        jTextFieldStock.setText("");
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

    }

    //중복검사
    private boolean isCheck(String text, DefaultTableModel model) {
        boolean check = true;

        for (int i = 0; i < model.getRowCount(); i++) {
            if (text.equals(model.getValueAt(i, 1))) {
                check = false;
            }
        }
        return check;

    }

    //재고 업데이트
    private void stock_update(DefaultTableModel model) {
        String out_itemname = null;
        String out_itemstock = null;
        String total_stock;

        for (int i = 0; i < model.getRowCount(); i++) {
            out_itemname = (String) model.getValueAt(i, 1);
            out_itemstock = (String) model.getValueAt(i, 2);
            total_stock = ItemDAO.getInstance().getStock(out_itemname);
            ItemDAO.getInstance().updateStock(total_stock, out_itemstock, out_itemname);
        }
        clear();
    }

    //table 업데이트
    private DefaultComboBoxModel combo_model_update() throws SQLException {
        DefaultComboBoxModel combomodel = new DefaultComboBoxModel(ItemDAO.getInstance().getItem());
        return combomodel;
    }
}
