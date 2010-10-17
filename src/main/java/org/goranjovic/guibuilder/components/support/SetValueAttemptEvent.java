package org.goranjovic.guibuilder.components.support;

import java.io.Serializable;
import java.util.EventObject;

public class SetValueAttemptEvent extends EventObject implements Serializable {

	private static final long serialVersionUID = -4934477808184240807L;
	
	private Object value;

	public SetValueAttemptEvent(Object source, Object value) {
		super(source);
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}


}
