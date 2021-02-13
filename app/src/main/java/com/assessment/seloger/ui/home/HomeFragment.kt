package com.assessment.seloger.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.assessment.seloger.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    companion object {

        private const val TAG_FULL_SCREEN_DIALOG = "TAG_FULL_SCREEN_DIALOG"
    }

    private val viewModel by viewModel<HomeViewModel>()
    private val adapter by lazy { AnnounceAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loader.visibility = View.VISIBLE
        viewModel.getListAnnounces()
        initRecycleView()
        observeViewModel()
    }


    private fun initRecycleView() {
        announcesRecyclerView.layoutManager = LinearLayoutManager(context)
        announcesRecyclerView.adapter = adapter
        adapter.itemClickListener = { announce ->
            DetailsAnnounceDialogFragment.newInstance(announce)
                    .show(childFragmentManager, TAG_FULL_SCREEN_DIALOG)
        }
    }

    private fun observeViewModel() {
        viewModel.listAnnounce.observe(viewLifecycleOwner, Observer { listAnnounces ->
            adapter.items.clear()
            adapter.items.addAll(listAnnounces)
            adapter.notifyDataSetChanged()
            loader.visibility = View.GONE
        })
    }

}