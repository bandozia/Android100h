package br.com.impacta.android100h.lab04.app.controller;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import br.com.impacta.android100h.R;
import br.com.impacta.android100h.lab01.app.controller.ImpactaActivity;
import br.com.impacta.android100h.lab04.util.MediaHelper;

public class IntentActivity extends ImpactaActivity{

    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    public static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;

    private Button btIMAGEM;
    private Button btVIDEO;
    private FrameLayout flCAMERA;

    private Resources r;
    private Uri fileUri;

    private class ImagemOnClickAction implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            fileUri = MediaHelper.getOutputMediaImageFileUri();
            i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    private class VideoOnClickAction implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            fileUri = MediaHelper.getOutputMediaVideoFileUri();
            Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

            i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(i, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab04_camera);

        r = getResources();
        btIMAGEM = getViewById(R.id.lab04_bt_imagem_capturar);
        btVIDEO = getViewById(R.id.lab04_bt_video_capturar);
        flCAMERA = getViewById(R.id.lab04_fl_camera);

        btIMAGEM.setOnClickListener(new ImagemOnClickAction());
        btVIDEO.setOnClickListener(new VideoOnClickAction());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String message = null;
        flCAMERA.removeAllViews();

        switch (requestCode){
            case CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE:

                switch (resultCode){
                    case RESULT_OK:

                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 8;

                        //Bitmap d = (Bitmap) data.getExtras().get("data");
                        Bitmap d = BitmapFactory.decodeFile(fileUri.getPath(),options);
                        ImageView ivData = new ImageView(this);
                        ivData.setImageBitmap(d);
                        btIMAGEM.setBackgroundColor(Color.GREEN);
                        btVIDEO.setBackgroundColor(Color.LTGRAY);
                        flCAMERA.addView(ivData);
                        break;
                    case RESULT_CANCELED:
                        message = r.getString(R.string.lab04_toast_imagem_cancelada);
                        break;
                }

                break;
            case CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE:

                    switch (resultCode){
                        case RESULT_OK:
                            //Uri uri = data.getData();
                            VideoView vvData = new VideoView(this);
                            MediaController mc = new MediaController(this);

                            FrameLayout.LayoutParams lpParams = new FrameLayout.LayoutParams(
                                    FrameLayout.LayoutParams.MATCH_PARENT,
                                    FrameLayout.LayoutParams.WRAP_CONTENT
                            );

                            lpParams.gravity = Gravity.CENTER;

                            vvData.setLayoutParams(lpParams);
                            vvData.setMediaController(mc);
                            vvData.setVideoPath(fileUri.getPath());

                            btIMAGEM.setBackgroundColor(Color.LTGRAY);
                            btVIDEO.setBackgroundColor(Color.GREEN);
                            flCAMERA.addView(vvData);
                            break;
                        case RESULT_CANCELED:
                            message = r.getString(R.string.lab04_toast_video_cancelada);
                            break;
                    }

                break;
        }

        if (message != null){
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

    }
}
