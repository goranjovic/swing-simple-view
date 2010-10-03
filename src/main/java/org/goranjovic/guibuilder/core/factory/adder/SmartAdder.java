/*SwingGuiBuilder - a Simple View implementation for Swing
Copyright (C) 2009. Goran Jovic

This file is part of SwingGuiBuilder.

SwingGuiBuilder is free software: you can redistribute it and/or modify
it under the terms of the Lesser GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SwingGuiBuilder is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the Lesser GNU General Public License
along with SwingGuiBuilder.  If not, see <http://www.gnu.org/licenses/>.*/

package org.goranjovic.guibuilder.core.factory.adder;

import javax.swing.JMenuBar;

import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.factory.adder.Adder;
import org.goranjovic.guibuilder.core.factory.adder.impl.CellEditorAdder;
import org.goranjovic.guibuilder.core.factory.adder.impl.DefaultAdder;
import org.goranjovic.guibuilder.core.factory.adder.impl.MenuBarAdder;
import org.goranjovic.guibuilder.core.factory.adder.impl.PopupMenuAdder;
import org.goranjovic.guibuilder.core.factory.adder.impl.ScrollAdder;
import org.goranjovic.guibuilder.core.factory.adder.impl.TabAdder;
import org.goranjovic.guibuilder.core.factory.adder.impl.TableColumnAdder;

public class SmartAdder implements Adder {

	@Override
	public void add(ElementDescription parent, ElementDescription child) {
		
		Adder realAdder = new DefaultAdder();
		String tagName = child.getTagName();
		
		if (tagName.equalsIgnoreCase("menu-bar")) {
			realAdder = new MenuBarAdder();
		}else if(parent.getTagName().equalsIgnoreCase("scroll")){
			realAdder = new ScrollAdder();
		}else if(parent.getTagName().equalsIgnoreCase("tabbed-panel")){
			if(tagName.equalsIgnoreCase("tab")){
				realAdder = new TabAdder();
			}
		}else if(tagName.equalsIgnoreCase("popup-menu")){
			realAdder = new PopupMenuAdder();
		}else if(parent.getTagName().equalsIgnoreCase("table")){
			if(tagName.equalsIgnoreCase("table-column")){
				realAdder = new TableColumnAdder();
			}
		}else if(parent.getTagName().equalsIgnoreCase("table-column")){
			if(tagName.equalsIgnoreCase("textfield")
		       || tagName.equalsIgnoreCase("checkbox")
		       || tagName.equalsIgnoreCase("combo")){
				realAdder = new CellEditorAdder();
			}
		}
		
		realAdder.add(parent, child);

	}

}
