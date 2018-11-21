package demo.com.utils.ui;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import demo.com.utils.store.FragmentOutlast;

public abstract class BaseFragment<T extends FeatureComponent> extends Fragment {

    // To let T outlast the configuration changes.
    private FragmentOutlast<T> outlast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the outlast delegate providing Outlasting and instance state.
        outlast = new FragmentOutlast<>(
                this,
                () -> provideComponent(getArguments()),
                savedInstanceState
        );
        //noinspection unchecked
        outlast.getOutlasting().inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        outlast.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        outlast.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outlast.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        outlast.onDestroy();
    }

    /**
     * Returns stored Presentation Model for this fragment.
     * Call it only after onCreate().
     *
     * @return Presentation Model
     */
    @NonNull
    protected T getComponentHolder() {
        // Get the outlasting T from storage.
        return outlast.getOutlasting();
    }

    /**
     * Provide presentation model to use with this fragment.
     */
    protected abstract T provideComponent(@Nullable Bundle arguments);

    protected Application getApplication() {
        return requireActivity().getApplication();
    }

}