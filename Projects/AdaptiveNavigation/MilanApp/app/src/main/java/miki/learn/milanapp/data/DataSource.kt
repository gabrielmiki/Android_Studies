package miki.learn.milanapp.data

import miki.learn.milanapp.R
import miki.learn.milanapp.model.PlaceInfo

object DataSource {

    val coffeeShops: List<PlaceInfo> = listOf(
        PlaceInfo(
            name = R.string.name_coffee_1,
            details = R.string.details_coffee_1,
            image = R.drawable.pasticceria_marchesi
        ),
        PlaceInfo(
            name = R.string.name_coffee_2,
            details = R.string.details_coffee_2,
            image = R.drawable.emporio_armani_caffe
        ),
        PlaceInfo(
            name = R.string.name_coffee_3,
            details = R.string.details_coffee_3,
            image = R.drawable.pasticceria_cucchi
        )
    )

    val restaurants: List<PlaceInfo> = listOf(
        PlaceInfo(
            name = R.string.name_restaurant_1,
            details = R.string.details_restaurant_1,
            image = R.drawable.sushiandsound
        ),
        PlaceInfo(
            name = R.string.name_restaurant_2,
            details = R.string.details_restaurant_2,
            image = R.drawable.prime
        ),
        PlaceInfo(
            name = R.string.name_restaurant_3,
            details = R.string.details_restaurant_3,
            image = R.drawable.glory_pop
        )
    )

    val parks: List<PlaceInfo> = listOf(
        PlaceInfo(
            name = R.string.name_park_1,
            details = R.string.details_park_1,
            image = R.drawable.parco_sempione
        ),
        PlaceInfo(
            name = R.string.name_park_2,
            details = R.string.details_park_2,
            image = R.drawable.parco_delle_cave
        ),
        PlaceInfo(
            name = R.string.name_park_3,
            details = R.string.details_park_3,
            image = R.drawable.boscoincitta
        )
    )

    val shoppings: List<PlaceInfo> = listOf(
        PlaceInfo(
            name = R.string.name_shopping_1,
            details = R.string.details_shopping_1,
            image = R.drawable.galleria_vittorio_emanuele
        ),
        PlaceInfo(
            name = R.string.name_shopping_2,
            details = R.string.details_shopping_2,
            image = R.drawable.citylife
        ),
        PlaceInfo(
            name = R.string.name_shopping_3,
            details = R.string.details_shopping_3,
            image = R.drawable.mcarthurglen_outlet
        )
    )
}