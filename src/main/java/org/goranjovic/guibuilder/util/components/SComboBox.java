package org.goranjovic.guibuilder.util.components;

import javax.swing.JComboBox;

public class SComboBox extends JComboBox  implements ValueHolder, TextHolder  {

	private static final long serialVersionUID = -2822113052757277494L;

	@Override
	public void setValue(Object value) {
		setSelectedItem(value);		
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

}
