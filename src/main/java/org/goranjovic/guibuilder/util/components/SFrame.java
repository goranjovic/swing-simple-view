package org.goranjovic.guibuilder.util.components;

import javax.swing.JFrame;

public class SFrame extends JFrame implements ValueHolder, TextHolder {

	private static final long serialVersionUID = -1525659124885966957L;

	@Override
	public void setText(String text) {
		setTitle(text);		
	}

	@Override
	public String getText() {
		return getTitle();
	}

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
