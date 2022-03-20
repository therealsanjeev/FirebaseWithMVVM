package com.therealsanjeev.firebasewithmvvm.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.therealsanjeev.firebasewithmvvm.R
import com.therealsanjeev.firebasewithmvvm.base.BaseFragment
import com.therealsanjeev.firebasewithmvvm.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment() {
    override val binding
        get() = FragmentHomeBinding.inflate(layoutInflater)

}