package org.diyorbek.youtubeapi_h1.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.diyorbek.youtubeapi_h1.R
import org.diyorbek.youtubeapi_h1.activity.PlayerActivity
import org.diyorbek.youtubeapi_h1.adapter.YoutubeAdapter
import org.diyorbek.youtubeapi_h1.databinding.FragmentHomeBinding
import org.diyorbek.youtubeapi_h1.model.YoutubeModel
import org.diyorbek.youtubeapi_h1.network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val youtubeAdapter by lazy { YoutubeAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.apply {
            adapter = youtubeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        callApi()
        youtubeAdapter.onClick = {
            val bundle = bundleOf("item" to it)
            val intent = Intent(requireContext(), PlayerActivity::class.java)
            intent.putExtras(bundle)
            requireContext().startActivity(intent)
        }
    }

    private fun callApi() {
        RetroInstance.retroInstance().getAllData().enqueue(object : Callback<YoutubeModel> {
            override fun onResponse(call: Call<YoutubeModel>, response: Response<YoutubeModel>) {
                if (response.isSuccessful) {
                    binding.progressBar.isVisible = false
                    youtubeAdapter.submitList(response.body()?.items)
                } else {
                    Toast.makeText(requireContext(), "Not Successfully", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<YoutubeModel>, t: Throwable) {
                Log.d("@@@", "onFailure: ${t.message}")
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}