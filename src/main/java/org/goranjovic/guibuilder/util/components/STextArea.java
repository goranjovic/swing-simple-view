package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JTextArea;

public class STextArea extends JTextArea  implements SComponent  {

	private static final long serialVersionUID = 5830242451524418294L;
	
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
