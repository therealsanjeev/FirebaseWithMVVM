package com.therealsanjeev.firebasewithmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.therealsanjeev.firebasewithmvvm.fragments.dashboard.DashboardFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
    private fun init(){
        val ft: FragmentTransaction = this.supportFragmentManager.beginTransaction()
        ft.add(R.id.fragmentContainer, DashboardFragment())
        ft.addToBackStack(DashboardFragment().javaClass.name)
        ft.commit()
    }
}