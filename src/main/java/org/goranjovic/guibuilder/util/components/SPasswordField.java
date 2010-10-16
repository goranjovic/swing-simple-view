package org.goranjovic.guibuilder.util.components;

import javax.swing.JPasswordField;

public class SPasswordField extends JPasswordField  implements SComponent  {

	private static final long serialVersionUID = 7211699326720591523L;

	@Override
	public void setValue(Object value) {
		setText(value.toString());
	}

	@Override
	public Object getValue() {
		return getPassword();
	}

}
