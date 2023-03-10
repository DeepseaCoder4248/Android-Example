package com.puresoftware.bottomnavigationappbar

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.core.view.get
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.puresoftware.bottomnavigationappbar.CenterWeggle.CenterWeggleFragment
import com.puresoftware.bottomnavigationappbar.Home.HomeFragment
import com.puresoftware.bottomnavigationappbar.MyAccount.MyAccountFragment
import com.puresoftware.bottomnavigationappbar.Weggler.WegglerFragment
import com.puresoftware.bottomnavigationappbar.brands.BrandsFragment
import com.puresoftware.bottomnavigationappbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // fragment
    // https://aries574.tistory.com/382
    var homeFragment: HomeFragment? = null // 홈
    var brandsFragment: BrandsFragment? = null // 브랜드관
    var centerWeggleFragment: CenterWeggleFragment? = null // 메인
    var wegglerFragment: WegglerFragment? = null // 위글러
    var myAccountFragment: MyAccountFragment? = null // 내 정보
    var fragmentManager: FragmentManager? = null // Fragment
    var transaction: FragmentTransaction? = null // Fragment

    val TAG: String = MainActivity::class.java.simpleName // 태그

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 투명 Status 만들기
        // https://notepad96.tistory.com/193
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            if (Build.VERSION.SDK_INT < 21) {
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            } else {
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
                window.statusBarColor = Color.TRANSPARENT
            }
        }

        // null 여부를 감지하여 불필요한 자원 소모 방지하여 최적화
        if (centerWeggleFragment == null) { // null이면 fragment 초기 data 만들기

            // fragment 생성
            homeFragment = HomeFragment()
            brandsFragment = BrandsFragment()
            centerWeggleFragment = CenterWeggleFragment()
            wegglerFragment = WegglerFragment()
            myAccountFragment = MyAccountFragment()

            // System 생성
            fragmentManager = supportFragmentManager // manager 호출
            transaction = fragmentManager!!.beginTransaction() // 화면 전환 호출
            transaction!!.add(R.id.main_frame, centerWeggleFragment!!).commit() // 최초로 첫 화면 갱신
            binding.bottomNavi.menu.getItem(2)
                .setChecked(true) // Item이 선택되어지는 상태 https://stackoverflow.com/questions/72132526/bottomnavigationviews-menu-not-selected-after-navigating-to-other-fragment-swi
            Log.i(TAG, "Fragment Data 최초로 생성함")
        }

        // BottomNavigation 선택
        binding.bottomNavi.setOnItemSelectedListener {

            transaction =
                fragmentManager!!.beginTransaction() // 화면 전환 호출(이곳에서 새로 호출을 해준다는 개념으로 추가함)

            // switch나 if랑 비슷함. 단 이 문은 type 상관업음.
            when (it.itemId) {
                R.id.frag1 -> {
                    transaction?.replace(R.id.main_frame, homeFragment!!)?.commit()
                    Log.i(TAG, "home 선택됨")
                    true
                }
                R.id.frag2 -> {
                    transaction?.replace(R.id.main_frame, brandsFragment!!)?.commit()
                    Log.i(TAG, "brands 선택됨")
                    true
                }
                R.id.frag3 -> {
                    transaction?.replace(R.id.main_frame, centerWeggleFragment!!)?.commit()
                    Log.i(TAG, "centerWeggle 선택됨")

                    Log.i(TAG, "이거머야: " + it.itemId.toString())
                    true
                }
                R.id.frag4 -> {
                    transaction?.replace(R.id.main_frame, wegglerFragment!!)?.commit()
                    Log.i(TAG, "weggler 선택됨")
                    true
                }
                R.id.frag5 -> {
                    transaction?.replace(R.id.main_frame, myAccountFragment!!)?.commit()
                    Log.i(TAG, "myAccount 선택됨")
                    true
                }
                else -> {
                    false
                }
            }
        }

        // ImageView의 Weggle Button을 누르면 발생.
        binding.btnCenterWeggle.setOnClickListener {

            transaction =
                fragmentManager!!.beginTransaction() // 화면 전환 호출(이곳에서 새로 호출을 해준다는 개념으로 추가함)
            transaction?.replace(R.id.main_frame, centerWeggleFragment!!)?.commit()
            binding.bottomNavi.menu.getItem(2).setChecked(true) // Item이 선택되어지는 상태
            Log.i(TAG, "weggler btn 선택됨")
        }
    }

    // 투명 Status 만들기
    // https://notepad96.tistory.com/193
    private fun setWindowFlag(bits: Int, on: Boolean) {
        val winAttr = window.attributes
        winAttr.flags = if (on) winAttr.flags or bits else winAttr.flags and bits.inv()
        window.attributes = winAttr
    }
    // 아이돌마스터 M@sterPiece Vs 뱅드림 Kizuna Music Vs 러브라이브 Snow Halation
}