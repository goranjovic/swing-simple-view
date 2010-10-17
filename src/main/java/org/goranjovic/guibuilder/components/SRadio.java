package org.goranjovic.guibuilder.components;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JRadioButton;

public class SRadio extends JRadioButton  implements SComponent, ItemListener  {

	private static final long serialVersionUID = 2454445679599858562L;

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	private String mode = "independent";
	
	private Object radioModel;
	
	public SRadio(){
		super();
		addItemListener(this);
	}
	
	public void setRadioModel(Object radioModel) {
		this.radioModel = radioModel;
	}

	public Object getRadioModel() {
		return radioModel;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

	@Override
	public void setValue(Object value) {
		//to-do: coordination with group
		if(getMode().equals("independent")){
			setSelected((Boolean)value);
		}else if(getMode().equals("model")){
			setRadioModel(value);
		}
	}

	@Override
	public Object getValue() {
		if(getMode().equals("independent")){
			return isSelected();
		}
		if(getMode().equals("model")){
			return getRadioModel();
		}
		return null;
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		return pcs;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(getMode().equals("model")){
			if(getParent() instanceof SButtonGroupPanel){
				SButtonGroupPanel group = (SButtonGroupPanel) getParent();
				group.setSelectedRadioButton(this);
			}
		}else if(getMode().equals("independent")){
			Boolean value = (Boolean)getValue();
			Boolean oldValue = !value;
			pcs.firePropertyChange("selected", oldValue, value);
		}
	}

}
