package com.therealsanjeev.firebasewithmvvm.fragments.profile

import android.os.Bundle
import android.view.View
import com.therealsanjeev.firebasewithmvvm.base.BaseFragment
import com.therealsanjeev.firebasewithmvvm.databinding.FragmentProfileBinding

class ProfileFragment() : BaseFragment() {
    override val binding
        get() = FragmentProfileBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}