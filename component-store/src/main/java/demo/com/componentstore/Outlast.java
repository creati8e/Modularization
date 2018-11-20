package demo.com.componentstore;

import android.os.Bundle;

import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Vasili Chyrvon (vasili.chyrvon@gmail.com)
 */
@SuppressWarnings("WeakerAccess")
public abstract class Outlast<T extends Outlasting> {

    private static final String SAVED_OUTLASTING_TAG = "outlasting_tag_";
    private final String savedOutlastingTagKey;
    private String outlastingTag;
    private Outlasting.Creator<T> creator;
    private boolean wasInstanceStateSaved;

    /**
     * Constructs Outlast.
     *
     * @param creator            to use if {@link Outlasting} isn't created yet.
     * @param savedInstanceState to restore saved tag of the Outlasting.
     */
    public Outlast(@NonNull Outlasting.Creator<T> creator, @Nullable Bundle savedInstanceState) {
        this(creator, savedInstanceState, 0);
    }

    /**
     * Constructs Outlast with id. Useful when one class has multiple Outlasts inside it.
     *
     * @param creator            to use if {@link Outlasting} isn't created yet.
     * @param savedInstanceState to restore saved tag of the Outlasting.
     * @param outlastId          id for this Outlast. Needed for distinguish saved outlasting tags.
     */
    public Outlast(
            @NonNull Outlasting.Creator<T> creator,
            @Nullable Bundle savedInstanceState,
            int outlastId
    ) {
        this.creator = creator;
        savedOutlastingTagKey = SAVED_OUTLASTING_TAG + outlastId;
        outlastingTag = obtainOutlastingTag(savedInstanceState);
    }

    /**
     * Get the {@link Outlasting} stored by this Outlast delegate.
     */
    public T getOutlasting() {
        return Store.INSTANCE.getOutlasting(creator, outlastingTag);
    }

    /**
     * Delegated callback.
     */
    public void onStart() {
        wasInstanceStateSaved = false; // reset because we started after save and stop
    }

    /**
     * Delegated callback.
     */
    public void onResume() {
        wasInstanceStateSaved = false; // reset because we resumed after save when paused
    }

    /**
     * Delegated callback.
     */
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(savedOutlastingTagKey, outlastingTag);
        wasInstanceStateSaved = true;
    }

    /**
     * Delegated callback.
     */
    public void onDestroy() {
        if (isPrincipalFinishing(wasInstanceStateSaved)) {
            Store.INSTANCE.removeOutlasting(outlastingTag);
        }
    }

    /**
     * Return true if the Outlast's principal is finishing
     * and the {@link Outlasting} must be destroyed (removed from the store).
     *
     * @param wasInstanceStateSaved true if instance state was saved.
     */
    protected abstract boolean isPrincipalFinishing(boolean wasInstanceStateSaved);

    /**
     * Creates unique tag that is using to store the {@link Outlasting} in the store.
     */
    protected String createOutlastingTag() {
        return UUID.randomUUID().toString();
    }

    private String obtainOutlastingTag(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return createOutlastingTag();
        } else {
            return savedInstanceState.getString(savedOutlastingTagKey);
        }
    }
}