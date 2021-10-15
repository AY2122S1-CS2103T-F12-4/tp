package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyAccount;
import seedu.address.model.ReadOnlyEzFoodie;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of EzFoodie data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private AccountStorage accountStorage;
    private EzFoodieStorage ezFoodieStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code AccountStorage}, {@code ezFoodieStorage}
     * and {@code UserPrefStorage}.
     */
    public StorageManager(AccountStorage accountStorage, EzFoodieStorage ezFoodieStorage,
            UserPrefsStorage userPrefsStorage) {
        super();
        this.accountStorage = accountStorage;
        this.ezFoodieStorage = ezFoodieStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }

    // ================== Account methods ===============================

    @Override
    public Path getAccountFilePath() {
        return accountStorage.getAccountFilePath();
    }

    @Override
    public Optional<ReadOnlyAccount> readAccount() throws DataConversionException, IOException {
        return accountStorage.readAccount();
    }

    @Override
    public Optional<ReadOnlyAccount> readAccount(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read account from file: " + filePath);
        return accountStorage.readAccount(filePath);
    }

    @Override
    public void saveAccount(ReadOnlyAccount account) throws IOException {
        accountStorage.saveAccount(account);
    }

    @Override
    public void saveAccount(ReadOnlyAccount account, Path filePath) throws IOException {
        logger.fine("Attempting to write to account file: " + filePath);
        accountStorage.saveAccount(account, filePath);
    }

    // ================== EzFoodie methods ===============================

    @Override
    public Path getEzFoodieFilePath() {
        return ezFoodieStorage.getEzFoodieFilePath();
    }

    @Override
    public Optional<ReadOnlyEzFoodie> readEzFoodie() throws DataConversionException, IOException {
        return readEzFoodie(ezFoodieStorage.getEzFoodieFilePath());
    }

    @Override
    public Optional<ReadOnlyEzFoodie> readEzFoodie(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return ezFoodieStorage.readEzFoodie(filePath);
    }

    @Override
    public void saveEzFoodie(ReadOnlyEzFoodie ezFoodie) throws IOException {
        saveEzFoodie(ezFoodie, ezFoodieStorage.getEzFoodieFilePath());
    }

    @Override
    public void saveEzFoodie(ReadOnlyEzFoodie ezFoodie, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        ezFoodieStorage.saveEzFoodie(ezFoodie, filePath);
    }

}
