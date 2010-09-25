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
import org.goranjovic.guibuilder.core.style.helpers.UrlParser;

public class ClassificationStylist implements Stylist {

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
		
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		
		if(cursorName.equalsIgnoreCase("crosshair")){
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		}else if(cursorName.equalsIgnoreCase("default")){
			cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		}else if(cursorName.equalsIgnoreCase("pointer")){
			cursor = new Cursor(Cursor.HAND_CURSOR);
		}else if(cursorName.equalsIgnoreCase("move")){
			cursor = new Cursor(Cursor.MOVE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("e-resize")){
			cursor = new Cursor(Cursor.E_RESIZE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("ne-resize")){
			cursor = new Cursor(Cursor.NE_RESIZE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("nw-resize")){
			cursor = new Cursor(Cursor.NW_RESIZE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("n-resize")){
			cursor = new Cursor(Cursor.N_RESIZE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("se-resize")){
			cursor = new Cursor(Cursor.SE_RESIZE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("sw-resize")){
			cursor = new Cursor(Cursor.SW_RESIZE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("s-resize")){
			cursor = new Cursor(Cursor.S_RESIZE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("w-resize")){
			cursor = new Cursor(Cursor.W_RESIZE_CURSOR);
		}else if(cursorName.equalsIgnoreCase("text")){
			cursor = new Cursor(Cursor.TEXT_CURSOR);
		}else if(cursorName.equalsIgnoreCase("wait")){
			cursor = new Cursor(Cursor.WAIT_CURSOR);
		}else if(cursorName.startsWith("url")){
			UrlParser parser = new UrlParser();
			URL url = parser.parseURL(cursorName);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image image = toolkit.createImage(url);
			cursor = toolkit.createCustomCursor(image, new Point(0,0), url.getFile());
			
		}
		
		component.setCursor(cursor);
		
	}

}
