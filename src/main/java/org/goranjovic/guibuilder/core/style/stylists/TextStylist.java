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
import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.localizer.TextManager;
import org.goranjovic.guibuilder.core.style.parsers.ColorParser;

public class TextStylist implements Stylist {

	private ColorParser colorParser = new ColorParser();

	@Override
	public void applyStyle(ElementDescription description, StyleSheet style) {

		if (JComponent.class.isAssignableFrom(description.getComponent()
				.getClass())) {
			JComponent component = (JComponent) description.getComponent();
			String id = description.getId();
			String tagName = description.getTagName();
			
			if(style.findValueForId(id, "color")!=null){
				applyColor(component, style.findValueForId(id, "color"));
			}else if(style.findValueForTag(tagName, "color")!=null){
				applyColor(component, style.findValueForTag(tagName, "color"));
			}
			
			if(style.findValueForId(id, "text-align")!=null){
				applyTextAlign(component, style.findValueForId(id, "text-align"));
			}else if(style.findValueForTag(tagName, "text-align")!=null){
				applyTextAlign(component, style.findValueForTag(tagName, "text-align"));
			}
			
			if(style.findValueForId(id, "text-transform")!=null){
				applyTextTransform(component, style.findValueForId(id, "text-transform"), tagName);
			}else if(style.findValueForTag(tagName, "text-transform")!=null){
				applyTextTransform(component, style.findValueForTag(tagName, "text-transform"), tagName);
			}
		}

	}
	
	private void applyColor(JComponent component, String colorString){
		Color color = component.getForeground();
		// coloring text
		color = colorParser.parseColor(colorString);
		component.setForeground(color);
	}
	
	private void applyTextAlign(JComponent component, String textAlign){
		if (JTextField.class.isAssignableFrom(component.getClass())) {
			// for textfield
			JTextField field = (JTextField) component;
			if (textAlign.equalsIgnoreCase("left")) {
				field.setHorizontalAlignment(JTextField.LEFT);
			} else if (textAlign.equalsIgnoreCase("right")) {
				field.setHorizontalAlignment(JTextField.RIGHT);
			} else if (textAlign.equalsIgnoreCase("center")) {
				field.setHorizontalAlignment(JTextField.CENTER);
			}
		}
		if (JLabel.class.isAssignableFrom(component.getClass())) {
			// for label
			JLabel label = (JLabel) component;
			if (textAlign.equalsIgnoreCase("left")) {
				label.setHorizontalAlignment(JLabel.LEFT);
			} else if (textAlign.equalsIgnoreCase("right")) {
				label.setHorizontalAlignment(JLabel.RIGHT);
			} else if (textAlign.equalsIgnoreCase("center")) {
				label.setHorizontalAlignment(JLabel.CENTER);
			}

		}
		if (AbstractButton.class.isAssignableFrom(component.getClass())) {
			// for button, radio, checkbox
			AbstractButton b = (AbstractButton) component;
			if (textAlign.equalsIgnoreCase("left")) {
				b.setHorizontalAlignment(JLabel.LEFT);
			} else if (textAlign.equalsIgnoreCase("right")) {
				b.setHorizontalAlignment(JLabel.RIGHT);
			} else if (textAlign.equalsIgnoreCase("center")) {
				b.setHorizontalAlignment(JLabel.CENTER);
			}
		}
		
		if(textAlign.equalsIgnoreCase("justify")){
			Font font = createOrGetFont(component);
			Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
			map.put(TextAttribute.JUSTIFICATION, TextAttribute.JUSTIFICATION_FULL);
			font = font.deriveFont(map);
			component.setFont(font);
		}
	}
	
	private void applyTextTransform(JComponent component, String textTransform, String tagName){
		TextManager manager = new TextManager();
		String text = manager.getText(component, tagName);
		if (textTransform.equalsIgnoreCase("uppercase")) {
			text = text.toUpperCase();
		} else if (textTransform.equalsIgnoreCase("lowercase")) {
			text = text.toLowerCase();
		} else if (textTransform.equalsIgnoreCase("capitalize")) {
			
			StringBuffer sb = new StringBuffer(text.substring(0, 1)
					+ text.substring(1).toLowerCase());
			for (int i = 1; i < text.length() - 1; i++) {
				if (sb.charAt(i - 1) == ' ') {
					sb.setCharAt(i, text.substring(i, i + 1)
							.toUpperCase().charAt(0));
				}
			}
			text = sb.toString();

		}
		manager.setText(component, tagName, text);
	}
	private Font createOrGetFont(Component component) {
		Font font = component.getFont();
		if(font==null){
			font = new Font("arial", Font.PLAIN, 12);
		}
		return font;
	}

}
