package org.goranjovic.guibuilder.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JComboBox;

public class SComboBox extends JComboBox  implements SComponent  {

	private static final long serialVersionUID = -2822113052757277494L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);


	@Override
	public void setValue(Object value) {
		setSelectedItem(value);
	}
	
	@Override
	public void setSelectedItem(Object anObject) {
		Object oldValue = getSelectedItem();
		super.setSelectedItem(anObject);
		pcs.firePropertyChange("selectedItem", oldValue, anObject);
	}
	
	/*@Override
	public void setSelectedIndex(int anIndex) {
		Object oldValue = getSelectedItem();
		super.setSelectedIndex(anIndex);
		pcs.firePropertyChange("selectedItem", oldValue, getSelectedItem());
	}*/

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
