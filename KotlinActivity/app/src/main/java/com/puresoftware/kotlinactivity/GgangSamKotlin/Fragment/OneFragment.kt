package com.puresoftware.kotlinactivity.GgangSamKotlin.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.puresoftware.kotlinactivity.databinding.FragmentOneBinding

class OneFragment : Fragment() {

      lateinit var binding : FragmentOneBinding // 일단 모름.

    // override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentOneBinding.inflate(inflater,container,false) // binding은 view랑 같은 역할을 하고 있음
        return binding.root
    }

}