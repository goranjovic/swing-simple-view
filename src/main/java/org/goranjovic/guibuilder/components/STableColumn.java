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

package org.goranjovic.guibuilder.components;

import java.awt.Container;
import java.beans.PropertyChangeSupport;

import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import org.goranjovic.guibuilder.components.support.VariableTableModel;
                         //fake component
public class STableColumn extends Container  implements SComponent  {
	
	private static final long serialVersionUID = 1492456619097492058L;
	
	private String name;
	private String text;
	private JTable parent;
	private TableCellEditor cellEditor = null;
	
	public TableCellEditor getCellEditor() {
		return cellEditor;
	}
	public void setCellEditor(TableCellEditor cellEditor) {
		this.cellEditor = cellEditor;
	}
	@Override
	public JTable getParent() {
		return parent;
	}
	public void setParent(JTable parent) {
		this.parent = parent;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		JTable table = this.getParent();
		if(table!=null){
			VariableTableModel model = (VariableTableModel) table.getModel();
			model.refreshColumnHeaders();
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof STableColumn)){
			return false;
		}
		STableColumn other = (STableColumn) obj;
		return getName().equals(other.getName());
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		// TODO Auto-generated method stub
		return null;
	}

}
