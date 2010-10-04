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

package org.goranjovic.guibuilder.core.style.stylists;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;

import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.style.helpers.CursorParser;
import org.goranjovic.guibuilder.core.style.helpers.UrlParser;

public class ClassificationStylist implements Stylist {
	
	private CursorParser cursorParser = new CursorParser();

	@Override
	public void applyStyle(ElementDescription description, StyleSheet style) {
		
		Component component = description.getComponent();
		String id = description.getId();
		String tagName = description.getTagName();
		
		if(style.findValueForId(id, "cursor")!=null){
			applyCursor(component, style.findValueForId(id, "cursor"));
		}else if(style.findValueForTag(tagName, "cursor")!=null){
			applyCursor(component, style.findValueForTag(tagName, "cursor"));
		}

	}

	private void applyCursor(Component component, String cursorName) {
		
		Cursor cursor = cursorParser.parseCursor(cursorName);
		
		component.setCursor(cursor);
		
	}

	
}
