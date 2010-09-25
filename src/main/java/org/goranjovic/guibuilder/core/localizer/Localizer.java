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

package org.goranjovic.guibuilder.core.localizer;

import java.awt.Component;
import java.util.Properties;

import org.goranjovic.guibuilder.core.ElementDescription;

public class Localizer {
	
	private TextManager textApplier = new TextManager();
	
	public void localize(ElementDescription description, Properties locale){
		
		
		Component component = description.getComponent();
		String name = description.getTagName();
		String id = description.getId();
		
		String localizedText = locale.getProperty(id);
		
		if(localizedText!=null){
			textApplier.setText(component, name, localizedText);
		}
		
		
		for(ElementDescription child : description.getChildren()){
			localize(child, locale);
		}
		
	}

}
