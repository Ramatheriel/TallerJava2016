/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author administrador1
 */
public class GridModel extends AbstractTableModel{
    String[][] data = {{"ariel","ariel"},{"ariel","ariel"}};
    public GridModel() {
        
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0)
        {
            return "nombre";
        }
        else
        {
            return "apellido";
        }
    }

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
}