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
