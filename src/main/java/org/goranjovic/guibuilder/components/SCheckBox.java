package org.goranjovic.guibuilder.components;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JCheckBox;

public class SCheckBox extends JCheckBox  implements SComponent, ItemListener  {

	private static final long serialVersionUID = -8870247184874383966L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public SCheckBox(){
		super();
		addItemListener(this);
	}
	
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

	@Override
	public void itemStateChanged(ItemEvent event) {
		Boolean value = (Boolean)getValue();
		Boolean oldValue = !value;
		pcs.firePropertyChange("selected", oldValue, value);
	}

}
