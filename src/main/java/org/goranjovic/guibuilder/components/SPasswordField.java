package org.goranjovic.guibuilder.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JPasswordField;

public class SPasswordField extends JPasswordField  implements SComponent  {

	private static final long serialVersionUID = 7211699326720591523L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);


	@Override
	public void setValue(Object value) {
		//what to do with this??
		
		//Object oldValue = getValue();
		//setText(value.toString());
		//pcs.firePropertyChange("password", oldValue, value);
	}

	@Override
	public Object getValue() {
		return getPassword();
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		return pcs;
	}

}
