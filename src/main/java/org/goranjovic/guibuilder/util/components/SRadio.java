package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JRadioButton;

public class SRadio extends JRadioButton  implements SComponent  {

	private static final long serialVersionUID = 2454445679599858562L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	
	private Object value;

	@Override
	public void setValue(Object value) {
		//to-do: coordination with group
		Object oldValue = getValue();
		this.value = value;	
		pcs.firePropertyChange("selected", oldValue, value);
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		return pcs;
	}

}
