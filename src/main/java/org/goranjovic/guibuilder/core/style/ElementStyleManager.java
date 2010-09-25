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

package org.goranjovic.guibuilder.core.style;


import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.style.stylists.BackgroundStylist;
import org.goranjovic.guibuilder.core.style.stylists.BorderStylist;
import org.goranjovic.guibuilder.core.style.stylists.ClassificationStylist;
import org.goranjovic.guibuilder.core.style.stylists.DimensionStylist;
import org.goranjovic.guibuilder.core.style.stylists.FontStylist;
import org.goranjovic.guibuilder.core.style.stylists.PositionStylist;
import org.goranjovic.guibuilder.core.style.stylists.Stylist;
import org.goranjovic.guibuilder.core.style.stylists.TextStylist;


public class ElementStyleManager {
	
	private Stylist[] stylists = {new DimensionStylist(), new PositionStylist(), 
			new TextStylist(), new FontStylist(), new BackgroundStylist(),
			new BorderStylist(), new ClassificationStylist()};
	private Stylist[] updatable = {new DimensionStylist(), new PositionStylist()};


	public void applyStyle(ElementDescription description, StyleSheet style) {

		for(Stylist stylist : stylists){
			stylist.applyStyle(description, style);
		}
		

		for(ElementDescription childDesc : description.getChildren()){
			applyStyle(childDesc, style);
		}
		
	}
	
	public void updateStyle(ElementDescription description, StyleSheet style) {
		
		
		
		for(Stylist stylist : stylists){
			if(description.getTagName().equalsIgnoreCase("form")) break; //fix
			stylist.applyStyle(description, style);
		}
		

		for(ElementDescription childDesc : description.getChildren()){
			applyStyle(childDesc, style);
		}
		
	}
	
	
	


	
	
	





}
