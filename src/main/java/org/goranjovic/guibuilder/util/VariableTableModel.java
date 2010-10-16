/*swing-simple-view - a Simple View implementation for Swing
Copyright (C) 2009. Goran Jovic

This file is part of swing-simple-view.

swing-simple-view is free software: you can redistribute it and/or modify
it under the terms of the Lesser GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

swing-simple-view is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the Lesser GNU General Public License
along with swing-simple-view.  If not, see <http://www.gnu.org/licenses/>.*/

package org.goranjovic.guibuilder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.goranjovic.guibuilder.util.components.STableColumn;

public class VariableTableModel extends DefaultTableModel {
	

	private static final long serialVersionUID = -4861592506629156977L;
	
	private List<List<Object>> rows = new ArrayList<List<Object>>();
	private List<STableColumn> columns = new ArrayList<STableColumn>();
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

	public List<STableColumn> getColumns() {
		return columns;
	}

	@Override
    public void removeRow(int row) {
        rows.remove(row);
        fireTableDataChanged();
    }
	
	public void addRow(List<Object> row){
		rows.add(row);
		fireTableDataChanged();
	}
	
	
	
	public void addColumn(STableColumn column){
		columns.add(column);
		refreshColumnHeaders();
	}

	public void refreshColumnHeaders() {
		setColumnIdentifiers(new Vector<STableColumn>(columns));
		for(STableColumn column : columns){
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
