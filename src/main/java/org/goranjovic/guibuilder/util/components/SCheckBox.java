package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JCheckBox;

public class SCheckBox extends JCheckBox  implements SComponent  {

	private static final long serialVersionUID = -8870247184874383966L;
	

	@Override
	public void setValue(Object value) {
		setSelected((Boolean)value);
		
	}

	@Override
	public Object getValue() {
		return (Boolean)isSelected();
	}

}
