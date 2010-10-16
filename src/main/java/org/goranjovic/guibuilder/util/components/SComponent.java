package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

public interface SComponent extends ValueHolder, TextHolder {
	
	PropertyChangeSupport retrievePropertyChangeSupport();

}
