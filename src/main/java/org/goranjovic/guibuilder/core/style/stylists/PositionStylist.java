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

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JViewport;

import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.guibuilder.core.ElementDescription;

public class PositionStylist implements Stylist{

	@Override
	public void applyStyle(ElementDescription description, StyleSheet style) {
		applyCoordinates(description, style);
		
	}




	public void applyCoordinates(ElementDescription description, StyleSheet style){
		String leftString;
		String rightString;
		String topString;
		String bottomString;
		String zIndexString;
		String overflowString;
		
		Component component = description.getComponent();
		String id = description.getId();
		String tagName = description.getTagName();
			
		leftString = style.findValue(id, tagName, "left");
		rightString = style.findValue(id, tagName, "right");
		topString = style.findValue(id, tagName, "top");
		bottomString = style.findValue(id, tagName, "bottom");
		zIndexString = style.findValue(id, tagName, "z-index");
		overflowString = style.findValue(id, tagName, "overflow");
		
		//System.out.println(description.getId());
		int parentWidth;
		int parentHeight;
		
		if(description.getTagName().equalsIgnoreCase("form")){
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			parentWidth = screenSize.width;
			parentHeight = screenSize.height;
		}else{
			parentWidth = component.getParent().getWidth();
			parentHeight = component.getParent().getHeight();
		}
		
		
		int componentHeight = component.getHeight();
		int componentWidth = component.getWidth();

		
		
		if(leftString!=null){
			//x relative to left
			int left = 0;
			if(leftString.endsWith("px")){
				//in pixels
				left = Integer.parseInt(leftString.replaceFirst("px", ""));
			}else if(leftString.endsWith("%")){
				//in percents
				String leftPercentString = leftString.substring(0, leftString.length()-1);
				int leftPercent = Integer.parseInt(leftPercentString);
				left = (parentWidth * leftPercent)/100;
			}
			Point location = component.getLocation();
			location.x=left;
			component.setLocation(location);
		}else if(rightString!=null){
			//x relative to right
			int right = 0;
			if(rightString.endsWith("px")){
				//in pixels
				int rightOffset = Integer.parseInt(rightString.replaceFirst("px", ""));
				right = parentWidth - rightOffset - componentWidth;
			}else if(rightString.endsWith("%")){
				//in percents
				String rightPercentString = rightString.substring(0, rightString.length()-1);
				int rightPercent = Integer.parseInt(rightPercentString);
				int rightOffset = (rightPercent * parentWidth)/100;
				right = parentWidth - rightOffset - componentWidth;
			}
			Point location = component.getLocation();
			location.x=right;
			component.setLocation(location);
		}
		
		//vertical position
		if(topString!=null){
			//y relative to top
			int top = 0;
			if(topString.endsWith("px")){
				//in pixels
				top = Integer.parseInt(topString.replaceFirst("px", ""));
			}else if(topString.endsWith("%")){
				//in percents
				String topPercentString = topString.substring(0, topString.length()-1);
				int topPercent = Integer.parseInt(topPercentString);
				top = (parentHeight * topPercent)/100;
			}
			Point location = component.getLocation();
			location.y=top;
			component.setLocation(location);
		}else if(bottomString!=null){
			//y relative to bottom
			int bottom = 0;
			if(bottomString.endsWith("px")){
				//in pixels
				int bottomOffset = Integer.parseInt(bottomString.replaceAll("px", ""));
				bottom = parentHeight-componentHeight-bottomOffset;
			}else if(bottomString.endsWith("%")){
				String bottomPercentString = bottomString.substring(0, bottomString.length()-1);
				int bottomPercent = Integer.parseInt(bottomPercentString);
				int bottomOffset = (parentHeight * bottomPercent)/100;
				bottom = parentHeight - bottomOffset - componentHeight;
			}
			Point location = component.getLocation();
			location.y=bottom;
			component.setLocation(location);
		}
		
		
		//now z coordinates
		//WARNING - in css bigger number means in front
		//			but in swing it means behind
		int zIndex = 0;
		if(zIndexString!=null){
			zIndex =  Integer.parseInt(zIndexString);
		}
		if (component.getParent()!=null) {
			component.getParent().setComponentZOrder(component, zIndex);
		}
		
		
		//now scrolling
		if(overflowString != null){
			if(overflowString.equalsIgnoreCase("scroll")){
				if (!(JViewport.class.isAssignableFrom(component.getParent().getClass()))) {
					//System.out.println("scroller");
					//System.out.println(component.getParent().getClass());
					Container parent = component.getParent();
					JScrollPane scroll = new JScrollPane(component);
					parent.add(scroll);
					
					description.setComponent(component);
					
					
					ElementDescription dupl = new ElementDescription();
					dupl.setId(description.getId());
					dupl.setTagName(description.getTagName());
					dupl.setComponent(component);
					
					ElementDescription vp = new ElementDescription();
					vp.setId(description.getId());
					vp.setTagName(description.getTagName());
					vp.setComponent(component.getParent());
					
					description.getChildren().add(vp);
					vp.getChildren().add(dupl);
					
					scroll.revalidate();
					/*Dimension cSize = (Dimension) component.getSize().clone();
					Point cLocation = (Point) component.getLocation().clone();
					scroll.setSize(cSize);
					scroll.setPreferredSize(cSize);
					scroll.getViewport().setSize(cSize);
					scroll.getViewport().setPreferredSize(cSize);
					scroll.getViewport().setLocation(cLocation);
					scroll.setLocation(cLocation);
					scroll.revalidate();
					parent.add(scroll);
					ElementDescription scrollDesc = new ElementDescription();
					scrollDesc.setTagName(description.getTagName());
					scrollDesc.setId(description.getId());
					scrollDesc.setComponent(scroll);*/
					//description.getPropagators().add(scrollDesc);
				}
			}
		}
		
	}

}
