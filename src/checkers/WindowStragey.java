package checkers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowStragey extends JDialog implements PlayerStrategy {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea boardArea;
    private JTextField rowTF;
    private JTextField colTF;
    private JButton moveBtn;
    private JLabel orderLabel;

    public WindowStragey() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        moveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = Integer.parseInt(rowTF.getText());
                int c = Integer.parseInt(colTF.getText());
                if (mm != null) {
                    //mm.makeMove(new Point(r, c));
                    mm = null;
                    orderLabel.setText("----");
                }

            }
        });
    }

    public static void main(String[] args) {
        WindowStragey dialog = new WindowStragey();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private MoveMaker mm = null;
    @Override
    public void makeMove(PlayerBoard pb, MoveMaker mm) {
        String s = "";
        for (int i = 0; i < pb.getHeight(); i++) {
            for (int j = 0; j < pb.getWidth(); j++) {
                Cell c = pb.getCell(j, i);
                if (Cell.EMPTY.equals(c)) {
                    s += ".";
                } else if (Cell.ALLY.equals(c)) {
                    s += "M";
                } else {
                    s += "O";
                }
            }
            s += "\n";
        }
        boardArea.setText(s);
        this.mm = mm;
        orderLabel.setText("You");
    }
    public static final Factory STRATEGY = new Factory() {
        @Override
        public PlayerStrategy create() {
            WindowStragey dialog = new WindowStragey();
            dialog.pack();
            dialog.setVisible(true);
            return dialog;
        }
    };
}
