/*SwingGuiBuilder - a Simple View implementation for Swing
Copyright (C) 2009. Goran Jovic

This file is part of SwingGuiBuilder.

SwingGuiBuilder is free software: you can redistribute it and/or modify
it under the terms of the Lesser GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SwingGuiBuilder is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the Lesser GNU General Public License
along with SwingGuiBuilder.  If not, see <http://www.gnu.org/licenses/>.*/

package org.goranjovic.guibuilder.core.factory;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.SwingGui;
import org.goranjovic.guibuilder.core.factory.adder.Adder;
import org.goranjovic.guibuilder.core.factory.adder.SmartAdder;
import org.goranjovic.guibuilder.core.factory.creator.Creator;
import org.goranjovic.guibuilder.core.factory.creator.SmartCreator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FormFactory {

	

	public ElementDescription createMainForm(Element root, SwingGui swingGui) {
		
		
		
		JFrame frame = new JFrame();
		
		
		ElementDescription rootDesc = new ElementDescription();
		rootDesc.setComponent(frame);
		rootDesc.setId(root.getAttribute("id"));
		rootDesc.setTagName("form");
		
		swingGui.addComponentToMap(root.getAttribute("id"), rootDesc);
		frame.setName(root.getAttribute("id"));
		frame.setTitle(root.getAttribute("id"));
		frame.setSize(537, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(frame.getBounds());
		//panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setLayout(null);
		panel.setOpaque(false);
		frame.setContentPane(panel);
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element child = (Element) children.item(i);
				//System.out.println(child.getAttribute("id"));
				createComponent(child, panel,rootDesc, swingGui);
			}
		}

		
		return rootDesc;
	}

	private void createComponent(Element element, Container parent, ElementDescription parentDesc,
			SwingGui swingGui) {
		Component component = null;
		String id = element.getAttribute("id");
		String tagName = element.getTagName();
		
		Creator creator = new SmartCreator();
		component = creator.create(element);
		
		
		ElementDescription desc = new ElementDescription();
		desc.setComponent(component);
		desc.setId(id);
		desc.setTagName(tagName);
		parentDesc.getChildren().add(desc);
		
		swingGui.addComponentToMap(id, desc);
		
		//adds components
		Adder adder = new SmartAdder();
		adder.add(parentDesc, desc);
		
		NodeList children = element.getChildNodes();
		for(int i = 0; i < children.getLength(); i++){
			if(children.item(i).getNodeType() == Node.ELEMENT_NODE){
				createComponent((Element)children.item(i),(Container) component, desc, swingGui);
			}
		}

	}




}
