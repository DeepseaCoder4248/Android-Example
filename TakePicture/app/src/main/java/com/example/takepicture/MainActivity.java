package com.example.takepicture;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //객체
    private static final int REQUEST_IMAGE_CAPTURE = 1; // 응답코드 int 값이고 값은 1이다. 응답코드를 int 객체화 해서 사용가능.
    Button btnCamera; // 카메라 동작 버튼
    private Uri photoUri; // 얘가 왜 여기 있는가?
    private String imageFilePath; // 얘는 또 왜 여기냐?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 연동w
        btnCamera = findViewById(R.id.btn_camera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTakePhotoIntent();
            }
        });
    }

    // 카메라를 찍을 수 있게 요청하는 인텐트다.
    private void sendTakePhotoIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // MediaStore(미디어 연결 I/F)에 캡쳐 기능을 액세스.
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) { //암시적 인텐트는 start로 할 시 값이 없으므로 에러가 뜬다. Intent가 Null값이면 resolveActivity를 한다. !=는 다른가요? 라는 의미다.
            File photoFile = null; //?

            // try안에서 예외(실행중 오류)가 발생하면 catch블록이 실행됨, 정상적이라면 catch 실행안됨
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {

            }
            if (photoFile != null) { //?
                photoUri = FileProvider.getUriForFile(this, getPackageName(), photoFile); // 눈금 잘 보기
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }
    // 카메라로 사진 찍어 이미지 띄우기.
//    public void sendTakePhotoIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // 미디어스토어(미디어저장소?)를 이미지 캡쳐 액션(카메라) 실행.
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) { // ?
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE); // 객체화된 응답코드를 전달한다.
//        }
//    }


    // 카메라로 사진 찍어 이미지 띄우기.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            ImageView ivvv = findViewById(R.id.img_photo);
            ivvv.setImageURI(photoUri);

//            ((ImageView) findViewById(R.id.img_photo)).setImageURI(photoUri); // FindViewId로 썸네일을 보여줄 View 연동 후 setImageBitmap 메소드로 썸네일을 지정한다.
        }

    }




    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); // 날짜를 원하는 포맷값으로 보여준다. String a = new SimpleDateFormat으로 객체를 생성해서 String 변수에 저장한다.
        String imageFileName = "TEST_" + timeStamp + "_"; // 
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                "jpg",
                storageDir
        );
        imageFilePath = image.getAbsolutePath();
        return image;
    }
}



