package org.goranjovic.guibuilder.core.factory.creator.impl;

import java.awt.Component;

import org.goranjovic.guibuilder.core.factory.creator.Creator;
import org.goranjovic.guibuilder.util.TableColumn;
import org.w3c.dom.Element;

public class TableColumnCreator implements Creator {

	@Override
	public Component create(Element element) {
		TableColumn column = new TableColumn();
		column.setName(element.getAttribute("id"));
		column.setText(element.getAttribute("id"));
		return column;
	}

}
