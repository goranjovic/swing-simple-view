package org.goranjovic.guibuilder.util;

import java.awt.Component;

import javax.swing.JTable;
                         //fake component
public class TableColumn extends Component{
	
	private String name;
	private String text;
	private JTable parent;
	
	@Override
	public JTable getParent() {
		return parent;
	}
	public void setParent(JTable parent) {
		this.parent = parent;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
