package org.goranjovic.guibuilder.components;

import java.beans.PropertyChangeSupport;

public interface SComponent extends ValueHolder, TextHolder {
	
	PropertyChangeSupport retrievePropertyChangeSupport();

}
