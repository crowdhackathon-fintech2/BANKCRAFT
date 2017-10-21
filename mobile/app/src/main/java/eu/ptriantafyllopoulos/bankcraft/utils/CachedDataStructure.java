package eu.ptriantafyllopoulos.bankcraft.utils;

import java.util.HashMap;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class CachedDataStructure {

    private HashMap<String,String> varHashMap;
    private HashMap<String, Object> objectHashMap;

    public CachedDataStructure() {
        varHashMap = new HashMap<>();
        objectHashMap = new HashMap<>();
    }

    public HashMap<String, String> getVarHashMap() {
        return varHashMap;
    }

    public HashMap<String, Object> getObjectHashMap() {
        return objectHashMap;
    }

    /**
     * Function to clear global cache
     **/
    public void clearCache(){
        varHashMap.clear();
        objectHashMap.clear();
    }
}
