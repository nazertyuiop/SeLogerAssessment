package com.assessment.seloger.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.assessment.domain.model.Announce
import com.assessment.seloger.R
import com.assessment.seloger.utils.setImageUrl
import kotlinx.android.synthetic.main.fragment_detail_announce.*

class DetailsAnnounceDialogFragment : DialogFragment() {

    companion object {

        private const val ANNOUNCE = "ANNOUNCE"

        fun newInstance(announce: Announce) = DetailsAnnounceDialogFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ANNOUNCE, announce)
            }
        }
    }

    private lateinit var announce: Announce

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getSerializable(ANNOUNCE)?.let {
            announce = it as Announce
        }

    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_announce, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        view?.let {


            close.setOnClickListener {
                dismiss()
            }
            announce.image?.let {
                imageAnnounce.setImageUrl(it)
            }

        }
    }

}