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

package org.goranjovic.guibuilder.core.style.stylists;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.guibuilder.core.ElementDescription;
import org.goranjovic.guibuilder.core.style.parsers.ColorParser;
import org.goranjovic.guibuilder.core.style.parsers.UrlParser;

public class BackgroundStylist implements Stylist {

	private ColorParser colorParser = new ColorParser();
	private UrlParser urlParser = new UrlParser();

	@Override
	public void applyStyle(ElementDescription description, StyleSheet style) {
		
		Component component = description.getComponent();
		String id = description.getId();
		String tagName = description.getTagName();
		
		String backgroundColor = style.findValue(id, tagName, "background-color");
		if(backgroundColor!=null){
			applyBackgroundColor(component, backgroundColor);
		}
		
		String backgroundImage = style.findValue(id, tagName, "background-image");
		if(backgroundImage!=null){
			applyBackgroundImage(description, backgroundImage);
		}

	}


	private void applyBackgroundImage(ElementDescription description, String rawUrl) {
		
		URL url = urlParser.parseURL(rawUrl);
		String tagName = description.getTagName();
		Component component = description.getComponent();
		int width = component.getSize().width;
		int height = component.getSize().height;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.createImage(url);
		image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		
		if(tagName.equalsIgnoreCase("image")){
			((JLabel)component).setIcon(icon);
		}
		else if(tagName.equalsIgnoreCase("icon")){
			((JButton)component).setIcon(icon);
		}
		
		//scale image
		
		
	}




	private void applyBackgroundColor(Component component, String colorString) {
		
		Color color = component.getBackground();
		
		
		color = colorParser.parseColor(colorString);
		
		if(colorString.equalsIgnoreCase("transparent")){
			//color = component.getParent().getBackground();
			if(JComponent.class.isAssignableFrom(component.getClass())){
				((JComponent)component).setOpaque(false);
				return;
			}
		}
		
		component.setBackground(color);
		
	}

}
