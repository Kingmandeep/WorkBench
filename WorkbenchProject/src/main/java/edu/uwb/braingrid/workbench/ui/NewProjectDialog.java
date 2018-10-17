package edu.uwb.braingrid.workbench.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dialog for specifying a new project. This dialog is only responsible to
 * collect information from the user. All project construction continues within
 * the workbench control frame.
 *
 * @author Del Davis
 * @version 0.1
 */
public class NewProjectDialog extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isRunning = false;
	private Logger LOG = Logger.getLogger(NewProjectDialog.class.getName());

	// <editor-fold defaultstate="collapsed" desc="Auto-Generated Code">

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		newProjectNameLabel = new javax.swing.JLabel();
		newProjectNameTextField = new javax.swing.JTextField();
		newProjectOKButton = new javax.swing.JButton();
		newProjectCancelButton = new javax.swing.JButton();
		newProjectSpecificationDirectionsLabel = new javax.swing.JLabel();
		newProjectValidationMessageLabel = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		provenanceEnabledCheckbox = new javax.swing.JCheckBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("New Project Specification");
		setLocationByPlatform(true);
		setModal(true);

		newProjectNameLabel.setText("Project Name: ");

		newProjectNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				newProjectNameTextFieldKeyReleased(evt);
			}
		});

		newProjectOKButton.setText("OK");
		newProjectOKButton.setEnabled(false);
		newProjectOKButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newProjectOKButtonActionPerformed(evt);
			}
		});

		newProjectCancelButton.setText("Cancel");
		newProjectCancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newProjectCancelButtonActionPerformed(evt);
			}
		});

		newProjectSpecificationDirectionsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		newProjectSpecificationDirectionsLabel.setText("Provide a new project name");

		jLabel1.setText("<html><p style=\"color:orange\">* Using the output file basename is recommended</p></html>");

		provenanceEnabledCheckbox.setSelected(true);
		provenanceEnabledCheckbox.setText("Provenance Support Enabled");
		provenanceEnabledCheckbox.setToolTipText(
				"<html>Warning: Select carefully.<br>This is permanent for the project<br>(i.e. you cannot turn provenance support<br>on and off after a project is specified)</html>");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(newProjectSpecificationDirectionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(provenanceEnabledCheckbox)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(newProjectOKButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(newProjectCancelButton))
						.addGroup(layout.createSequentialGroup().addComponent(newProjectNameLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(newProjectNameTextField))
						.addComponent(newProjectValidationMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(newProjectSpecificationDirectionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								19, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(newProjectNameLabel).addComponent(newProjectNameTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(newProjectOKButton).addComponent(provenanceEnabledCheckbox))
								.addComponent(newProjectCancelButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(newProjectValidationMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Validates the currently entered text from the project name field
	 *
	 * Note: In order to be considered valid, the project name must also be a valid
	 * filename. This function relies on a static method of the
	 * edu.uwb.braingrid.provenance.ProvMgr class
	 *
	 * @param evt
	 *            - The event that triggered this action
	 */
	private void newProjectNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_newProjectNameTextFieldKeyReleased
		/* Redirect to OK button action if enter key */
		if (validateNewProjectName()) {
			if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
				newProjectOKButtonActionPerformed(null);
			}
		}
	}// GEN-LAST:event_newProjectNameTextFieldKeyReleased

	/**
	 * Cancel the new project specification operation
	 *
	 * @param evt
	 *            - The event that triggered this action (cancel button clicked)
	 */
	private void newProjectCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newProjectCancelButtonActionPerformed
		isRunning = false;
		setVisible(false);
	}// GEN-LAST:event_newProjectCancelButtonActionPerformed

	/**
	 * Executes the specification of the new project
	 *
	 * @param evt
	 *            - The event that triggered this action
	 */
	private void newProjectOKButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newProjectOKButtonActionPerformed
		specifyNewProject();
	}// GEN-LAST:event_newProjectOKButtonActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JButton newProjectCancelButton;
	private javax.swing.JLabel newProjectNameLabel;
	private javax.swing.JTextField newProjectNameTextField;
	private javax.swing.JButton newProjectOKButton;
	private javax.swing.JLabel newProjectSpecificationDirectionsLabel;
	private javax.swing.JLabel newProjectValidationMessageLabel;
	private javax.swing.JCheckBox provenanceEnabledCheckbox;
	// End of variables declaration//GEN-END:variables
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Custom Members">
	private boolean success = false;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Construction">
	/**
	 * Constructs and initializes this new project dialog
	 *
	 * @param modal
	 *            - True if the parent should be disabled while this dialog is open,
	 *            otherwise false
	 */
	public NewProjectDialog(boolean modal) {
		LOG.info("Opening New Project Dialog for Sim Starter");
		initComponents();
		setModal(modal);
		isRunning = true;
		// show window center-screen
		center();
		setVisible(true);
	}

	/**
	 * Centers this dialog
	 */
	private void center() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Action Helpers">
	/**
	 * Validates the project name against file system naming requirements.
	 *
	 * Note: This method relies on a static call to the ProvMgr class within the
	 * ../../provenance/ package.
	 *
	 * @param name
	 *            - A project name, and implicitly the basename for the resulting
	 *            provenance turtle file
	 * @return true if this project name is a valid file basename, otherwise false
	 */
	private boolean validateNewProjectName() {
		boolean valid = true;
		/* Validate the currently specified project name */
		if (!isValidFileName(newProjectNameTextField.getText())) {
			valid = false;
			// disable the ok button
			newProjectOKButton.setEnabled(false);
			// set error msg
			newProjectValidationMessageLabel.setText("<html>" + "<p style=\"color:red\"><b>"
					+ "Project name specified must be valid filename" + "</b></p></html>");
		} else {
			// enable the ok button
			newProjectOKButton.setEnabled(true);
			newProjectValidationMessageLabel.setText(null);
		}
		return valid;
	}

	private void specifyNewProject() {
		success = true;
		isRunning = false;
		setVisible(false);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Getters">
	/**
	 * Provides the name of the new project
	 *
	 * @return The name of the new project
	 */
	public String getProjectName() {
		return newProjectNameTextField.getText().replaceAll("\\s+", "_");
	}

	/**
	 * Indicates whether or not provenance support should be enabled for this
	 * project
	 *
	 * @return True if provenance support should be enabled for this project,
	 *         otherwise false
	 */
	public boolean isProvEnabled() {
		return provenanceEnabledCheckbox.isSelected();
	}

	/**
	 * Indicates whether or not the user closed the dialog by selecting the OK
	 * option for creating a new project, or the Cancel option for canceling the
	 * operation
	 *
	 * @return True if the user selected OK, otherwise false
	 */
	public boolean getSuccess() {
		return success;
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Utility Functions">
	/**
	 * Performs a check on string representing a filename for adherence to Windows
	 * filename conventions. Windows need not be the platform that this function is
	 * concerned with, it just happens to have the most restrictions on filename
	 * characters
	 *
	 * @param fileName
	 *            - string representing a filename
	 * @return True if the filename specified was valid, False if not
	 */
	private static boolean isValidFileName(String fileName) {
		Pattern pattern = Pattern.compile(
				"# Match a valid Windows filename (unspecified file system).          \n"
						+ "^                                # Anchor to start of string.        \n"
						+ "(?!                              # Assert filename is not: CON, PRN, \n"
						+ "  (?:                            # AUX, NUL, COM1, COM2, COM3, COM4, \n"
						+ "    CON|PRN|AUX|NUL|             # COM5, COM6, COM7, COM8, COM9,     \n"
						+ "    COM[1-9]|LPT[1-9]            # LPT1, LPT2, LPT3, LPT4, LPT5,     \n"
						+ "  )                              # LPT6, LPT7, LPT8, and LPT9...     \n"
						+ "  (?:\\.[^.]*)?                  # followed by optional extension    \n"
						+ "  $                              # and end of string                 \n"
						+ ")                                # End negative lookahead assertion. \n"
						+ "[^<>:\"/\\\\|?*\\x00-\\x1F]*     # Zero or more valid filename chars.\n"
						+ "[^<>:\"/\\\\|?*\\x00-\\x1F\\ .]  # Last char is not a space or dot.  \n"
						+ "$                                # Anchor to end of string.            ",
				Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
		Matcher matcher = pattern.matcher(fileName);
		boolean isMatch = matcher.matches();
		return isMatch;
	}
	// </editor-fold>

	public boolean isRunning() {
		return isRunning;
	}
}
