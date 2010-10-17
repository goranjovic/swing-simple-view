package org.goranjovic.guibuilder.components;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import org.goranjovic.guibuilder.components.support.SetValueAttemptEvent;
import org.goranjovic.guibuilder.components.support.SetValueAttemptListener;

public class SComboBox extends JComboBox  implements SComponent  {

	private static final long serialVersionUID = -2822113052757277494L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	private List<SetValueAttemptListener> setValueAttemptListeners = new ArrayList<SetValueAttemptListener>();

	public void addSetValueAttemptListener(SetValueAttemptListener setValueAttemptListener){
		setValueAttemptListeners.add(setValueAttemptListener);
	}
	
	public void removeSetValueAttemptListener(SetValueAttemptListener setValueAttemptListener){
		setValueAttemptListeners.remove(setValueAttemptListener);
	}
	
	public void fireOnNotSetValueEvent(Object value){
		SetValueAttemptEvent event = new SetValueAttemptEvent(this, value);
		for(SetValueAttemptListener listener : setValueAttemptListeners){
			listener.onNotSetValue(event);
		}
	}

	@Override
	public void setValue(Object value) {
		if(isItemInModel(value)){
			setSelectedItem(value);
		}else{
			fireOnNotSetValueEvent(value);
		}
	}
	
	public List<Object> getAllItems(){
		List<Object> all = new ArrayList<Object>();
		int count = getItemCount();
		for(int i = 0; i < count; i++){
			all.add(getItemAt(i));
		}
		return all;
	}
	
	public boolean isItemInModel(Object item){
		int count = getItemCount();
		for(int i = 0; i < count; i++){
			if(item.equals(getItemAt(i))){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void setSelectedItem(Object anObject) {
		Object oldValue = getSelectedItem();
		super.setSelectedItem(anObject);
		pcs.firePropertyChange("selectedItem", oldValue, anObject);
	}
	
	/*@Override
	public void setSelectedIndex(int anIndex) {
		Object oldValue = getSelectedItem();
		super.setSelectedIndex(anIndex);
		pcs.firePropertyChange("selectedItem", oldValue, getSelectedItem());
	}*/

	@Override
	public Object getValue() {
		return getSelectedItem();
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		return pcs;
	}

}
