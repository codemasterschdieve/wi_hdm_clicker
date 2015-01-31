package de.hdm.clicker.client;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.clicker.shared.*;
import de.hdm.clicker.shared.bo.*;

/**
 * Diese Klasse stellt die zum Anlegen und Bearbeiten einer Category notwendige
 * grafische Benutzeroberfläche bereit
 * 
 * @author Roth, Zimmermann, Zanella
 * @version 1.0
 * 
 */
public class CategoryForm extends VerticalPanel {

	/**
	 * Referenz auf das Proxy-Objekt um mit dem Server kommunizieren zu können
	 */
	VerwaltungAsync verwaltung = null;

	/**
	 * Referenz auf des TreeViewModel um Zugriff auf Methoden dieser Klasse 
	 * zu haben {@link CustomTreeViewModel}
	 */
	LecturerTreeViewModel ltvm = null;

	/**
	 * Referenz auf eine QuestionForm um Zugriff auf deren Methoden zu bekommen
	 */
	QuestionForm qF = null;
	
	/**
	 * Angezeigter Category
	 */
	Category shownCategory = null;

	/**
	 * TextBox und Label zur Ein-, Ausgabe bzw. Veranschaulichung
	 * der Beschreibung/Titel einer Category
	 */
	Label descLabel = new Label("Beschreibung: ");
	TextBox catTextBox = new TextBox();

	/**
	 * Button der je nach Masken-Variante (Anlegen/Ändern) einen 
	 * Lecturer anlegt bzw. ändert
	 */
	Button speichernAnlegenButton;
	
	/**
	 * Button zum löschen einer Category
	 */
	Button loeschenButton;
	
	/**
	 * Button um zur Question-Liste zurückzukehren
	 */
	Button zurueckButton = null;

	/**
	 * Tabelle (Grid) welche Widgets strukturiert aufnehmen und selbst
	 * wiederum einem Panel zugewiesen wird
	 */
	Grid grid;

	/**
	 * Panel um Buttons anzuordnen
	 */
	HorizontalPanel buttonPanel;
	
	/**
	 * Panel und FlexTable welche die zugeordneten Questions auflisten (Ändern-Maske)
	 */
	VerticalPanel questionListPanel;
	FlexTable questionFlexTable;

	/**
	 *Vector mit allen der Category zugeordneten Questions 
	 */
	Vector<Question> questionVector = null;
	
	/**
	 * Komstruktor der alle notwendigen Widgets initialisiert und anordnet,
	 * so dass das Objekt für weitere Konfigurationen bereit ist
	 * 
	 * @param	verwaltungA - Referenz auf ein Proxy-Objekt. 
	 */	
	public CategoryForm(VerwaltungAsync verwaltungA) {

		this.verwaltung = verwaltungA;

		grid = new Grid(1, 2);

		// Anordnung der Widgets
		grid.setWidget(0, 0, descLabel);
		grid.setWidget(0, 1, catTextBox);

		speichernAnlegenButton = new Button();
		buttonPanel = new HorizontalPanel();
		buttonPanel.add(speichernAnlegenButton);

		this.add(grid);
		this.add(buttonPanel);		

	}
	
	/**
	 * Setzen der Referenz zum LecturerTreeViewModel des CellTree und
	 * mittelbar setzen der Infotexte
	 * 
	 * @param	atvm - Referenz auf ein CustomTreeViewModel-Objekt. 
	 */
	public void setLtvm(LecturerTreeViewModel ltvm) {
		this.ltvm = ltvm;
	}

	/**
	 * Setzen der aus dem CellTree gewählten Category (Ändern-Maske)
	 * 
	 * @param	category - Referenz auf ein Category-Objekt. 
	 */
	public void setShownCategory(Category category) {
		this.shownCategory = category;
	}

	/**
	 * TextBoxen mit Attributen der Category füllen (Ändern-Maske)
	 */
	public void fillForm() {
		this.catTextBox.setText(shownCategory.getDescription());
	}

