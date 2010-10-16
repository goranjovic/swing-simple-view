package org.goranjovic.guibuilder.util.components;

import java.beans.PropertyChangeSupport;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class STextArea extends JTextArea  implements SComponent, DocumentListener    {

	private static final long serialVersionUID = 5830242451524418294L;
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	private String oldValue;


	public STextArea(){
		super();
		getDocument().addDocumentListener(this);
	}
	
	@Override
	public void setValue(Object value) {
		setText(value.toString());		
	}
	
	@Override
	public void setText(String t) {
		Object oldValue = getText();
		super.setText(t);
		pcs.firePropertyChange("text", oldValue, t);
	}

	@Override
	public Object getValue() {
		return getText();
	}

	@Override
	public PropertyChangeSupport retrievePropertyChangeSupport() {
		return pcs;
	}
	
	private void handleDocumentChange(DocumentEvent event) {
		 Document source = event.getDocument();
       String text;
		try {
			text = source.getText(0, source.getLength());
		} catch (BadLocationException   e) {
			text = null;
		}
		pcs.firePropertyChange("text", oldValue, text);
		oldValue = text;
	}

	public void changedUpdate(DocumentEvent documentEvent) {
		handleDocumentChange(documentEvent);
   }
   public void insertUpdate(DocumentEvent documentEvent) {
   	handleDocumentChange(documentEvent);
   }
   public void removeUpdate(DocumentEvent documentEvent) {
   	handleDocumentChange(documentEvent);
   }

}
