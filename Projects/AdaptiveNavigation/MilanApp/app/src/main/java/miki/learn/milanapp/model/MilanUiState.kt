package miki.learn.milanapp.model

data class MilanUiState(
    val recommendations: List<PlaceInfo> = listOf(),
    val recommendation: PlaceInfo? = null
)
