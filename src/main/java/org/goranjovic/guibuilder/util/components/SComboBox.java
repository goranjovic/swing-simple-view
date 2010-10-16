package org.goranjovic.guibuilder.util.components;

import javax.swing.JComboBox;

public class SComboBox extends JComboBox  implements ValueHolder {

	private static final long serialVersionUID = -2822113052757277494L;

	@Override
	public void setValue(Object value) {
		setSelectedItem(value);		
	}

	@Override
	public Object getValue() {
		return getSelectedItem();
	}

}
