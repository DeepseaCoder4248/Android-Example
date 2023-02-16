package com.puresoftware.listenerevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5;

    // 3.View.Onclick Listenr 상속받고 하는 것.
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "btn3", Toast.LENGTH_SHORT).show();
    }

    View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);

        // 1 바로 불러오기
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "btn1", Toast.LENGTH_SHORT).show();
            }
        });


        btn3.setOnClickListener(this);
        btn4.setOnClickListener(buttonClick);
        btn5.setOnClickListener(new MyOnClick());
    }

    class MyOnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }
    }


    // 2 ,mylayoout의 btn2를 onclick로 연결한 기능.이거 잘 안쓴다고 함.
    public void button2Clicked(View view) {
        String str;
        Button btn = (Button) view; // Button은 View의 자식 객체임을 기억. 부모가 자식으로 바꾸려면 강제변환 캐스팅을 해야 한다.
        str = btn.getText().toString() + "클릭";

        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}