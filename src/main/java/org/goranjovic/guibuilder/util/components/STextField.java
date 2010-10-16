package org.goranjovic.guibuilder.util.components;

import javax.swing.JTextField;

public class STextField extends JTextField  implements SComponent  {

	private static final long serialVersionUID = -590619363471482477L;

	@Override
	public void setValue(Object value) {
		setText(value.toString());
	}

	@Override
	public Object getValue() {
		return getText();
	}

}
