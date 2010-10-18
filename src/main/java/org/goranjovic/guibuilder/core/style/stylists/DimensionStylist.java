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
import java.awt.Dimension;
import java.awt.Toolkit;

import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.guibuilder.core.ElementDescription;



public class DimensionStylist implements Stylist {

	@Override
	public void applyStyle(ElementDescription description, StyleSheet style) {
		applyDimensions(description, style);
	}



	private void applyDimensions(ElementDescription description, StyleSheet style) {
		
		String widthString;
		String heightString;
		String maxWidthString;
		String minWidthString;
		String maxHeightString;
		String minHeightString;
				
		
		Component component = description.getComponent();
		String id = description.getId();
		String tagName = description.getTagName();
		
		
		widthString=style.findValue(id, tagName, "width");
		heightString=style.findValue(id, tagName, "height");
		maxWidthString=style.findValue(id, tagName, "max-width");
		minWidthString=style.findValue(id, tagName, "min-width");
		maxHeightString=style.findValue(id, tagName, "max-height");
		minHeightString=style.findValue(id, tagName, "min-height");
		
		
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
		
		int maxWidth = Integer.MAX_VALUE;
		int minWidth = 0;
		int maxHeight = Integer.MAX_VALUE;
		int minHeight = 0;
		
		if(maxWidthString!=null){
			if(maxWidthString.endsWith("px")){
				maxWidth = Integer.parseInt(maxWidthString.replaceAll("px", ""));
			}else if(maxWidthString.endsWith("%")){
				String maxWidthPercentString = maxWidthString.substring(0, maxWidthString.length()-1);
				int maxWidthPercent = Integer.parseInt(maxWidthPercentString);
				maxWidth = (parentWidth * maxWidthPercent)/100;
			}
		}
		
		if(minWidthString!=null){
			if(minWidthString.endsWith("px")){
				minWidth = Integer.parseInt(minWidthString.replaceAll("px", ""));
			}else if(minWidthString.endsWith("%")){
				String minWidthPercentString = minWidthString.substring(0, maxWidthString.length()-1);
				int minWidthPercent = Integer.parseInt(minWidthPercentString);
				minWidth = (parentWidth * minWidthPercent)/100;
			}
		}
		
		if(maxHeightString!=null){
			if(maxHeightString.endsWith("px")){
				maxHeight = Integer.parseInt(maxHeightString.replaceAll("px", ""));
			}else if(maxHeightString.endsWith("%")){
				String maxHeightPercentString = maxHeightString.substring(0, maxHeightString.length()-1);
				int maxHeightPercent = Integer.parseInt(maxHeightPercentString);
				maxHeight = (parentHeight * maxHeightPercent)/100;
			}
		}
		
		if(minHeightString!=null){
			if(minHeightString.endsWith("px")){
				minHeight = Integer.parseInt(minHeightString.replaceAll("px", ""));
			}else if(minHeightString.endsWith("%")){
				String minHeightPercentString = minHeightString.substring(0, minHeightString.length()-1);
				int minHeightPercent = Integer.parseInt(minHeightPercentString);
				minHeight = (parentHeight * minHeightPercent)/100;
			}
		}
		
		if(widthString!=null){
			//setting width
			if(widthString.endsWith("px")){
				//in pixels
				componentWidth = Integer.parseInt(widthString.replaceAll("px", ""));
			}else if(widthString.endsWith("%")){
				//in percents
				String widthPercentString = widthString.substring(0, widthString.length()-1);
				int widthPercent = Integer.parseInt(widthPercentString);
				componentWidth=(parentWidth*widthPercent)/100;
			}
		}
		if(heightString!=null){
			//setting width
			if(heightString.endsWith("px")){
				//in pixels
				componentHeight = Integer.parseInt(heightString.replaceAll("px", ""));
			}else if(heightString.endsWith("%")){
				//in percents
				String heightPercentString = heightString.substring(0, heightString.length()-1);
				int heightPercent = Integer.parseInt(heightPercentString);
				componentHeight=(parentHeight*heightPercent)/100;
			}
		}
		
		//if max or min are excedeed
		
		if(componentWidth > maxWidth){
			componentWidth = maxWidth;
		}
		
		if (componentWidth < minWidth){
			componentWidth = minWidth;
		}
		
		if(componentHeight > maxHeight){
			componentHeight = maxHeight;
		}
		
		if(componentHeight < minHeight){
			componentHeight = minHeight;
		}
		
		
		component.setSize(componentWidth, componentHeight);
		
		
	}

}
