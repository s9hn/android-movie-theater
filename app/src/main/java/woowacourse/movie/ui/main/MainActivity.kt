package woowacourse.movie.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import woowacourse.movie.R
import woowacourse.movie.ui.home.HomeFragment
import woowacourse.movie.ui.main.FragmentsOnBottomNavigation.HOME
import woowacourse.movie.ui.main.FragmentsOnBottomNavigation.RESERVATION
import woowacourse.movie.ui.main.FragmentsOnBottomNavigation.SETTING
import woowacourse.movie.ui.reservation.ReservationFragment
import woowacourse.movie.ui.setting.SettingFragment

class MainActivity : AppCompatActivity() {
    private val bottomNavigationView: BottomNavigationView by lazy {
        findViewById(R.id.main_bottom_navigation_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragmentContainerView()
        setBottomNavigationView()
    }

    private fun initFragmentContainerView() {
        supportFragmentManager.commit {
            add(R.id.main_fragment_view, HomeFragment())
            setReorderingAllowed(true)
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.main_fragment_view, fragment)
            setReorderingAllowed(true)
        }
    }

    private fun setBottomNavigationView() {
        bottomNavigationView.selectedItemId = R.id.menu_item_home
        bottomNavigationView.setOnItemSelectedListener { selectedIcon ->
            changeFragment(
                getFragmentByIcon(selectedIcon),
            )
            true
        }
    }

    private fun getFragmentByIcon(item: MenuItem): Fragment {
        val reservationFragment = ReservationFragment()
        val homeFragment = HomeFragment()
        val settingFragment = SettingFragment()

        return when (FragmentsOnBottomNavigation.valueOf(item.itemId)) {
            RESERVATION -> reservationFragment
            HOME -> homeFragment
            SETTING -> settingFragment
        }
    }
}
