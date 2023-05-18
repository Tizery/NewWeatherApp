package com.example.newweatherapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newweatherapp.R
import com.example.newweatherapp.databinding.FragmentDetailsBinding
import com.example.newweatherapp.model.entities.Weather


class DetailsFragment : Fragment() {

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
                val city = it.city
                cityName.text = city.cityName
                cityCoordinates.text = String.format(
                    getString(R.string.city_coordinates),
                    city.lat.toString(),
                    city.lon.toString()
                )
                temperatureValue.text = it.temperature.toString()
                feelsLikeValue.text = it.feelsLike.toString()
            }
        }
        /*val observer = Observer<AppState> { renderData(it) }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getWeatherFromLocalSourceRussian()*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                val weatherData = appState.weatherData
                progressBar.visibility = View.GONE
                weatherGroup.visibility = View.VISIBLE
                setData(weatherData)
            }
            is AppState.Loading -> {
                progressBar.visibility = View.VISIBLE
                weatherGroup.visibility - View.INVISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                weatherGroup.visibility = View.INVISIBLE
                Snackbar.make(mainView, "Ошибка", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Перезагрузите, пожалуйста") { viewModel.getWeatherFromLocalSourceRussian() }
                    .show()
            }
        }
    }*/

    /*private fun setData(weatherData: Weather) = with(binding) {
        cityName.text = weatherData.cityName.cityName
        cityCoordinates.text = String.format(
            getString(R.string.city_coordinates),
            weatherData.cityName.lat.toString(),
            weatherData.cityName.lon.toString()
        )
        temperatureValue.text = weatherData.temperature.toString()
        feelsLikeValue.text = weatherData.feelsLike.toString()
    }*/

    companion object {
        const val BUNDLE_EXTRA = "WEATHER"
        fun newInstance(bundle: Bundle) : DetailsFragment{
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}