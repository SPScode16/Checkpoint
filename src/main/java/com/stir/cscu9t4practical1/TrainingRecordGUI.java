// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import java.lang.Number;

/**
*
* @author 2924912
*/

public class TrainingRecordGUI extends JFrame implements ActionListener {

	private JTextField name = new JTextField(30);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	private JButton addR = new JButton("Add");
	private JButton lookUpByDate = new JButton("Look Up");
	private JButton FindAllByDate = new JButton("Find all by date"); // a new button for looking up all entries on a certain date
	private JButton Remove = new JButton("Remove"); // a button for removing a record

	private JLabel activity = new JLabel(" Activity: "); // a new label for selecting between running, cycling, swimming
	private String selectionList[] = {"Run", "Cycle", "Swim"};
	private JComboBox<String> selection = new JComboBox<String>(selectionList); // creates a drop down list for selecting the activity

	private TrainingRecord myAthletes = new TrainingRecord();

	private JTextArea outputArea = new JTextArea(5, 50);

	public static void main(String[] args) {
		TrainingRecordGUI applic = new TrainingRecordGUI();
	} // main

	// set up the GUI 
	public TrainingRecordGUI() {
		super("Training Record");
		setLayout(new FlowLayout());
		add(labn);
		add(name);
		name.setEditable(true);
		add(labd);
		add(day);
		day.setEditable(true);
		add(labm);
		add(month);
		month.setEditable(true);
		add(laby);
		add(year);
		year.setEditable(true);
		add(labh);
		add(hours);
		hours.setEditable(true);
		add(labmm);
		add(mins);
		mins.setEditable(true);
		add(labs);
		add(secs);
		secs.setEditable(true);
		add(labdist);
		add(dist);
		dist.setEditable(true);
		add(activity);
		add(selection);
		selection.addActionListener(this);
		add(addR);
		addR.addActionListener(this);
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);
		add(FindAllByDate); // adds the button to the GUI
		FindAllByDate.addActionListener(this); // adds an action listener to the button
		add(Remove); // adds the remove button to the GUI
		Remove.addActionListener(this);
		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 200);
		setVisible(true);
		blankDisplay();

		// To save typing in new entries while testing, uncomment
		// the following lines (or add your own test cases)

	} // constructor

	// listen for and respond to GUI events 
	public void actionPerformed(ActionEvent event) {
		String message = "";
		if (event.getSource() == addR) {
			message = addEntry((String) selection.getSelectedItem()); // retrieves the type of activity from the selection list
		}
		if (event.getSource() == lookUpByDate) {
			message = lookupEntry();
		}
		if (event.getSource() == FindAllByDate) {
			message = lookupAllEntries(); // calls the method that returns all entries on the specified date
		}

		if (event.getSource() == Remove) {
			message = removeEntry();
		}

		outputArea.setText(message);
		blankDisplay();
	} // actionPerformed

	public String addEntry(String what) {
		String message = "Record added\n";
		System.out.println("Adding "+what+" entry to the records");
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		float km = java.lang.Float.parseFloat(dist.getText());
		int h = Integer.parseInt(hours.getText());
		int mm = Integer.parseInt(mins.getText());
		int s = Integer.parseInt(secs.getText());

		List<Entry> records = myAthletes.getTrainingRecord(); // retrieves the list of training records
		ListIterator<Entry> iterator = records.listIterator();

		while (iterator.hasNext()) { // while the list has elements that have not been checked yet
			Entry current = iterator.next();
			if (current.getName().compareTo(n) == 0 && current.getDay() == d && current.getMonth() == m && current.getYear() == y) { // if the data entered matches the data of an already existing record
				message =  "Record already exists.";
				return message; // returns a message without adding the entry to the record
			}
		}

		if (what == "Run") {
			Entry e = new SprintEntry(n, d, m, y, h, mm, s, km); // creates a SprintEntry object if the activity selected was running
			myAthletes.addEntry(e);
		}
		if (what == "Cycle") {
			Entry e = new CycleEntry(n, d, m, y, h, mm, s, km); // creates a CycleEntry object if the activity selected was cycling
			myAthletes.addEntry(e);
		}
		if (what == "Swim") {
			Entry e = new SwimEntry(n, d, m, y, h, mm, s, km); // creates a SwimEntry object if the activity selected was swimming
			myAthletes.addEntry(e);
		}
		return message;
	}

	public String lookupAllEntries() {
		int m = Integer.parseInt(month.getText()); // retrieves the month from user input
		int d = Integer.parseInt(day.getText()); // retrieves the day from user input
		int y = Integer.parseInt(year.getText()); // retrieves the year from user input
		outputArea.setText("looking up records ...");
		String message = myAthletes.lookupAllEntries(d, m, y); // calls the method that will construct a string of all entries on the date
		return message;
	}

	public String lookupEntry() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.lookupEntry(d, m, y);
		return message;
	}

	public String removeEntry() {
		String message = "Record not found.";
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());

		List<Entry> records = myAthletes.getTrainingRecord(); // retrieves the list of training records
		ListIterator<Entry> iterator = records.listIterator();

		while (iterator.hasNext()) { // while the list has elements that have not been checked yet
			Entry current = iterator.next();
			if (current.getName().compareTo(n) == 0 && current.getDay() == d && current.getMonth() == m && current.getYear() == y) { // if the data entered matches the data of an already existing record
				message =  "Record removed.";
				myAthletes.removeEntry(current); // calls a method to remove the entry from the training record
				return message; // returns a message without adding the entry to the record
			}
		}

		return message;
	}

	public void blankDisplay() {
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		dist.setText("");

	}// blankDisplay
	// Fills the input fields on the display for testing purposes only
	public void fillDisplay(Entry ent) {
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
	}

} // TrainingRecordGUI

