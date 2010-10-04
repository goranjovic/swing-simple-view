package org.goranjovic.guibuilder.util;

import java.awt.Container;

import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
                         //fake component
public class TableColumn extends Container{
	
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
		if(! (obj instanceof TableColumn)){
			return false;
		}
		TableColumn other = (TableColumn) obj;
		return getName().equals(other.getName());
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}

}
