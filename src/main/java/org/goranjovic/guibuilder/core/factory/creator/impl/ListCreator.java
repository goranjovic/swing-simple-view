/*swing-simple-view - a Simple View implementation for Swing
Copyright (C) 2009. Goran Jovic

This file is part of swing-simple-view.

swing-simple-view is free software: you can redistribute it and/or modify
it under the terms of the Lesser GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

swing-simple-view is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the Lesser GNU General Public License
along with swing-simple-view.  If not, see <http://www.gnu.org/licenses/>.*/

package org.goranjovic.guibuilder.core.factory.creator.impl;

import java.awt.Component;

import org.goranjovic.guibuilder.components.SList;
import org.goranjovic.guibuilder.core.factory.creator.Creator;
import org.w3c.dom.Element;

public class ListCreator implements Creator {

	@Override
	public Component create(Element element) {
		SList list = new SList();
		list.setName(element.getAttribute("id"));
		return list;
	}

}
