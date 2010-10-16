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

package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class STab extends JPanel  implements SComponent  {
	
	private static final long serialVersionUID = -2910830786228775190L;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		setTitle(text);
		if(JTabbedPane.class.isAssignableFrom(this.getParent().getClass())){
			JTabbedPane pane = (JTabbedPane)this.getParent();
			int index = pane.indexOfComponent(this);
			pane.setTitleAt(index, text);
		}
	}

	@Override
	public String getText() {
		return getTitle();
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
