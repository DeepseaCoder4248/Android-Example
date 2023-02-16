package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.puresoftware.kotlinactivity.R

class MenuActivity : AppCompatActivity() {

    val TAG = MenuActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar)

        Log.i(TAG, "MenuActivity start")


    }

    // Action Bar 옆에 back Button 누르면 특수한 Event 실행
    // Menifest에서 해당 Activity에 android:parentActivityName=".MainActivity" 이 되어 있어야 함.
    override fun onSupportNavigateUp(): Boolean {
        Log.i(TAG, "뒤로가기 누름") // 특수한 기능
        return super.onSupportNavigateUp()
    }

    // Action Bar 오른쪽에 Menu Button 추가
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // menu list들을 생성. list가 없으니 생각보다 편하게 만들 수있다.
        val menuItem1 = menu?.add(0, 0, 0, "menu1")
        val menuItem2 = menu?.add(0, 1, 0, "menu2")
        val menuItem3 = menu?.add(0, 2, 0, "menu3")

        // menu를 xml로 custom한 것
        menuInflater.inflate(R.menu.menu_main, menu)

        // search vie 기능
        val menuItem = menu?.findItem(R.id.menu_search) // id 가져오기
        val searchView = menuItem?.actionView as SearchView // action view를 가져오지만 casting을 햄
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener { // text를 입력하면 실시간으로 검색되는 것.
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })


        return super.onCreateOptionsMenu(menu)
    }

    // Menu의 Item을 설정하면 나오는 것.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> Log.i(TAG, "메뉴 1번")
            1 -> Log.i(TAG, "메뉴 2번")
            2 -> Log.i(TAG, "메뉴 3번")
        }
        return super.onOptionsItemSelected(item)
    }
}