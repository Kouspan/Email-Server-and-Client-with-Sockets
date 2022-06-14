package me.client.gui;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TableModelWrapper extends DefaultTableModel {

    public TableModelWrapper(){
        super();
        this.addColumn("Read");
        this.addColumn("Sender");
        this.addColumn("Subject");


    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
