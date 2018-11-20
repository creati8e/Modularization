package demo.com.componentstore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author Vasili Chyrvon (vasili.chyrvon@gmail.com)
 */
public class FragmentOutlast<T extends Outlasting> extends Outlast<T> {

    private Fragment fragment;

    FragmentOutlast(
            @NonNull Fragment fragment,
            @NonNull Outlasting.Creator<T> creator,
            @Nullable Bundle savedInstanceState
    ) {
        super(creator, savedInstanceState);
        this.fragment = fragment;
    }

    @Override
    protected boolean isPrincipalFinishing(boolean wasInstanceStateSaved) {
        boolean isActivityFinishing = fragment.requireActivity().isFinishing();
        return isActivityFinishing || !wasInstanceStateSaved && isFragmentOrParentRemoving();
    }

    private boolean isFragmentOrParentRemoving() {
        // See http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
        return fragment.isRemoving() || isAnyParentOfFragmentRemoving();
    }

    // See https://github.com/Arello-Mobile/Moxy/issues/24
    private boolean isAnyParentOfFragmentRemoving() {
        boolean isAnyParentRemoving = false;

        Fragment parent = fragment.getParentFragment();
        while (!isAnyParentRemoving && parent != null) {
            isAnyParentRemoving = parent.isRemoving();
            parent = parent.getParentFragment();
        }
        return isAnyParentRemoving;
    }
}