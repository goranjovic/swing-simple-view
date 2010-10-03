package org.goranjovic.guibuilder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VariableTableModel extends DefaultTableModel {
	
	private List<List<Object>> rows = new ArrayList<List<Object>>();;
	private List<TableColumn> columns = new ArrayList<TableColumn>();
	private JTable table;
	
	public VariableTableModel(JTable table){
		this.table = table;
	}

	@Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public int getRowCount() {
    	if(rows == null){
    		return 0;
    	}
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
          return rows.get(row).get(column);
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
    	rows.get(row).set(column, value);
    }

    public List<List<Object>> getRows() {
		return rows;
	}

	public List<TableColumn> getColumns() {
		return columns;
	}

	@Override
    public void removeRow(int row) {
        rows.remove(row);
        fireTableDataChanged();
    }
	
	public void addRow(List<Object> added){
		rows.add(added);
		fireTableDataChanged();
	}
	
	public void addColumn(TableColumn column){
		columns.add(column);
		refreshColumnHeaders();
	}

	public void refreshColumnHeaders() {
		setColumnIdentifiers(new Vector<TableColumn>(columns));
		for(TableColumn column : columns){
			if(column.getCellEditor() != null){
				int index = this.getColumns().indexOf(column);
				javax.swing.table.TableColumn swingColumn = 
					table.getColumnModel().getColumn(index);
				swingColumn.setCellEditor(column.getCellEditor());
			}
		}
	}
	
	
	@Override
    public String getColumnName(int column) {
		return columns.get(column).getText();
    }
	

}
