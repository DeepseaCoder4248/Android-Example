package com.puresoftware.overlaprecyclerview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.puresoftware.overlaprecyclerview.adapter.OutRecyclerViewAdapter
import com.puresoftware.overlaprecyclerview.databinding.FragmentMainBinding
import com.puresoftware.overlaprecyclerview.model.RecyclerInViewModel
import com.puresoftware.overlaprecyclerview.model.RecyclerOutViewModel

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        setUpRecyclerView()

        return binding.root
    }

    private fun setUpRecyclerView() {
        var itemList = mutableListOf(
            RecyclerOutViewModel(
                "ν¬μ λ₯", mutableListOf(
                    RecyclerInViewModel("πΆ", "κ°μμ§"), RecyclerInViewModel("π±", "κ³ μμ΄"),
                    RecyclerInViewModel("π³", "κ³ λ"), RecyclerInViewModel("π¦", "μ¬μ΄")
                )
            ),

            RecyclerOutViewModel(
                "μ‘°λ₯", mutableListOf(
                    RecyclerInViewModel("π¦", "λμλ¦¬"), RecyclerInViewModel("ποΈ", "λΉλκΈ°"),
                    RecyclerInViewModel("π¦", "λΆμμ΄"), RecyclerInViewModel("π", "λ­")
                )
            ),

            RecyclerOutViewModel(
                "μ΄λ₯", mutableListOf(
                    RecyclerInViewModel("π", "νμ΄"), RecyclerInViewModel("π", "κ΄μ΄"),
                    RecyclerInViewModel("π", "μ°μ΄"), RecyclerInViewModel("π", "μ°λ­")
                )
            ),

            RecyclerOutViewModel(
                "νμΆ©λ₯", mutableListOf(
                    RecyclerInViewModel("π", "μμ΄"), RecyclerInViewModel("π¦", "μΉ΄λ©λ μ¨"),
                    RecyclerInViewModel("π¦", "λλ§λ±"), RecyclerInViewModel("π", "λ±")
                )
            ),

            RecyclerOutViewModel(
                "μμλ₯", mutableListOf(
                    RecyclerInViewModel("πΈ", "κ°κ΅¬λ¦¬"), RecyclerInViewModel("π¦", "λλ£‘λ½"),
                    RecyclerInViewModel("πΈ", "λκΊΌλΉ")
                )
            ),
        )

        binding.outRecyclerview.adapter = OutRecyclerViewAdapter(requireContext(), itemList)
        binding.outRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }
}