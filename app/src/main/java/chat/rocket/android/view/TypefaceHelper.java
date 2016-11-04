package chat.rocket.android.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

/**
 * Helper for reading typeface.
 * ref：https://code.google.com/p/android/issues/detail?id=9904#c7
 */
public class TypefaceHelper {
    private static final String TAG = TypefaceHelper.class.getName();

    private static final Hashtable<String, Typeface> CACHE = new Hashtable<String, Typeface>();

    /**
     * read font in assets directory.
     */
    public static Typeface getTypeface(Context c, String assetPath) {
        synchronized (CACHE) {
            if (!CACHE.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(),
                            assetPath);
                    CACHE.put(assetPath, t);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get typeface '" + assetPath
                            + "' because " + e.getMessage());
                    return null;
                }
            }
            return CACHE.get(assetPath);
        }
    }
}
