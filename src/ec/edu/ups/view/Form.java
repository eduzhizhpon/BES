package ec.edu.ups.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form extends JPanel {

    private List<Item> questions;
    private JButton submit;
    private GridBagConstraints gbcItem;

    public Form(char id) {
	if (id == 's') {
	    studentForm();
	} else {
	    teacherForm();
	}
	this.gbcItem = new GridBagConstraints();
	initComponent();
    }

    public JButton getSubmit() {
	return submit;
    }

    private void initComponent() {

	JPanel mainPanel = new JPanel();

	mainPanel.setLayout(new GridBagLayout());
	gbcItem.insets = new Insets(10, 10, 10, 10);
	gbcItem.fill = GridBagConstraints.BOTH;
	gbcItem.anchor = GridBagConstraints.CENTER;
	gbcItem.gridx = 0;
	gbcItem.gridy = 0;
	gbcItem.weightx = 0.8;
	JLabel label = new JLabel("Preguntas:", JLabel.CENTER);

	Font labelFont = new Font("Verdana", Font.PLAIN, 18);

	label.setFont(labelFont);
	mainPanel.add(label, gbcItem);

	gbcItem.weightx = 0.04;
	gbcItem.gridx = 1;
	JLabel jlSelector = new JLabel("1", JLabel.CENTER);
	jlSelector.setFont(labelFont);
	mainPanel.add(jlSelector, gbcItem);

	gbcItem.gridx = 2;
	jlSelector = new JLabel("2", JLabel.CENTER);
	jlSelector.setFont(labelFont);
	mainPanel.add(jlSelector, gbcItem);

	gbcItem.gridx = 3;
	jlSelector = new JLabel("3", JLabel.CENTER);
	jlSelector.setFont(labelFont);
	mainPanel.add(jlSelector, gbcItem);

	gbcItem.gridx = 4;
	jlSelector = new JLabel("4", JLabel.CENTER);
	jlSelector.setFont(labelFont);
	mainPanel.add(jlSelector, gbcItem);

	gbcItem.gridx = 5;
	jlSelector = new JLabel("5", JLabel.CENTER);
	jlSelector.setFont(labelFont);
	mainPanel.add(jlSelector, gbcItem);

	labelFont = new Font("Verdana", Font.PLAIN, 16);

	for (int i = 0; i < questions.size(); i++) {

	    JLabel question = questions.get(i).getQuestion();
	    question.setFont(labelFont);
	    gbcItem.weightx = 0.8;
	    gbcItem.gridy = i + 1;
	    gbcItem.gridx = 0;
	    mainPanel.add(question, gbcItem);

	    gbcItem.weightx = 0.04;

	    for (int j = 0; j < questions.get(i).getSelectors().size(); j++) {
		gbcItem.gridx = j + 1;
		mainPanel.add(questions.get(i).getSelectors().get(j), gbcItem);
	    }
	}

	submit = new JButton("Enviar");
	gbcItem.gridy = gbcItem.gridy + 1;
	gbcItem.gridx = 0;
	gbcItem.gridwidth = 6;
	gbcItem.fill = GridBagConstraints.NONE;
	gbcItem.anchor = GridBagConstraints.EAST;

	submit.setFont(labelFont);
	mainPanel.add(submit, gbcItem);

	JScrollPane scrollPane = new JScrollPane(mainPanel);
	setLayout(new BorderLayout());
	add(scrollPane, BorderLayout.CENTER);
    }

    private void addQuestion(String q) {
	if (this.questions == null)
	    this.questions = new ArrayList<Item>();
	this.questions.add(new Item(q));
    }

    private void studentForm() {
	addQuestion("Eres mayor de edad XD.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
    }

    private void teacherForm() {
	addQuestion("Eres mayor de edad  PROFESORRRRXD.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
	addQuestion("No se que preguntar.");
    }
}