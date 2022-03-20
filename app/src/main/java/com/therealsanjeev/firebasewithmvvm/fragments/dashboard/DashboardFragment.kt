package com.therealsanjeev.firebasewithmvvm.fragments.dashboard

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import com.therealsanjeev.firebasewithmvvm.R
import com.therealsanjeev.firebasewithmvvm.base.BaseFragment
import com.therealsanjeev.firebasewithmvvm.databinding.FragmentDashboardBinding
import com.therealsanjeev.firebasewithmvvm.fragments.profile.ProfileFragment
import com.therealsanjeev.firebasewithmvvm.utils.AppENUM


open class DashboardFragment() : BaseFragment() {

    override val binding: FragmentDashboardBinding
        get() =
            FragmentDashboardBinding.inflate(layoutInflater)

    private lateinit var pagerAdapter: ViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        binding.apply {
            bNVDF.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        }
    }

    private fun init() {
        pagerAdapter = ViewPagerAdapter(childFragmentManager)

        pagerAdapter.apply {
            addFragment(DashboardFragment(), AppENUM.DashboardTabs.HOME_TAB_TITLE)
            addFragment(ProfileFragment(), AppENUM.DashboardTabs.PROFILE_TAB_TITLE)
        }

        binding.vPDF.apply {
            adapter=pagerAdapter
            offscreenPageLimit=pagerAdapter.count
            this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    tabChange(position)
                }

                override fun onPageScrollStateChanged(state: Int) {

                }

            })
        }



    }

    private fun tabChange(position: Int) {
        when (position) {
            AppENUM.DashboardTabs.HOME_TAB->{
                binding.apply {
                    vPDF.setCurrentItem(AppENUM.DashboardTabs.HOME_TAB, true)
                    bNVDF.selectedItemId = R.id.navigation_home
                }
            }
            AppENUM.DashboardTabs.PROFILE_TAB->{
                binding.apply {
                    vPDF.setCurrentItem(AppENUM.DashboardTabs.PROFILE_TAB, true)
                    bNVDF.selectedItemId = R.id.navigation_profile
                }

            }
        }
    }

    protected val mOnNavigationItemSelectedListener =
        object : OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                Bundle().apply {
                    when (item.itemId) {
                        R.id.navigation_home -> {
                            binding.apply {
                                vPDF.setCurrentItem(AppENUM.DashboardTabs.HOME_TAB, true)
                                bNVDF.selectedItemId = R.id.navigation_home
                            }
                            return true
                        }
                        R.id.navigation_profile -> {
                            binding.apply {
                                vPDF.setCurrentItem(AppENUM.DashboardTabs.PROFILE_TAB, true)
                                bNVDF.selectedItemId = R.id.navigation_profile
                            }
                            return true
                        }
                    }
                    return false
                }
            }
        }


    internal inner class ViewPagerAdapter(manager: FragmentManager) :
        FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val mFragmentList = ArrayList<BaseFragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): BaseFragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: BaseFragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }
}