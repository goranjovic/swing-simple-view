package org.goranjovic.guibuilder.util.components;

import javax.swing.JTextArea;

public class STextArea extends JTextArea  implements ValueHolder, TextHolder  {

	private static final long serialVersionUID = 5830242451524418294L;

	@Override
	public void setValue(Object value) {
		setText(value.toString());		
	}

	@Override
	public Object getValue() {
		return getText();
	}

}
