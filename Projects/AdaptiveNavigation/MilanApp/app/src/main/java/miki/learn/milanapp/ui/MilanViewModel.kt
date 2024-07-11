package miki.learn.milanapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import miki.learn.milanapp.R
import miki.learn.milanapp.data.DataSource
import miki.learn.milanapp.model.MilanUiState
import miki.learn.milanapp.model.PlaceInfo

class MilanViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MilanUiState())
    val uiState: StateFlow<MilanUiState> = _uiState.asStateFlow()

    fun getStartScreenImages(): List<Int> {
        return listOf(
            R.drawable.pasticceria_marchesi,
            R.drawable.sushiandsound,
            R.drawable.parco_sempione,
            R.drawable.galleria_vittorio_emanuele
        )
    }

    fun getStartScreenNames(): List<Int> {
        return listOf(
            R.string.name_coffee_1,
            R.string.name_restaurant_1,
            R.string.name_park_1,
            R.string.name_shopping_1
        )
    }

    fun fetchRecommendations(place: String) {
        when (place) {
            "Coffee Shops" -> fetchCofeeShops()
            "Restaurants" -> fetchRestaurants()
            "Parks" -> fetchParks()
            "Shoppings" -> fecthShoppings()
        }
    }

    fun fetchRecommendation(placeInfo: PlaceInfo) {
        _uiState.update {currState ->
            currState.copy(
                recommendation = placeInfo
            )
        }
    }

    fun fetchCofeeShops() {
        _uiState.update {currState ->
            currState.copy(
                recommendations = DataSource.coffeeShops
            )
        }
    }

    fun fetchRestaurants() {
        _uiState.update {currState ->
            currState.copy(
                recommendations = DataSource.restaurants
            )
        }
    }

    fun fetchParks() {
        _uiState.update {currState ->
            currState.copy(
                recommendations = DataSource.parks
            )
        }
    }

    fun fecthShoppings() {
        _uiState.update {currState ->
            currState.copy(
                recommendations = DataSource.shoppings
            )
        }
    }


}