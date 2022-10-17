package com.example.accessmentnine.ui.myFriends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.accessmentnine.databinding.FragmentMyfriendsBinding


class MyFriendsFragment : Fragment() {

    private var _binding : FragmentMyfriendsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myFriendsViewModel =
            ViewModelProvider(this).get(MyFriendsViewModel::class.java)

        _binding = FragmentMyfriendsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMyFriends
        myFriendsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}