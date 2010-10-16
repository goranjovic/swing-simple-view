package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JComboBox;

public class SComboBox extends JComboBox  implements SComponent  {

	private static final long serialVersionUID = -2822113052757277494L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);


	@Override
	public void setValue(Object value) {
		Object oldValue = getValue();
		setSelectedItem(value);		
		pcs.firePropertyChange("selectedItem", oldValue, value);
	}

	@Override
	public Object getValue() {
		return getSelectedItem();
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
