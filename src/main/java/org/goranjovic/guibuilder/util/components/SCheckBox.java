package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JCheckBox;

public class SCheckBox extends JCheckBox  implements SComponent  {

	private static final long serialVersionUID = -8870247184874383966L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	@Override
	public void setValue(Object value) {
		setSelected((Boolean)value);
	}
	
	@Override
	public void setSelected(boolean b) {
		Object oldValue = isSelected();
		super.setSelected(b);
		pcs.firePropertyChange("selected", oldValue, b);
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
