package Componnet;

import java.awt.Font;
import javax.swing.JTable;

public class MyTable extends JTable {

    public MyTable() {
        setFont(new Font("Phetsarath OT", 0, 12));
        getTableHeader().setFont(new Font("Phetsarath OT", 1, 16));
    }

}
