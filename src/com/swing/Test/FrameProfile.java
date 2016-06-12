package com.swing.Test;


import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Utilisateur;

import com.swing.modelData.ModelAdministrateur;
import com.swing.variableSession.VariableSession;

import delegate.UserServiceDelegate;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class FrameProfile extends JFrame {


	private JTextField nom;
	private JTextField prenom;
	private JTextField tel;
	private JTextField email;
	private JTextField login;
	private JTextArea adress;
	private JPasswordField pwd;
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
	public FrameProfile(JMenuBar jMenuBar) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 433);
		//setJMenuBar(new FrameMenu().Menu());
	
		setJMenuBar(jMenuBar);
		
	
	}
	
	}
