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

package org.goranjovic.guibuilder.core.localizer;

import java.awt.Component;

import org.goranjovic.guibuilder.util.components.TextHolder;

public class TextManager {
	
	public static void setText(Component component, String type, String text){
		
		((TextHolder)component).setText(text);
		
	}
	
	public static String getText(Component component, String type){
		
		return ((TextHolder)component).getText();
		
	}

}
