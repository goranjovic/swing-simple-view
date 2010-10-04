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

package org.goranjovic.guibuilder.core.style.parsers;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;

public class CursorParser {
	
	public Cursor parseCursor(String cursorName) {
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
		return cursor;
	}


}
