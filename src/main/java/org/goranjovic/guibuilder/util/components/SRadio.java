package org.goranjovic.guibuilder.util.components;

import javax.swing.JRadioButton;

public class SRadio extends JRadioButton  implements ValueHolder, TextHolder  {

	private static final long serialVersionUID = 2454445679599858562L;
	
	private Object value;

	@Override
	public void setValue(Object value) {
		this.value = value;	
	}

	@Override
	public Object getValue() {
		return value;
	}

}
