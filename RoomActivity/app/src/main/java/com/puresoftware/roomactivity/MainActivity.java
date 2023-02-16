package com.puresoftware.roomactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnDelete;
    Button btnLoad;
    Button btnReturn;
    Button btnUpdate;

    EditText edtFirstName;
    EditText edtLastName;
    EditText edtUid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btn_insert);
        btnDelete = findViewById(R.id.btn_delete);
        btnLoad = findViewById(R.id.btn_load);
        btnReturn = findViewById(R.id.btn_return);
        btnUpdate = findViewById(R.id.btn_update);
        edtFirstName = findViewById(R.id.edt_firstname);
        edtLastName = findViewById(R.id.edt_lastname);
        edtUid = findViewById(R.id.edt_uid);

        AppDatabass db = AppDatabass.getInstance(this);
//        addUser.uid = 1;

        UserDao userDao = db.userDao();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("TAG", "inserted");

                        User user = new User();
                        user.firstName = firstname();
                        user.lastName = lastname();
                        userDao.insert(user);
                    }
                }).start();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("TAG", "loaded");

                        List<User> users = userDao.getAll();
                        Log.i("TAG", "count:" + users.size());

                        for (User user : users) {
                            Log.i("TAG", user.toString()); // toString 스킬을 적극적 활용하기
                        }
                    }
                }).start();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

//                        User user = new User();
//                        user.firstName = firstname();
//                        user.lastName = lastname();
//
//                        for (User users : userDao.getAll()) {
//                            if (users.lastName.equals(user.lastName) && users.firstName.equals(user.firstName)) {
//                                userDao.delete(users);
//                                break;
//                            }
//                        }

                        String firstName = firstname();
                        userDao.deleteByName(firstName);
                    }
                }).start();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        User user = userDao.findByName(firstname(), lastname());
                        Log.i("TAG", user.toString());


                    }
                }).start();

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1) uid값 입력한거 가져오기
                // 2) firstNAme 입력한거 가져오기

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        userDao.updateFirstName(Integer.parseInt(edtUid.getText().toString()), edtFirstName.getText().toString());


                    }
                }).start();

                Runnable r1 = new Runnable() {
                    @Override
                    public void run() {
//                        code
                    }
                };
                
//                MyRunnable my1 = new MyRunnable();
                
                // 업캐스팅, 다운캐스팅, 익명클래스, 인터페이스, 추상클래스
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("gugu", "runrun");
                    }
                }).start();

            }
        });
    }

    public String firstname() {
        String string = edtFirstName.getText().toString();

        if (string.equals("")) {
            Toast.makeText(MainActivity.this, "첫 이름을 입력해주세요", Toast.LENGTH_SHORT).show();
            return "no";
        } else {
            return string;
        }
    }

    public String lastname() {
        String string = edtLastName.getText().toString();

        if (string.equals("")) {
            Toast.makeText(MainActivity.this, "마지막 이름을 입력해주세요", Toast.LENGTH_SHORT).show();
            return "no";
        } else {
            return string;
        }
    }
}

// orm: 데이터베이스를 객체를 통해서 접근한다.
// DAO,CRUD: