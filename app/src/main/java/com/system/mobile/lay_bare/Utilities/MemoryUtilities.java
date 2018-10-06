package com.system.mobile.lay_bare.Utilities;

/**
 * Created by paolohilario on 5/10/18.
 */

public class MemoryUtilities {

    public static final float BYTES_IN_MB = 1024.0f * 1024.0f;


    public static float megabytesFree(){
        final Runtime rt        = Runtime.getRuntime();
        final float bytesused   = rt.totalMemory();
        final float mbUsed      = bytesused / BYTES_IN_MB;
        final float mbFree      = megabytesAvailable() - mbUsed;
        return mbFree;
    }

    public static float megabytesAvailable(){
        final Runtime rt             = Runtime.getRuntime();
        final float bytesAvailable  = rt.maxMemory();
        return bytesAvailable / BYTES_IN_MB;
    }


}