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

import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.guibuilder.core.ElementDescription;

public class FontStylist implements Stylist {

	@Override
	public void applyStyle(ElementDescription description, StyleSheet style) {
		
		Component component = description.getComponent();
		String id = description.getId();
		String tagName = description.getTagName();
		
		String fontFamily = style.findValue(id, tagName, "font-family");
		if(fontFamily!=null){
			applyFontFamily(component, fontFamily);
		}
		
		String fontSize = style.findValue(id, tagName, "font-size");
		if(fontSize!=null){
			applyFontSize(description, fontSize);
		}
		
		String fontStyle = style.findValue(id, tagName, "font-style");
		if(fontStyle!=null){
			applyFontStyle(component, fontStyle);
		}
		
		String fontWeight = style.findValue(id, tagName, "font-weight");
		if(fontWeight!=null){
			applyFontWeight(component, fontWeight);
		}
		
		String textDecoration = style.findValue(id, tagName, "text-decoration");
		if(textDecoration!=null){
			applyTextDecoration(component, textDecoration);
		}
		
		String direction = style.findValue(id, tagName, "direction");
		if(direction!=null){
			applyDirection(component, direction);
		}
		
		String fontStretch = style.findValue(id, tagName, "font-stretch");
		if(fontStretch!=null){
			applyFontStretch(component, fontStretch);
		}
	}
	
	private void applyFontFamily(Component component, String fontFamily){

		Font font = new Font(fontFamily, Font.PLAIN, 12);
		component.setFont(font);	
	}
	
	private void applyFontSize(ElementDescription description, String fontSize){
		
		Component component = description.getComponent();
		Font font = createOrGetFont(component);
		
		
		float size = parseFontSize(fontSize);


		if (size!=0) {
			font = font.deriveFont(size);
			component.setFont(font);
		}
		
	}

	private float parseFontSize(String fontSize) {
		
		float size = 0;
		
		if(fontSize.equalsIgnoreCase("xx-small")){
			size = 9;
		}else if(fontSize.equalsIgnoreCase("x-small")){
			size = 10;
		}else if(fontSize.equalsIgnoreCase("small")){
			size = 13;
		}else if(fontSize.equalsIgnoreCase("medium")){
			size = 16;
		}else if(fontSize.equalsIgnoreCase("large")){
			size = 18;
		}else if(fontSize.equalsIgnoreCase("x-large")){
			size = 24;
		}else if(fontSize.equalsIgnoreCase("xx-large")){
			size = 32;
		}else if(fontSize.endsWith("%")){
			//to-do
		}else if(fontSize.equalsIgnoreCase("larger")){
			//to-do
		}else if(fontSize.equalsIgnoreCase("smaller")){
			//to-do
		}else{
			if(fontSize.endsWith("px")){
				fontSize = fontSize.replaceAll("px", "");
			}
			size = Float.parseFloat(fontSize);
		}
		return size;
	}

	private Font createOrGetFont(Component component) {
		Font font = component.getFont();
		if(font==null){
			font = new Font("arial", Font.PLAIN, 12);
		}
		return font;
	}
	
	private void applyFontStyle(Component component, String fontStyle){
		Font font = createOrGetFont(component);
		if(fontStyle.equalsIgnoreCase("italic")){
			font = font.deriveFont(Font.ITALIC+font.getStyle());
		}
		if(fontStyle.equalsIgnoreCase("oblique")){
			Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
			map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
			font = font.deriveFont(map);
		}
		component.setFont(font);
	}
	
	private void applyFontWeight(Component component, String fontWeight){
		Font font = createOrGetFont(component);
		Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
		Float weight = TextAttribute.WEIGHT_REGULAR;
		
		if(fontWeight.equalsIgnoreCase("bold")){
			weight = TextAttribute.WEIGHT_BOLD;
		}else if(fontWeight.equalsIgnoreCase("normal")){
			weight = TextAttribute.WEIGHT_REGULAR;
		}		
		else if(fontWeight.equalsIgnoreCase("100")){
			weight = TextAttribute.WEIGHT_EXTRA_LIGHT;
		}
		else if(fontWeight.equalsIgnoreCase("200")){
			weight = TextAttribute.WEIGHT_LIGHT;
		}
		else if(fontWeight.equalsIgnoreCase("300")){
			weight = TextAttribute.WEIGHT_REGULAR;
		}
		else if(fontWeight.equalsIgnoreCase("400")){
			weight = TextAttribute.WEIGHT_SEMIBOLD;
		}
		else if(fontWeight.equalsIgnoreCase("500")){
			weight = TextAttribute.WEIGHT_MEDIUM;
		}
		else if(fontWeight.equalsIgnoreCase("600")){
			weight = TextAttribute.WEIGHT_DEMIBOLD;
		}
		else if(fontWeight.equalsIgnoreCase("700")){
			weight = TextAttribute.WEIGHT_BOLD;
		}
		else if(fontWeight.equalsIgnoreCase("800")){
			weight = TextAttribute.WEIGHT_HEAVY;
		}
		else if(fontWeight.equalsIgnoreCase("900")){
			weight = TextAttribute.WEIGHT_EXTRABOLD;
		}
		map.put(TextAttribute.WEIGHT, weight);
		font = font.deriveFont(map);
		component.setFont(font);
	}
	
	private void applyTextDecoration(Component component, String textDecoration){
		Font font = createOrGetFont(component);
		Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
		if(textDecoration.equalsIgnoreCase("underline")){
			map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		}
		if(textDecoration.equalsIgnoreCase("line-through")){
			map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		}
		if(textDecoration.equalsIgnoreCase("none")){
			map.remove(TextAttribute.UNDERLINE);
			map.remove(TextAttribute.STRIKETHROUGH);
		}
		font=font.deriveFont(map);
		component.setFont(font);
	}
	
	private void applyDirection(Component component, String direction){
		//bad
		Font font = createOrGetFont(component);
		Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
		if(direction.equalsIgnoreCase("ltr")){
			map.put(TextAttribute.RUN_DIRECTION, TextAttribute.RUN_DIRECTION_LTR);
		}
		if(direction.equalsIgnoreCase("rtl")){
			map.put(TextAttribute.RUN_DIRECTION, TextAttribute.RUN_DIRECTION_RTL);
		}
		font = font.deriveFont(map);
		component.setFont(font);
	}
	
	private void applyFontStretch(Component component, String fontStretch){
		Font font = createOrGetFont(component);
		Float stretch = TextAttribute.WIDTH_REGULAR;
		if(fontStretch.equalsIgnoreCase("normal")){
			stretch = TextAttribute.WIDTH_REGULAR;
		}else if(fontStretch.equalsIgnoreCase("condensed")){
			stretch = TextAttribute.WIDTH_CONDENSED;
		}else if(fontStretch.equalsIgnoreCase("semi-condensed")){
			stretch = TextAttribute.WIDTH_SEMI_CONDENSED;
		}
		else if(fontStretch.equalsIgnoreCase("semi-expanded")){
			stretch = TextAttribute.WIDTH_SEMI_EXTENDED;
		}
		else if(fontStretch.equalsIgnoreCase("expanded")){
			stretch = TextAttribute.WIDTH_EXTENDED;
		}
		Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
		map.put(TextAttribute.WIDTH, stretch);
		font = font.deriveFont(map);
		component.setFont(font);
	}

	
}
