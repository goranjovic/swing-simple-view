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

package org.goranjovic.guibuilder.core;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ResizeListener extends Thread implements ComponentListener {
	
	private SwingGui gui;
	
	public ResizeListener(SwingGui gui){
		this.gui=gui;
		start();
	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentResized(ComponentEvent e) {
		try {
			gui.refreshStyle();
		} catch (Exception e1) {

		}

	}

	@Override
	public void componentShown(ComponentEvent e) {

	}

}
