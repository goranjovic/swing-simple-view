package org.goranjovic.guibuilder.core.factory.adder.impl;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.factory.adder.Adder;
import org.goranjovic.guibuilder.util.TableColumn;

public class CellEditorAdder implements Adder {

	@Override
	public void add(ElementDescription parent, ElementDescription child) {
		
		TableColumn column = (TableColumn) parent.getComponent();
		Component editor = child.getComponent();
		
		column.add(editor);
		
		DefaultCellEditor cellEditor = null;
		String childTagName = child.getTagName();
		if(childTagName.equals("textfield")){
			cellEditor = new DefaultCellEditor((JTextField) editor);
		}else if(childTagName.equalsIgnoreCase("combo")){
			cellEditor = new DefaultCellEditor((JComboBox) editor);
		}else if(childTagName.equalsIgnoreCase("checkbox")){
			cellEditor = new DefaultCellEditor((JCheckBox) editor);
		}
		column.setCellEditor(cellEditor);

	}

}
