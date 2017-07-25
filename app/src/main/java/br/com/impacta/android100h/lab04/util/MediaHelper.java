package br.com.impacta.android100h.lab04.util;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by no3603 on 17/07/2017.
 */

public class MediaHelper{

    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;

    public MediaHelper() {
        super();
    }

    private static File getOutputMediaFile(final int type){
        File path,dir;
        String timeStamp;

        File mediaFile = null;

        path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        dir = new File(path,"impacta");

        if (!dir.exists()){
            if (!dir.mkdirs()){
                Log.d("LAB04","pasta nao criada");
                return mediaFile;
            }
        }

        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        switch (type){
            case TYPE_IMAGE:
                mediaFile = new File(String.format("%s%sIMG_%s.jpg", dir.getPath(), File.separator, timeStamp));
                break;
            case TYPE_VIDEO:
                mediaFile = new File(String.format("%s%sVID_%s.mp4", dir.getPath(), File.separator, timeStamp));
                break;
            default:
                mediaFile = null;
                break;
        }

        return mediaFile;
    }

    public static Uri getOutputMediaFileUri(int type){
        return Uri.EMPTY.fromFile( getOutputMediaFile(type) );
    }

    public static Uri getOutputMediaVideoFileUri(){
        return getOutputMediaFileUri(TYPE_VIDEO);
    }

    public static Uri getOutputMediaImageFileUri(){
        return getOutputMediaFileUri(TYPE_IMAGE);
    }

}
