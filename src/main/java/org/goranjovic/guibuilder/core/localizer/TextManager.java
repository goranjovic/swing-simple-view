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

package org.goranjovic.guibuilder.core.localizer;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import org.goranjovic.guibuilder.util.VariableTableModel;
import org.goranjovic.guibuilder.util.components.STab;
import org.goranjovic.guibuilder.util.components.STableColumn;

public class TextManager {
	
	public static void setText(Component component, String type, String text){
		
		if (type.equalsIgnoreCase("button")) {
			JButton button = ((JButton)component);
			button.setText(text);
		}
		else if (type.equalsIgnoreCase("panel")){
		}
		else if (type.equalsIgnoreCase("radio")){
			((JRadioButton)component).setText(text);
		}
		else if (type.equalsIgnoreCase("checkbox")){
			((JCheckBox)component).setText(text);
		}
		else if(type.equalsIgnoreCase("group")){
		}
		else if (type.equalsIgnoreCase("label")){
			((JLabel)component).setText(text);
		}
		else if(type.equalsIgnoreCase("textarea")){
		}
		else if(type.equalsIgnoreCase("list")){
		}
		else if(type.equalsIgnoreCase("combo")){
		}
		else if(type.equalsIgnoreCase("table")){
		}
		else if(type.equalsIgnoreCase("form")){
			((JFrame)component).setTitle(text);
		}
		else if(type.equalsIgnoreCase("menu")){
			((JMenu)component).setText(text);
		}
		else if(type.equalsIgnoreCase("menu-item")){
			((JMenuItem)component).setText(text);
		}
		else if(type.equalsIgnoreCase("icon")){
			((JButton)component).setToolTipText(text);
		}
		else if(type.equalsIgnoreCase("tab")){
			((STab)component).setTitle(text);
			if(JTabbedPane.class.isAssignableFrom(component.getParent().getClass())){
				JTabbedPane pane = (JTabbedPane)component.getParent();
				int index = pane.indexOfComponent(component);
				pane.setTitleAt(index, text);
			}
		}else if(type.equalsIgnoreCase("table-column")){
			STableColumn tableColumn = (STableColumn)component;
			tableColumn.setText(text);
			JTable table = tableColumn.getParent();
			VariableTableModel model = (VariableTableModel) table.getModel();
			model.refreshColumnHeaders();			
		}
		
	}
	
	public static String getText(Component component, String type){
		if (type.equalsIgnoreCase("button")) {
			JButton button = ((JButton)component);
			return button.getText();
		}
		else if (type.equalsIgnoreCase("panel")){
		}
		else if (type.equalsIgnoreCase("radio")){
			return ((JRadioButton)component).getText();
		}
		else if (type.equalsIgnoreCase("checkbox")){
			return ((JCheckBox)component).getText();
		}
		else if(type.equalsIgnoreCase("group")){
		}
		else if (type.equalsIgnoreCase("label")){
			return ((JLabel)component).getText();
		}
		else if(type.equalsIgnoreCase("textarea")){
			return ((JTextArea)component).getText();
		}
		else if(type.equalsIgnoreCase("list")){
		}
		else if(type.equalsIgnoreCase("combo")){
		}
		else if(type.equalsIgnoreCase("table")){
		}
		else if(type.equalsIgnoreCase("form")){
			return ((JFrame)component).getTitle();
		}
		else if(type.equalsIgnoreCase("menu")){
			return ((JMenu)component).getText();
		}
		else if(type.equalsIgnoreCase("menu-item")){
			return ((JMenuItem)component).getText();
		}
		else if(type.equalsIgnoreCase("icon")){
			return ((JButton)component).getToolTipText();
		}
		else if(type.equalsIgnoreCase("tab")){
			return ((STab)component).getTitle();
		}
		else if(type.equalsIgnoreCase("table-column")){
			return ((STableColumn)component).getText();
		}
		return null;
	}

}
