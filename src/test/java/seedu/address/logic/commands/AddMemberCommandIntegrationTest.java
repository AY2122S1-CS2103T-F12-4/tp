package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalMembers.getTypicalEzFoodie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.member.Member;
import seedu.address.testutil.MemberBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddMemberCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalEzFoodie(), new UserPrefs());
    }

    @Test
    public void execute_newMember_success() {
        Member validMember = new MemberBuilder().build();

        Model expectedModel = new ModelManager(model.getEzFoodie(), new UserPrefs());
        expectedModel.addMember(validMember);

        assertCommandSuccess(new AddMemberCommand(validMember), model,
                String.format(AddMemberCommand.MESSAGE_SUCCESS, validMember), expectedModel);
    }

    @Test
    public void execute_duplicateMember_throwsCommandException() {
        Member memberInList = model.getEzFoodie().getMemberList().get(0);
        assertCommandFailure(new AddMemberCommand(memberInList), model, AddMemberCommand.MESSAGE_DUPLICATE_MEMBER);
    }

}
