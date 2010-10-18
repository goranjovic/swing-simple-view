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

package org.goranjovic.guibuilder.core.style.stylists;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.style.parsers.ColorParser;

public class BorderStylist implements Stylist {
	
	private ColorParser colorParser = new ColorParser();

	@Override
	public void applyStyle(ElementDescription description, StyleSheet style) {
		
		if (JComponent.class.isAssignableFrom(description.getComponent().getClass())) {
			
			JComponent component = (JComponent) description.getComponent();
			String id = description.getId();
			String tagName = description.getTagName();
			String borderColorString = "black";
			
			String borderColorFromStyle = style.findValue(id, tagName, "border-color");
			if(borderColorFromStyle != null){
				borderColorString = borderColorFromStyle;
			}
			Color borderColor = colorParser.parseColor(borderColorString);
			
			int borderWidth = 3;
			
			String borderWidthString = style.findValue(id, tagName, "border-width");
			if (borderWidthString != null) {
				borderWidth = parseBorderWidth(borderWidthString);
			} 
			
			
			if(borderWidth == -1) borderWidth = 3;
			
			String borderStyle = style.findValue(id, tagName, "border-style");
			if (borderStyle != null) {
				applyBorderStyle(component, borderStyle, borderColor, borderWidth);
			} 
		}

	}

	private int parseBorderWidth(String borderWidthString) {

		if(borderWidthString.equalsIgnoreCase("thin")){
			return 1;
		}
		if(borderWidthString.equalsIgnoreCase("medium")){
			return 3;
		}
		if(borderWidthString.equalsIgnoreCase("thick")){
			return 5;
		}
		borderWidthString = borderWidthString.replaceAll("px", "");
		return Integer.parseInt(borderWidthString);
	}

	private void applyBorderStyle(JComponent component, String borderStyle, Color borderColor, int borderWidth) {
		
		Border border = BorderFactory.createEmptyBorder();

		if(borderStyle.equalsIgnoreCase("solid")){
			border = BorderFactory.createLineBorder(borderColor, borderWidth);
		}else if(borderStyle.equalsIgnoreCase("groove")){
			border = BorderFactory.createEtchedBorder(borderColor, borderColor.darker().darker());
		}else if(borderStyle.equalsIgnoreCase("ridge")){
			border = BorderFactory.createEtchedBorder(borderColor, borderColor.brighter().brighter());
		}else if(borderStyle.equalsIgnoreCase("inset")){
			border = BorderFactory.createLoweredBevelBorder();
		}else if(borderStyle.equalsIgnoreCase("outset")){
			border = BorderFactory.createRaisedBevelBorder();
		}else if(borderStyle.equalsIgnoreCase("double")){
			Border in = BorderFactory.createLineBorder(borderColor, borderWidth);
			Border out = BorderFactory.createLineBorder(borderColor, borderWidth);
			border = BorderFactory.createCompoundBorder(out, in);
		}

		component.setBorder(border);


		
	}

}
