package com.example.newweatherapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newweatherapp.AppState
import com.example.newweatherapp.R
import com.example.newweatherapp.databinding.FragmentDetailsBinding
import com.example.newweatherapp.model.entities.Weather
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsFragment : Fragment() {

    private val viewModel : DetailsViewModel by viewModel()
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Weather>(BUNDLE_EXTRA)?.let {
            with(binding) {
                cityName.text = it.city.cityName
                cityCoordinates.text = String.format(
                    getString(R.string.city_coordinates),
                    it.city.lat.toString(),
                    it.city.lon.toString()
                )
                viewModel.liveDataToObserve.observe(viewLifecycleOwner) { appState ->
                    when (appState) {
                        is AppState.Error -> {
                            mainView.visibility = View.INVISIBLE
                            loadingLayout.visibility = View.GONE
                            errorTV.visibility = View.VISIBLE
                        }
                        AppState.Loading -> {
                            mainView.visibility = View.INVISIBLE
                            loadingLayout.visibility = View.VISIBLE
                        }
                        is AppState.Success -> {
                            loadingLayout.visibility = View.GONE
                            mainView.visibility = View.VISIBLE
                            temperatureValue.text = appState.weatherData[0].temperature.toString()
                            feelsLikeValue.text = appState.weatherData[0].feelsLike.toString()
                            weatherCondition.text = appState.weatherData[0].condition
                        }
                    }
                }
                viewModel.loadData(it.city.lat, it.city.lon)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_EXTRA = "WEATHER"
        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}