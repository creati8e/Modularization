package demo.com.componentstore;

/**
 * @author Vasili Chyrvon (vasili.chyrvon@gmail.com)
 */
public interface Outlasting {

    /**
     * Called when this Outlasting is created
     */
    void onCreate();

    /**
     * Called before this Outlasting is about to be destroyed
     */
    void onDestroy();

    /**
     * Outlasting creation interface.
     */
    interface Creator<T extends Outlasting> {

        /**
         * Creates the Outlasting
         */
        T createOutlasting();
    }

}