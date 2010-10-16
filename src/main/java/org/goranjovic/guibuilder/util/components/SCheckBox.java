package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JCheckBox;

public class SCheckBox extends JCheckBox  implements SComponent  {

	private static final long serialVersionUID = -8870247184874383966L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	@Override
	public void setValue(Object value) {
		Object oldValue = getValue();
		setSelected((Boolean)value);
		pcs.firePropertyChange("selected", oldValue, value);
	}

	@Override
	public Object getValue() {
		return (Boolean)isSelected();
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		return pcs;
	}

}
