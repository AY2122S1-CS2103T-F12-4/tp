package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Represents for Controlling a help page
 */
public class HelpWindow extends UiPart<Stage> {
    /**
     * Stands for help window URL to tP web page.
     */
    public static final String OFFICIAL_URL =
            "https://ay2122s1-cs2103t-f12-4.github.io/tp/";

    /**
     * Stands for help command message.
     */
    public static final String HELP_MESSAGE = "Features:\n"
            + "Add member: add -mem -n <NAME> -p <PHONE> -e <EMAIL> -a <ADDRESS>\n"
            + "Search by name: find -mem -n <NAME>\n"
            + "Search by phone: find -mem -p <PHONE>\n"
            + "Search by email: find -mem -e <EMAIL>\n"
            + "Search by registration date: find -mem -d <REGISTRATION_DATE>\n"
            + "Search by member ID: find -mem -id <MEMBER_ID>\n"
            + "Adding transaction: add -txn -b <BILLING> -id <MEMBER_ID>\n"
            + "View member: show -mem -id <MEMBER_ID>\n"
            + "Delete member: del -mem -id <MEMBER_ID>\n"
            + "Add Reservation: add -rsvn -time <DATETIME> -rm <REMARK> -id <MEMBER_ID>\n"
            + "Delete Reservation: del -rsvn -id 10001100001\n"
            + "Redeem points: redeem -f <POINTS> -id <MEMBER_ID>\n"
            + "Exit Application: exit\n"
            + "To view full user guide: " + OFFICIAL_URL;

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Constructs a new {@code HelpWindow}.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
    }

    /**
     * Constructs a new {@code HelpWindow}.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(OFFICIAL_URL);
        clipboard.setContent(url);
    }
}
