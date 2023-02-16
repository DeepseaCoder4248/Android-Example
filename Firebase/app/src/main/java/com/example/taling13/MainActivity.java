package com.example.taling13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {


    EditText edtId; // 아이디 입력
    EditText edtPW; // 비밀번호 입력
    Button btnLogin; // 로그인 버튼
    Button btnRegister; // 가입 버튼
    TextView tvCheck; // 아이디 및 비밀번호가 일치한지 체크해주는 변수.

    String loginGetID; // 입력받은 ID
    String loginGetPW; // 입력받은 PW

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //연동
        final FirebaseFirestore db = FirebaseFirestore.getInstance(); // FireBase 객체 생성.

        edtId = findViewById(R.id.edt_id);
        edtPW = findViewById(R.id.edt_pw);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        tvCheck = findViewById(R.id.tv_checkIDPW);

        tvCheck.setVisibility(View.INVISIBLE); // 아디 및 비밀번호가 확인되지 않은 상태를 유지하기 위해 INVISIBLE.

        // 로그인
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginGetID = edtId.getText().toString(); // 입력된 ID를 저장.
                loginGetPW = edtPW.getText().toString(); // 입력된 PW를 저장.

                // 로그인 검증
                db.collection("userInfo") // userInfo의 Collection 호출하기.
                        .get() // 받아오기.
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                for (QueryDocumentSnapshot document : task.getResult()) { // document의 길이만큼 document의 정보를 가져온다.(userInfo의 모든 정보들)

                                    // ID, PW가 일치하면 메인 화면으로, 아니면 로그인 취소.
                                    if (document.getId().equals(loginGetID) && document.getData().get("pw").equals(loginGetPW)) { // getId.get()는 userInfo의 docment 정보를 가져오고, getData.get("필드 이름")는 field의 정보를 가져온다.
                                        Intent intent = new Intent(MainActivity.this, BoardActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        tvCheck.setVisibility(View.VISIBLE); // VISIBLE
                                        tvCheck.setText("아이디 및 비밀번호가 일치하지 않습니다."); // 일치하지 않다는 문구 표시.
                                    }
                                }
                            }
                        });
            }
        });
    }
}