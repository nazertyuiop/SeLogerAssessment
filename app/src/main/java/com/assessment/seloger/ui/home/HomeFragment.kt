package com.assessment.seloger.ui.home

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.assessment.domain.model.Announce
import com.assessment.seloger.R
import com.assessment.seloger.databinding.FragmentHomeBinding
import com.assessment.seloger.utils.livedata.isNetworkRelated
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = requireNotNull(_binding)

    private val viewModel by viewModel<HomeViewModel>()
    private val adapter by lazy { AnnounceAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        initRecycleView()
        observeViewModel()
        viewModel.getListAnnounces()
    }


    private fun initRecycleView() {
        binding.announcesRecyclerView.adapter = adapter
        adapter.itemClickListener = ::showAnnounceDetails
    }

    private fun observeViewModel() {
        viewModel.getAnnouncesEvent.observe(viewLifecycleOwner, Observer {
            when (it) {
                HomeViewModel.GetAnnounceEvent.Loading -> toggleLoading(true)
                is HomeViewModel.GetAnnounceEvent.Error -> handleGetAnnouncesEventError(it.exception)
                is HomeViewModel.GetAnnounceEvent.Success -> handleGetAnnouncesEventSuccess(it.announces)
            }
        })
    }

    private fun handleGetAnnouncesEventSuccess(ads: List<Announce>) {
        toggleLoading(false)
        adapter.items = ads
    }

    private fun handleGetAnnouncesEventError(e: Exception) {
        toggleLoading(false)
        Toast.makeText(
            requireContext(),
            getString(if (e.isNetworkRelated()) R.string.error_no_connection else R.string.technical_error_message),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun toggleLoading(show: Boolean) {
        binding.loader.visibility = if (show) View.VISIBLE else GONE
    }

    private fun showAnnounceDetails(announce: Announce) {
        DetailsAnnounceDialogFragment.newInstance(announce)
            .show(childFragmentManager, DetailsAnnounceDialogFragment.TAG)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}