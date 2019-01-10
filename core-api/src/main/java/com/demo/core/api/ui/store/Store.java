package com.demo.core.api.ui.store;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

/**
 * @author Vasili Chyrvon (vasili.chyrvon@gmail.com)
 */
final class Store {

    static final Store INSTANCE = new Store();
    private Map<String, Outlasting> outlastingMap = new HashMap<>();

    private Store() {
    }

    /**
     * Returns stored or newly created Outlasting
     *
     * @param creator creator to instantiate the Outlasting if the map doesn't contain it.
     * @param tag     store tag. The same outlasting will be returned for the same tag,
     *                so tag must be unique for different callers.
     */
    <T extends Outlasting> T getOutlasting(@NonNull Outlasting.Creator<T> creator, @NonNull String tag) {

        if (!outlastingMap.containsKey(tag)) {
            T outlasting = creator.createOutlasting();
            outlasting.onCreate();
            outlastingMap.put(tag, outlasting);
        }

        //noinspection unchecked
        return (T) outlastingMap.get(tag);
    }

    /**
     * Removes the Outlasting for the passed tag from the store, allowing it to be destroyed.
     *
     * @param tag store tag to remove the Outlasting.
     */
    void removeOutlasting(@NonNull String tag) {
        Outlasting outlasting = outlastingMap.get(tag);

        if (outlasting != null) {
            outlasting.onDestroy();
            outlastingMap.remove(tag);
        }
    }
}