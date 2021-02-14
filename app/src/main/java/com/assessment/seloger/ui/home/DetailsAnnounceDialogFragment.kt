package com.assessment.seloger.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.assessment.domain.model.Announce
import com.assessment.domain.model.getGeneralInfo
import com.assessment.seloger.R
import com.assessment.seloger.databinding.FragmentDetailAnnounceBinding
import com.assessment.seloger.utils.setImageUrl
import kotlinx.android.synthetic.main.fragment_detail_announce.*

class DetailsAnnounceDialogFragment : DialogFragment() {

    private var _binding: FragmentDetailAnnounceBinding? = null
    private val binding: FragmentDetailAnnounceBinding get() = requireNotNull(_binding)
    private lateinit var announce: Announce


    companion object {
        const val TAG = "TAG_FULL_SCREEN_DIALOG"
        private const val ANNOUNCE_EXTRA = "ANNOUNCE_KEY"

        fun newInstance(announce: Announce) = DetailsAnnounceDialogFragment().apply {
            arguments = Bundle().apply { putParcelable(ANNOUNCE_EXTRA, announce) }
        }
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailAnnounceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getParcelable<Announce>(ANNOUNCE_EXTRA)?.let {
            announce = it
        }
        initView()
        close.setOnClickListener { dismiss() }
    }

    private fun initView() {
        with(announce) {
            binding.tvCity.text = city
            binding.tvPrice.text = price.toString()
            binding.tvPropertyType.text = propertyType
            binding.tvGeneralInfo.text = getGeneralInfo()
            binding.imageAnnounce.setImageUrl(image)
        }

    }

}