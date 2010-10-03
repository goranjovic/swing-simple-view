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

package org.goranjovic.guibuilder.core.factory.creator;

import java.awt.Component;

import org.goranjovic.guibuilder.core.factory.creator.impl.ButtonCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.CheckBoxCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.ComboBoxCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.GroupCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.IconCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.ImageCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.LabelCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.ListCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.MenuBarCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.MenuCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.MenuItemCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.PanelCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.PasswordFieldCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.PopupMenuCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.RadioButtonCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.ScrollCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.TabCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.TabbedPanelCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.TableColumnCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.TableCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.TextAreaCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.TextFieldCreator;
import org.goranjovic.guibuilder.core.factory.creator.impl.ToolBarCreator;
import org.w3c.dom.Element;

public class SmartCreator implements Creator {

	@Override
	public Component create(Element element) {

		String tagName = element.getTagName();
		Creator realCreator = null;
		
		if (tagName.equalsIgnoreCase("textfield")) {
			realCreator = new TextFieldCreator();
		}
		else if (tagName.equalsIgnoreCase("button")) {
			realCreator = new ButtonCreator();
		}
		else if (tagName.equalsIgnoreCase("panel")){
			realCreator = new PanelCreator();
		}
		else if (tagName.equalsIgnoreCase("radio")){
			realCreator = new RadioButtonCreator();
		}
		else if (tagName.equalsIgnoreCase("checkbox")){
			realCreator = new CheckBoxCreator();
		}
		else if(tagName.equalsIgnoreCase("group")){
			realCreator = new GroupCreator();
		}
		else if (tagName.equalsIgnoreCase("label")){
			realCreator = new LabelCreator();
		}
		else if(tagName.equalsIgnoreCase("textarea")){
			realCreator = new TextAreaCreator();
		}
		else if(tagName.equalsIgnoreCase("list")){
			realCreator = new ListCreator();
		}
		else if(tagName.equalsIgnoreCase("combo")){
			realCreator = new ComboBoxCreator();
		}
		else if(tagName.equalsIgnoreCase("table")){
			realCreator = new TableCreator();
		}
		else if(tagName.equalsIgnoreCase("menu-bar")){
			realCreator = new MenuBarCreator();
		}
		else if(tagName.equalsIgnoreCase("menu")){
			realCreator = new MenuCreator();
		}
		else if(tagName.equalsIgnoreCase("menu-item")){
			realCreator = new MenuItemCreator();
		}
		else if(tagName.equalsIgnoreCase("image")){
			realCreator = new ImageCreator();
		}
		else if(tagName.equalsIgnoreCase("passwordfield")){
			realCreator = new PasswordFieldCreator();
		}
		else if(tagName.equalsIgnoreCase("icon")){
			realCreator = new IconCreator();
		}
		else if(tagName.equalsIgnoreCase("scroll")){
			realCreator = new ScrollCreator();
		}
		else if(tagName.equalsIgnoreCase("popup-menu")){
			realCreator = new PopupMenuCreator();
		}
		else if(tagName.equalsIgnoreCase("toolbar")){
			realCreator = new ToolBarCreator();
		}
		else if(tagName.equalsIgnoreCase("tabbed-panel")){
			realCreator = new TabbedPanelCreator();
		}
		else if(tagName.equalsIgnoreCase("tab")){
			realCreator = new TabCreator();
		}else if(tagName.equalsIgnoreCase("table-column")){
			realCreator = new TableColumnCreator();
		}
		//add nullpointer exception checking
		//for unsupported element 
		return realCreator.create(element);
	}

}
