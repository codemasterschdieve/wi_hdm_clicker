package de.hdm.clicker.client;



import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

public class ImageDownloadComposite extends Composite{

	final FormPanel form = new FormPanel();
	VerticalPanel vPanel = new VerticalPanel();
	TextBox tb = new TextBox();
	Image img = null;
	Button loeschenButton = null;
	QuestionForm qF = null;
	 
	public ImageDownloadComposite(QuestionForm qF){
		
		this.qF = qF;
		
		tb.setName("textBoxFormElement");
	    tb.setVisible(false);
	    vPanel.add(tb);
		initWidget(form);
		
		
		
		form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {

			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				if (img != null) {
					vPanel.remove(img);
					img = null;
				}
				Date date = new Date();
				img = new Image("/clicker/download?"+ date.getTime());
				img.setPixelSize(200, 200);
				vPanel.add(img);
				
				if (loeschenButton != null) {
					vPanel.remove(loeschenButton);
					loeschenButton = null;
				}
				loeschenButton = new Button("Bild löschen");
				vPanel.add(loeschenButton);
				loeschenButton.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						if (img != null) {
							vPanel.remove(img);
							img = null;
							ImageDownloadComposite.this.qF.setHasImage(false);
						}
					}
					
				});
				
			}
	    	
	    });
	}
	
	public void loadImg(String imgId) {
		
		tb.setText(imgId);
		form.setMethod(FormPanel.METHOD_GET);
		form.setAction("/clicker/download"); 
	    form.setWidget(vPanel); 
		form.submit();
	   
	}
}