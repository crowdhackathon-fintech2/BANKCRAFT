package eu.ptriantafyllopoulos.bankcraft.utils;

import java.util.HashMap;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class RuntimeStorage {
    /*the singleton instance*/
    private static RuntimeStorage myStore = null;
    /*the cached data stracture*/
    private CachedDataStructure cachedDataStructure;

    public static RuntimeStorage getInstance() {
        if (myStore == null) {
            myStore = new RuntimeStorage();
        }
        return myStore;
    }

    /**
     * Private constructor
     */
    private RuntimeStorage() {
        //Empty implementation
    }

    public void setCachedDataStructure(CachedDataStructure cachedDataStructure) {
        this.cachedDataStructure = cachedDataStructure;
    }

    public CachedDataStructure getCachedDataStructure() {
        if (cachedDataStructure == null) {
            cachedDataStructure = new CachedDataStructure();
        }
        return cachedDataStructure;

    }

    /**
     * Get the object hash map
     *
     * @return the object hash map
     */
    public HashMap<String, Object> getObjectHashMap() {
        return getCachedDataStructure().getObjectHashMap();
    }


    /**
     * Put Dao to dao hash map
     *
     * @param key    the key
     * @param object the object
     */
    public void put(String key,
                    Object object) {
        getCachedDataStructure().getObjectHashMap().put(key, object);
    }


    /**
     * Get the Object from the object hash map
     *
     * @param key the key
     * @return the Object found or null
     */
    @SuppressWarnings("unchecked")
    public Object getObject(String key) {
        try {
            return getCachedDataStructure().getObjectHashMap().get(key);
        } catch (ClassCastException e) {
            return null;
        }
    }


    /**
     * Get the variable hash map
     *
     * @return the varialbe hash map
     */
    public HashMap<String, String> getVariableHashMap() {
        return getCachedDataStructure().getVarHashMap();
    }

    /**
     * Put value to variable hash map
     *
     * @param key   the key
     * @param value the value
     */
    public void put(String key, String value) {
        getCachedDataStructure().getVarHashMap().put(key, value);
    }

    /**
     * Get the variable from the variable hash map
     *
     * @param key the key
     * @return the variable found or null
     */
    public String getVariable(String key) {
        return getCachedDataStructure().getVarHashMap().get(key);
    }

    /**
     * clear the singleton
     */
    public void clear() {
        getCachedDataStructure().clearCache();
    }
}
