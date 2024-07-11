package miki.learn.milanapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import miki.learn.milanapp.R

enum class MilanAppNavigation(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Recommendation(title = R.string.recommendations_name),
    Detail(title = R.string.details_name)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilanAppBar(
    navigateBack: Boolean,
    currentScreen: MilanAppNavigation,
    navigateUp: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = currentScreen.title),
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Justify
            )
                },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (navigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilanApp(windowSize: WindowWidthSizeClass) {
    val viewModel: MilanViewModel = viewModel()
    val navController: NavHostController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MilanAppNavigation.valueOf(
        backStackEntry?.destination?.route ?: MilanAppNavigation.Start.name
    )

    Scaffold(
      topBar = {
          MilanAppBar(
              navigateBack = navController.previousBackStackEntry != null,
              currentScreen = currentScreen,
              navigateUp = { navController.navigateUp() }
          )
      }
    ) {innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MilanAppNavigation.Start.name,
            modifier = Modifier
                .padding(innerPadding)
        ) {

            when (windowSize) {
                WindowWidthSizeClass.Compact -> {
                    composable(route = MilanAppNavigation.Start.name) {
                        StartScreenLayout(
                            images = viewModel.getStartScreenImages(),
                            names = viewModel.getStartScreenNames(),
                            viewModel = viewModel,
                            onCardClicked = {
                                viewModel.fetchRecommendations(it)
                                navController.navigate(MilanAppNavigation.Recommendation.name)
                            }
                        )
                    }

                    composable(route = MilanAppNavigation.Recommendation.name) {
                        RecommendationScreenList(
                            recommendations = uiState.recommendations,
                            onCardClicked = {
                                viewModel.fetchRecommendation(it)
                                navController.navigate(MilanAppNavigation.Detail.name)
                            }
                        )
                    }

                    composable(route = MilanAppNavigation.Detail.name) {
                        uiState.recommendation?.let { it1 -> DetailLayout(placeInfo = it1) }
                    }
                }
                WindowWidthSizeClass.Medium -> {
                    composable(route = MilanAppNavigation.Start.name) {
                        StartScreenLayout(
                            images = viewModel.getStartScreenImages(),
                            names = viewModel.getStartScreenNames(),
                            viewModel = viewModel,
                            onCardClicked = {
                                viewModel.fetchRecommendations(it)
                                navController.navigate(MilanAppNavigation.Recommendation.name)
                            }
                        )
                    }

                    composable(route = MilanAppNavigation.Recommendation.name) {
                        RecommendationScreenList(
                            recommendations = uiState.recommendations,
                            onCardClicked = {
                                viewModel.fetchRecommendation(it)
                                navController.navigate(MilanAppNavigation.Detail.name)
                            }
                        )
                    }

                    composable(route = MilanAppNavigation.Detail.name) {
                        uiState.recommendation?.let { it1 -> DetailLayout(placeInfo = it1) }
                    }
                }
                WindowWidthSizeClass.Expanded -> {
                    composable(route = MilanAppNavigation.Start.name) {
                        Row {
                            StartScreenLayout(
                                images = viewModel.getStartScreenImages(),
                                names = viewModel.getStartScreenNames(),
                                viewModel = viewModel,
                                onCardClicked = {
                                    viewModel.fetchRecommendations(it)
                                },
                                modifier = Modifier
                                    .weight(1F)
                            )
                            RecommendationScreenList(
                                recommendations = uiState.recommendations,
                                onCardClicked = {
                                    viewModel.fetchRecommendation(it)
                                    navController.navigate(MilanAppNavigation.Detail.name)
                                },
                                modifier = Modifier
                                    .weight(1F)
                            )
                        }
                    }


                    composable(route = MilanAppNavigation.Detail.name) {
                        uiState.recommendation?.let { it1 -> DetailLayout(placeInfo = it1) }
                    }
                }
                else -> {
                    composable(route = MilanAppNavigation.Start.name) {
                        StartScreenLayout(
                            images = viewModel.getStartScreenImages(),
                            names = viewModel.getStartScreenNames(),
                            viewModel = viewModel,
                            onCardClicked = {
                                viewModel.fetchRecommendations(it)
                                navController.navigate(MilanAppNavigation.Recommendation.name)
                            }
                        )
                    }

                    composable(route = MilanAppNavigation.Recommendation.name) {
                        RecommendationScreenList(
                            recommendations = uiState.recommendations,
                            onCardClicked = {
                                viewModel.fetchRecommendation(it)
                                navController.navigate(MilanAppNavigation.Detail.name)
                            }
                        )
                    }

                    composable(route = MilanAppNavigation.Detail.name) {
                        uiState.recommendation?.let { it1 -> DetailLayout(placeInfo = it1) }
                    }
                }
            }
        }
    }
}