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

package org.goranjovic.guibuilder.core;


import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.goranjovic.css.dom.StyleSheet;
import org.goranjovic.css.parser.Parser;
import org.goranjovic.guibuilder.core.factory.FormFactory;
import org.goranjovic.guibuilder.core.localizer.Localizer;
import org.goranjovic.guibuilder.core.style.ElementStyleManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SwingGui {
	
	private FormFactory elementFactory = new FormFactory();
	private ElementStyleManager elementStylist = new ElementStyleManager();
	private Localizer localizer = new Localizer();
	

	private ElementDescription rootDesc;
	private boolean initialized = false;

	
	
	private Map<String, ElementDescription> elementMap = new HashMap<String, ElementDescription>();

	private StyleSheet style;
	
	public StyleSheet getStyle() {
		return style;
	}

	public void setStyle(StyleSheet style) {
		this.style = style;
	}
	
	public void setStyle(File cssFile){
		try {
			Parser parser = new Parser();
			style = parser.parse(new FileReader(cssFile));
		} catch (FileNotFoundException e) {
		}
	}
	
	public void setStyle(String fileName){
		File file = new File(fileName);
		setStyle(file);
	}

	
	private Element descriptor;
	
	public Element getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(Element descriptor) {
		this.descriptor = descriptor;
	}
	
	public void setDescriptor(File descriptorFile){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(descriptorFile);
			descriptor = document.getDocumentElement();
		} catch (Exception e) {
		}
	}
	
	public void setDescriptor(String fileName){
		File file = new File(fileName);
		setDescriptor(file);
	}
	
	private Properties locale;
	
	public Properties getLocale() {
		return locale;
	}

	public void setLocale(Properties locale) {
		this.locale = locale;
	}
	
	public void setLocale(File propFile){
		try {
			locale = new Properties();
			locale.load(new FileReader(propFile));
		} catch (Exception e){
		}
	}
	
	public void setLocale(String fileName){
		File file = new File(fileName);
		setLocale(file);		
	}

	public SwingGui() {
		
	}
	
	public void construct(){
		rootDesc = elementFactory.createMainForm(descriptor, this);
		localizer.localize(rootDesc, locale);
		applyStyle(rootDesc);
		rootDesc.getComponent().addComponentListener(new ResizeListener(this));
	}
	
	public void show(){
		rootDesc.getComponent().setVisible(true);
	}
	
	private void applyStyle(ElementDescription description){
		boolean notForm = !(description.getTagName().equals("form"));
		if (notForm || (!initialized )) {
			initialized = true;
			elementStylist.applyStyle(description, style);
		}
		for(ElementDescription child : description.getChildren()){
			elementStylist.applyStyle(child, style);
		}
	}

	
	public void addComponentToMap(String key, ElementDescription value){
		elementMap.put(key, value);
	}
	
	public ElementDescription findElementDescription(String key){
		return elementMap.get(key);
	}
	
	public Component findComponent(String key){
		return findElementDescription(key).getComponent();
	}

	public void refreshStyle() {
		elementStylist.updateStyle(rootDesc, style);		
	}

	public boolean isInitialized() {
		return initialized;
	}


	
	
	

}
