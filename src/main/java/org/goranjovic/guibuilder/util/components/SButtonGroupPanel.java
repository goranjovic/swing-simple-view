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

import java.awt.Component;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class SButtonGroupPanel extends JPanel  implements SComponent  {
	
	private static final long serialVersionUID = -5194519759694830446L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	private ButtonGroup buttonGroup = new ButtonGroup();
	private List<SRadio> radios = new ArrayList<SRadio>();
	
	private SRadio selectedRadioButton = null;
	
	@Override
	public Component add(Component comp) {
			if (SRadio.class.isAssignableFrom(comp.getClass())) {
				SRadio radio = (SRadio) comp;
				buttonGroup.add(radio);
				radios.add(radio);
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
	
	public SRadio getSelectedRadioButton(){
		return selectedRadioButton;
	}
	
	public void setSelectedRadioButton(SRadio selected){
		Object oldValue = null;
		if(this.selectedRadioButton != null){
			oldValue = this.selectedRadioButton.getRadioModel();
		}
		this.selectedRadioButton = selected;
		if(selected.getRadioModel()!=null){
			pcs.firePropertyChange("selected", oldValue, selected.getRadioModel());
		}
	}

	@Override
	public void setValue(Object value) {
		for(SRadio radio : radios){
			if(radio.getRadioModel().equals(value)){
				if(!radio.isSelected()){
					radio.setSelected(true);
					return;
				}
			}
		}
	}

	@Override
	public Object getValue() {
		return getSelectedRadioButton().getRadioModel();
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		return pcs;
	}

}
