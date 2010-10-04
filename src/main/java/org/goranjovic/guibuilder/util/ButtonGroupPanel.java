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

package org.goranjovic.guibuilder.util;

import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonGroupPanel extends JPanel{
	
	private static final long serialVersionUID = -5194519759694830446L;
	
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	@Override
	public Component add(Component comp) {
			if (JRadioButton.class.isAssignableFrom(comp.getClass())) {
				JRadioButton button = (JRadioButton) comp;
				buttonGroup.add(button);
			}
			return super.add(comp);
	}
	
	@Override
	public void add(Component comp, Object constraints) {
		add(comp);
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

}
