package org.goranjovic.guibuilder.components.support;

import java.util.EventListener;

public interface SetValueAttemptListener extends EventListener {
	
	void onNotSetValue(SetValueAttemptEvent event);

}