	/**
	 * Methode welche die Benutzeroberfläche so konfiguriert, dass sie das Ändern einer
	 * Category ermöglicht (wird von AdminTreeViewModel aus aufgerufen {@link AdminTreeViewModel})
	 */
	public void aendernMaske() {
		
		/*
		 *  "speichernAnlegenButton" wird entsprechend der Funktion
		 *  benannt und "bekommt" einen entsprechenden Clickhandler
		 *  zugewiesen, der für die Abänderung eines Raumes erfoderlichen
		 *  Funktionalitäten impliziert
		 */
		speichernAnlegenButton.setText("Speichern");

		speichernAnlegenButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				speichernAnlegenButton.setEnabled(false);
				loeschenButton.setEnabled(false);

				shownCategory.setDescription(catTextBox.getText());
				
				verwaltung.aendernCategory(shownCategory, new AsyncCallback<Category>() {
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());

						verwaltung.auslesenCategory(shownCategory, new AsyncCallback<Vector<Category>>() {
							public void onFailure(Throwable caught) {
								Window.alert(caught.getMessage());
								speichernAnlegenButton.setEnabled(true);
								loeschenButton.setEnabled(true);
							}

							/*
							 *  Bei fehlgeschlagener Änderung der Category, wird die Category wieder 
							 *  in ihrer ursprünglichen Form geladen und die Benutzeroberfläche neu
							 *  aufgesetzt
							 */
							public void onSuccess(Vector<Category> result) {
								ltvm.setSelectedCategory(result.elementAt(0));	
								speichernAnlegenButton.setEnabled(true);
								loeschenButton.setEnabled(true);								
							}
						});
					}

					/* 
					 * Bei Erfolgreicher Änderung erfolgt Meldung an der User und
					 * der categoryDataProvider wird mittelbar aktualisiert
					 */
					public void onSuccess(Category result) {
						Window.alert("Kategorie wurde erfolgreich geändert");
						
						ltvm.updateCategory(result);
						
						speichernAnlegenButton.setEnabled(true);
						loeschenButton.setEnabled(true);
					}
				});
			}
		});

		// Initialisieren und Konfigurieren des Löschen-Buttons
		loeschenButton = new Button("Löschen");
		buttonPanel.add(loeschenButton);

		loeschenButton.addClickHandler(new ClickHandler() {
						
			public void onClick(ClickEvent event) {
				speichernAnlegenButton.setEnabled(false);
				loeschenButton.setEnabled(false);

				verwaltung.loeschenCategory(shownCategory, new AsyncCallback<Void>() {
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
						speichernAnlegenButton.setEnabled(true);
						loeschenButton.setEnabled(true);

					}

					/* 
					 * Bei Erfolgreicher Löschung erfolgt Meldung an den User und
					 * der lecturerDataProvider wird mittelbar aktualisiert
					 */
					public void onSuccess(Void result) {
						Window.alert("Kategrie wurde erfolgreich gelöscht");
						ltvm.loeschenCategory(shownCategory);
						clearForm();
					}
				});
			}
		});
		
		questionListPanel = new VerticalPanel();
		questionFlexTable = new FlexTable();
		questionListPanel.add(questionFlexTable);
		this.add(questionListPanel);
		
	}
	
	public void ladenQuestions() {
		verwaltung.auslesenAlleQuestionsByCategory(shownCategory, new AsyncCallback<Vector<Question>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
				
			}

			@Override
			public void onSuccess(Vector<Question> result) {
				CategoryForm.this.questionVector = result;
				questionsAnzeigen();
				
			}
			
		});
	}
	
	/**
	 * Methode um den FlexTable, welcher alle der Category zugeordneten 
	 * Questions auflistet, abzubilden. Dabei erhält jeder Eintrag mittels 
	 * Button die Möglichkeit, diesen wieder zu entfernen oder zur Bearbeiten. 
	 * Die Methode wird in der Ändern-Maske zu Beginn und anschließend 
	 * maskenunabhängig bei jeder neuen Auswahl einer Lehrveranstaltung bzw. 
	 * deren Löschung aufgerufen 
	 */
	public void questionsAnzeigen() {
		questionFlexTable.removeAllRows();
		questionFlexTable.setVisible(true);
		questionFlexTable.setText(0, 0, "Frage: ");

		
		if ((questionVector != null)	&& (questionVector.size() > 0)) {
			
			// Für jede Question der Category...
			for (Question q : questionVector) {
				
				//...wird im FlexTable ein Eintrag gesetzt und...
				final int row = questionFlexTable.getRowCount();
				questionFlexTable.setWidget(row, 0, new Label(q.getQuestionText()));

				//...ein Button, mit dem der User die Question wieder entfernen kann
				Button loeschenButton = new Button("X");
				loeschenButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {

						int rowIndex = questionFlexTable.getCellForEvent(event).getRowIndex();
						questionFlexTable.removeRow(rowIndex);

						verwaltung.loeschenQuestion(questionVector.elementAt(rowIndex - 1), new AsyncCallback<Void>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Es ist ein Fehler aufgetreten, die Frage konnte nicht gelöscht werden\n" + caught.getMessage());
								ladenQuestions();
							}

							@Override
							public void onSuccess(Void result) {
								// Frage erfolgreich gelöscht
								
							}
							
						});
						questionVector.removeElementAt(rowIndex - 1);

					}
				});

				questionFlexTable.setWidget(row, 1, loeschenButton);

				//...ein Button, mit dem der User die Question bearbeiten kann
				Button bearbeitenButton = new Button("Bearbeiten");
				bearbeitenButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {

						int rowIndex = questionFlexTable.getCellForEvent(event).getRowIndex();
						setZurueckButton();
						bearbeitenQuestions(questionVector.elementAt(rowIndex - 1));
						

					}
				});

				questionFlexTable.setWidget(row, 2, bearbeitenButton);
			}
		}
		
	}
	
	/**
	 * Setzen des Zurück-Buttons um von der Question-Ändernmaske zur
	 * Question-Liste zurückzukehren
	 */
	public void setZurueckButton() {
		zurueckButton = new Button("Zur�ck zur Liste");
		zurueckButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				questionListPanel.remove(zurueckButton);
				questionListPanel.remove(qF);
				ladenQuestions();
				//questionFlexTable.setVisible(true);
				
			}
			
		});
	}
	
	/**
	 * Laden und Konfigurieren der QuestionForm (Ändern-Maske) anstelle
	 * der QuestionListe
	 * @param ques Question mit der die Maske aufgesetzt werden soll
	 */
	public void bearbeitenQuestions(Question ques) {
		if (qF != null) {
			questionListPanel.remove(qF);
		}
		questionFlexTable.setVisible(false);
		questionListPanel.add(zurueckButton);
		
		qF = new QuestionForm(verwaltung);
		qF.setShownQuestion(ques);
		qF.fillForm();
		qF.loadCategories();
		qF.setCategoryForm(this);
		qF.aendernMaske();
		questionListPanel.add(qF);
		if (ques.isImage()) {
			qF.loadImage();
		}		
	}

	/**
	 * Methode welche die Benutzeroberfläche so konfiguriert, dass sie das Anlegen einer
	 * Category ermöglicht (wird von LecturerTreeViewModel aus aufgerufen {@link LecturerTreeViewModel})
	 */
	public void anlegenMaske() {

		/*
		 *  "speichernAnlegenButton" wird entsprechend der Funktion
		 *  benannt und "bekommt" einen entsprechenden Clickhandler
		 *  zugewiesen, der für das Anlegen einer Category erforderlichen
		 *  Funktionalitäten impliziert
		 */
		speichernAnlegenButton.setText("Anlegen");

		speichernAnlegenButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				speichernAnlegenButton.setEnabled(false);

				verwaltung.anlegenCategory(catTextBox.getText(), new AsyncCallback<Category>() {
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
						speichernAnlegenButton.setEnabled(true);
					}

					public void onSuccess(Category result) {
						Window.alert("Das Anlegen der Kategorie war erfolgreich");
						ltvm.addCategory(result);
						speichernAnlegenButton.setEnabled(true);
						clearForm();
					}
				});
			}
		});
	}
	
	/**
	 * Neutralisiert die Benutzeroberfläche
	 */
	public void clearForm() {
		this.shownCategory = null;
		this.catTextBox.setText("");
	}

}
