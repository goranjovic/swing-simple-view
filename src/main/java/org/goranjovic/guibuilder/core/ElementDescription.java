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

package org.goranjovic.guibuilder.core;

import java.awt.Component;
import java.util.LinkedList;
import java.util.List;

import org.goranjovic.css.dom.SelectorType;

public class ElementDescription {
	
	private Component component;
	
	private String tagName;
	
	private String id;
	
	private List<ElementDescription>  children = new LinkedList<ElementDescription>();
	


	public List<ElementDescription> getChildren() {
		return children;
	}

	public void setChildren(List<ElementDescription> children) {
		this.children = children;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return getComponent().equals(obj);
	}
	
	@Override
	public int hashCode() {
		return getComponent().hashCode();
	}
	
	public String getIdentifier(SelectorType type){
		if(type == SelectorType.ID) return getId();
		if(type == SelectorType.TAG) return getTagName();
		return null;
	}


}
