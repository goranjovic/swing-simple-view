package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JTextField;

public class STextField extends JTextField  implements SComponent  {

	private static final long serialVersionUID = -590619363471482477L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);


	@Override
	public void setValue(Object value) {
		Object oldValue = getValue();
		setText(value.toString());		
		pcs.firePropertyChange("text", oldValue, value);
	}

	@Override
	public Object getValue() {
		return getText();
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		return pcs;
	}

}
