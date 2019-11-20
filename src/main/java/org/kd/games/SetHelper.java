package org.kd.games;

import java.util.Set;

public class SetHelper {

    public boolean setContainsAnyOther(Set set, Object object){
        for (Object o : set){
            if (!o.equals(object))
                return true;
        }
        return false;
    }
}
