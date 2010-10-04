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

package org.goranjovic.guibuilder.core.style.parsers;

import java.awt.Color;
import java.util.StringTokenizer;

public class ColorParser {
	
	public Color parseColor(String colorString){
		if (colorString.startsWith("#")) {
			// in hex
			return parseColorHex(colorString);
		} else if (colorString.startsWith("rgb")) {
			// in rgb
			return parseColorRgb(colorString);
		} else{
			// in color name
			return parseColorName(colorString);
		}
	}
	
	public Color parseColorName(String colorString) {
		if(colorString.equalsIgnoreCase("black")){
			return Color.BLACK;
		}else if(colorString.equalsIgnoreCase("blue")){
			return Color.BLUE;
		}else if(colorString.equalsIgnoreCase("gray")){
			return Color.GRAY;
		}else if(colorString.equalsIgnoreCase("green")){
			return Color.GREEN;
		}else if(colorString.equalsIgnoreCase("red")){
			return Color.RED;
		}else if(colorString.equalsIgnoreCase("white")){
			return Color.WHITE;
		}else if(colorString.equalsIgnoreCase("yellow")){
			return Color.YELLOW;
		}
		return null;
	}

	public Color parseColorRgb(String colorString) {
		StringTokenizer t = new StringTokenizer(colorString, "()");
		t.nextToken();
		String rgb = t.nextToken();		
		String[] s = rgb.split(",");
		int r = parseColorComponent(s[0]);
		int g = parseColorComponent(s[1]);
		int b = parseColorComponent(s[2]);
		return new Color(r,g,b);
	}

	public Color parseColorHex(String colorString) {
		Color color;
		int colorInt = Integer.parseInt(colorString.substring(1),
				16);
		color = new Color(colorInt);
		return color;
	}
	
	private int parseColorComponent(String raw){
		int parsed = 0;
		if(raw.endsWith("%")){
			raw = raw.substring(0,raw.length()-1);
			parsed = (Integer.parseInt(raw) * 255)/100;
			if (parsed > 255) parsed = 255;
		}else{
			parsed = Integer.parseInt(raw);
		}
		return parsed; 
		
	}

}
