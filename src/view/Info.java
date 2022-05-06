package view;

import java.awt.Color;

import javax.swing.*;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Info extends JPanel implements ActionListener{
	private JButton restart;
	private CustomEvent events;
	public Info() {
		this.setLayout(null);
		this.setBackground(new Color(169, 223, 191 ));

		restart = new JButton();
		restart.setText("Reiniciar");
		restart.setBounds(320,20,100,30);
		restart.setBackground(Color.orange);
		restart.addActionListener(this);
		restart.setActionCommand("Reiniciar");
		add(restart);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		events.reiniciar();
	}

	public CustomEvent getEvents() {
		return events;
	}
	public void setEvents(CustomEvent events) {
		this.events = events;
	}
}
