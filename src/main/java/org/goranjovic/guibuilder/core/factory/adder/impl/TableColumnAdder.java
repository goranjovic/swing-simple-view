package org.goranjovic.guibuilder.core.factory.adder.impl;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.factory.adder.Adder;
import org.goranjovic.guibuilder.util.TableColumn;
import org.goranjovic.guibuilder.util.VariableTableModel;

public class TableColumnAdder implements Adder {

	@Override
	public void add(ElementDescription parent, ElementDescription child) {
		
		JTable table = (JTable) parent.getComponent();
		TableModel usedModel = table.getModel();
		VariableTableModel model = null;
		if(usedModel instanceof VariableTableModel){
			model = (VariableTableModel) usedModel;
		}else{
			model = new VariableTableModel(table);
			table.setModel(model);
		}
		
		TableColumn column = (TableColumn) child.getComponent();
		model.addColumn(column);
		column.setParent(table);

	}

}
