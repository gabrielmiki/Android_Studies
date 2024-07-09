# Android_Studies

<p> Repo used for Android Developemnt Studies using Kotlin. </p>

## Basis of App Creation

### What is a User Interface?
A user interface (UI) of an app is what you see on the screen: text, images, buttons, and many other types of elements, as well as how they are organized. It is how the app displays information to the user and how the user interacts with the app.

### Components
Each UI element is called a component. These components can be interactive, like a clickable button or an editable text field, or purely decorative, like images.

### Jetpack Compose
Jetpack Compose is a modern toolkit for building Android UIs:
- Simplifies and accelerates UI development with less code.
- Uses composable functions to define UI elements.
- Composable functions are annotated with `@Composable` and convert data into UI.

### Measurements
- **Scalable Pixels (SP)**: Unit for font size, scales with user preference.
- **Density-independent Pixels (DP)**: Used for layout to ensure consistency across different screen densities.

### Layout Hierarchy
UI hierarchy is based on containment:
- Parent components contain child components.
- Layout components like `Column`, `Row`, and `Box` help organize child elements horizontally, vertically, or stacked.

### Modifiers
Modifiers define how UI elements are displayed and behave:
- Can be used to add padding, background, alignment, and more.
- Example: `Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)`.

### Resources
- Separate app resources (images, strings) from code for better management and localization.
- Access resources using generated IDs from the `R` class.
- Use `painterResource()` to load drawable images.

### Images
- Store images in `drawable-nodpi` to prevent resizing issues.
- Set `contentDescription` to `null` for decorative images to avoid interfering with screen readers like TalkBack.

### Scaling
- Use `ContentScale.Crop` to maintain image aspect ratio while scaling to fit the screen.

### Padding and Alignment
- Use padding as a modifier to control spacing around elements.
- Specify arrangement properties like `horizontalArrangement` and `verticalAlignment` for Rows and Columns.

### String Resources
- Extract strings to a resource file for easier translation and reuse.

### Projects used to Exercise those Concepts

#### 1.Compose Article
<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/ComposeArticle.png">

<p> A column element containing three texts and an image </p>
<p> In which the image is fetched with: `painterResource(id = R.drawable.bg_compose_background)` and configured to `contentScale = ContentScale.FillWidth` </p>

#### 2.Compose Quandrants
<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/ComposeQuadrants.png">

<p> Four columns of two texts arranged and aligned as: </p>

```
verticalArrangement = Arrangement.Center,
horizontalAlignment = Alignment.CenterHorizontally
```

<p> And weighted using `modifier = Modifier.weight(1F)` in two rows. </p>

```
Row(
            modifier = Modifier.weight(1F)
        ) {
            QuadrantText(
                title = stringResource(id = R.string.title_three),
                text = stringResource(id = R.string.text_three),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1F)
            )
            QuadrantText(
                title = stringResource(id = R.string.title_four),
                text = stringResource(id = R.string.text_four),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1F)
            )
        }
```

#### 3.Task Manager
<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/TaskManager.png">

<p> Column of an image and two text centerly arranged and aligned. </p>

#### 4.Business Card
<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/BusinessCard.png">

<p> A column containing a mipmap with a circle background and two texts: </p>

```
Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .background(
                    color = Color.Green,
                    shape = CircleShape
                )
        )
```

<p> Followed by a row inside a column (bottom arranged) containing icons and text. </p>

```
 Row(modifier = modifier) {
        Icon(
            icone,
            contentDescription = null,
            tint = Color(0xFF39B047),
            modifier = modifier
                .padding(
                    end = 4.dp
                )
        )
        Text(text = text, color = Color.Gray)
    }
```

## Fundamentals of Application Flow

### 1.Nullable and Non-Nullable Types
In Kotlin, there's a clear distinction between nullable and non-nullable types:
- **Nullable types**: Variables that can hold `null`.
- **Non-null types**: Variables that can't hold `null`.

To declare nullable variables, add a `?` operator to the end of the type.

#### Safe Call Operator (?.)
Use the `?.` safe call operator to access methods or properties of nullable variables. Simply add a `?` after the variable name and use the `.` notation to access the desired method or property.

#### Not-Null Assertion Operator (!!)
The `!!` not-null assertion operator allows access to methods or properties of nullable variables, asserting that the variable is not null. If the variable is null, a `NullPointerException` will be thrown.

#### Elvis Operator (?:)
The Elvis operator `?:` is used to provide a default value if the variable is null. If the variable isn't null, the expression before `?:` executes; otherwise, the expression after `?:` executes.

### 2.Classes and Inheritance
In Kotlin, all classes are `final` by default, meaning they can't be extended. To allow a class to be extendable, use the `open` keyword.

#### Method Overriding
- **Open keyword**: Used before method declarations in the superclass to allow them to be overridden.
- **Override keyword**: Used in the subclass to indicate that a method is overriding a superclass method. This informs the Kotlin runtime to execute the subclass's method instead of the superclass's.

#### Function References
To refer to a function as a value, use the function reference operator (`::`).

#### Function Types
Function types consist of a set of parentheses with an optional list of parameters, followed by the `->` symbol and a return type.

### 3.Lambda Expressions
When programming a lambda expression for a function with parameters:
- Parameters are named in the order they occur.
- Parameter names are listed after the opening brace `{`, separated by commas.
- A `->` separates the parameter names from the function body.

#### Nullable Function Types
To declare a nullable function type, place the function type in parentheses followed by a `?`. For example, to make the type `() -> String` nullable, declare it as `(() -> String)?`.

### 4.Higher-Order Functions
Functions that return another function or use a function as an argument are called higher-order functions. The `repeat()` function is an example of a higher-order function, providing a concise way to perform repetitive tasks.

### 5.Exercises

#### Temperature converter

```
fun main() {
    printFinalTemperature(27.0, "Celsius", "Fahrenheit", celsiusToFahren)
    printFinalTemperature(350.0, "Kelvin", "Celsius", kelvinToCelcius)
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", fahrenToKelvin)
}

val celsiusToFahren: (Double) -> Double = {
    (9 * it) / 5  + 32
}

val kelvinToCelcius: (Double) -> Double = {
    it - 273.15
}

val fahrenToKelvin: (Double) -> Double = {
    (5 * (it - 32)) / 9 + 273.15
}

fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
```

#### Lemonade App
The overall functn of the App is:

Initial Screen
- The user sees a lemon tree.
- A prompt asks the user to tap the lemon tree to "pick" a lemon.

Picking the Lemon:
- After tapping the lemon tree, a lemon appears.
- The user is prompted to tap the lemon to "squeeze" it to make lemonade.
- The number of taps required to squeeze the lemon varies randomly between 2 and 4.

Making Lemonade:
- Once the lemon has been tapped the necessary number of times, a glass of refreshing lemonade appears.
- The user needs to tap the glass to "drink" the lemonade.

Empty Glass:
- After tapping the glass of lemonade, an empty glass is shown.
- The user needs to tap the empty glass to start over.

Repeat:
- After tapping the empty glass, the lemon tree is shown again, and the user can repeat the process for more lemonade.

<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/LemonadeApp.png">

The final result consists of a composable function reponsable for the app layout, which will compose it based on the parameters passed.

```
@Composable
fun AppLayout(
    imageResource: Int,
    stringResource: Int,
    onClickInstruction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(Color.LightGray),
            shape = RoundedCornerShape(10.dp),
            onClick = onClickInstruction
        )
        {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = stringResource),
            fontSize = 18.sp
        )
    }
}
```

And the app logic, which contains two state variables resposible for the state in which the app finds itself.

```
@Composable
fun LemonadeAppContent() {
    var displayResource by remember {
        mutableStateOf(0)
    }

    var variableRandom by remember {
        mutableStateOf(1)
    }

    when (displayResource) {
        0 -> {
            AppLayout(
                imageResource = R.drawable.lemon_tree,
                stringResource = R.string.lemon_collect,
                onClickInstruction = {
                    displayResource = 1
                    variableRandom = (2..4).random()
                })
        }
        1 -> {
            AppLayout(
                imageResource = R.drawable.lemon_squeeze,
                stringResource = R.string.lemon_squeeze,
                onClickInstruction = {
                    variableRandom--
                    if (variableRandom == 0) {
                        displayResource = 2
                    }
                })
        }
        2 -> {
            AppLayout(
                imageResource = R.drawable.lemon_drink,
                stringResource = R.string.lemon_drink,
                onClickInstruction = {
                    displayResource = 3
                })
        }
        3 -> {
            AppLayout(
                imageResource = R.drawable.lemon_restart,
                stringResource = R.string.start_again,
                onClickInstruction = {
                    displayResource = 0
                })
        }
    }
```

#### Art Gallery App

App responsible for showing different images and descriptions according to the user input

<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/ArtCollectionApp.png">

Logic is handled by a remembered state variable, which is changed according to clicks in the button. 
The arguments passsed to the app layout change according to the state the app finds itself.
Everytime eather one of the buttons is pressed the application state changes.

```
    when (image) {
        0 -> {
            AppLayout(
                image = R.drawable.paris,
                title = R.string.first_picture_title,
                author = R.string.first_picture_author,
                year = R.string.first_picture_year,
                previousOnClick = {
                    image = 2
                },
                nextOnClick = {
                    image++
                }
            )
        }
        1 -> {
            AppLayout(
                image = R.drawable.torre,
                title = R.string.second_picture_title,
                author = R.string.second_picture_author,
                year = R.string.second_picture_year,
                previousOnClick = {
                    image--
                },
                nextOnClick = {
                    image++
                }
            )
        }
        2 -> {
            AppLayout(
                image = R.drawable.coliseu,
                title = R.string.third_picture_title,
                author = R.string.third_picture_author,
                year = R.string.third_picture_year,
                previousOnClick = {
                    image--
                },
                nextOnClick = {
                    image = 0
                }
            )
        }
    }
```

## Kotlin Collections and Scrollable Apps

#### Arrays
- **Declaration**: Use `arrayOf()`.
- **Fixed Size**: Arrays have a fixed size.
- **Access Elements**: Use the array name followed by the index in square brackets (`array[index]`).

#### Lists
- **List**: An interface for an ordered collection of read-only items.
- **MutableList**: Extends List to allow modification (adding/removing elements).
- **Methods**:
  - `indexOf()`: Find the index of an element.
  - `add()`: Add an element (at the end or at a specific index).
  - `remove()` and `removeAt()`: Remove elements by value or index.

#### Sets
- **Set**: An unordered collection that does not allow duplicates.
- **MutableSet**: Extends Set to allow modification.
- **Methods**:
  - `add()`: Add an element.
  - `contains()`: Check if an element exists.
  - `remove()`: Remove an element.

#### Maps
- **Map**: A collection of key-value pairs.
- **Declaration**: Use `mapOf()` or `mutableMapOf()`.
- **Access and Modification**:
  - `get()` and subscript syntax: Access values.
  - `remove()`: Remove key-value pairs.
  - `put()`: Modify values.

#### Higher-Order Functions
- **forEach()**: Executes a function for each item in a collection.
- **map()**: Transforms a collection into a new collection.
- **filter()**: Creates a subset of a collection based on a condition.
- **groupBy()**: Transforms a list into a map grouped by a specified key.
- **fold()**: Generates a single value from a collection, useful for sums or averages.
- **sortedBy()**: Sorts a collection based on a specified property.

### String Templates
- **Variable Insertion**: Use `$variableName`.
- **Property Access**: Use expressions within curly braces (`${expression}`).

### Card
- **Card**: A container for displaying content and actions in a single surface.

### LazyColumn
- **LazyColumn**: For long, scrollable lists.
  - **Usage**: Use when the number of items is large or unknown.
  - **Items**: Add items with the `items()` method, which takes a list as a parameter.

### Exercises

#### 1.Photo List Scrollable App

Here we aim to obtain an app with a grid of cards, each of them with an image and some text specific to each image.
Each Card is specificaly composed by a composable row function, an image and a custom imageinfo composable to deal with the text display.

```
Card(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(id = topic.image),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            ImageInfo(
                topic = topic,
                modifier = Modifier
            )
        }
    }
```

The data to be listed is modeled through a data class.

```
data class Topic(
    @StringRes val title: Int,
    val photoNumber: Int,
    @DrawableRes val image: Int
)
```

And the simmulation of fetching it is obtained through another class (DataSource). Everything is then displayed by a LazyVerticalGrrid.

```
LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(8.dp)
    ) {
        items(cardLayouts) { topic ->
            CardLayout(topic)
        }
    }
```

<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/PhotoListApp.png">

#### 2.Superheroes app

This app focuses on creating the components necessary to build a scrollable list and a polished UI using the Material Design principles
First we used the Material Design BUilder to select different customized color based on a primary one. Then, after configuring the ui.theme directory with the new colors and font, a LazyColumn was used to recieve the data objects in a list format.
The header was implemented by using the Scaffold function and the CenterAlignedTopAppBar function.

```
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            HeroTopBar()
        }
    ) {
        HeroList(
            heroList = HeroesRepository.heroes, contentPadding = it
        )
    }
}
```

<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/SuperHeroApp.png">

#### 3.Accounting App

In this project we have created an App that shows a list of tips regarding the accounting subject.

Each tip is put inside a Card composable component, which contains an image, two texts and an icon button.

In this project we start by setting the ui.theme archives throught the Material Design Builder. Then we create the data to be used, mainly the texts, imputing them on the strings.xml file, and import the images.

Beyond the app layout and disply logic, there is also the implmentation of two animations reponsible for the expantion of each card and the update pf the icon button to a arrow pointing upwards when the cards is showing all its content.

```
@Composable
fun AccountingCard(
    accountingInfo: AccountingInfo,
    modifier: Modifier = Modifier,
) {
    var infoButt by remember {
        mutableStateOf(false)
    }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .heightIn(min = 150.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Text(
                    text = stringResource(id = accountingInfo.title),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp
                        )
                )
                Spacer(modifier = Modifier.weight(1F))
                IconButton(onClick = { infoButt = !infoButt }) {
                    Icon(imageVector = iconSelect(infoButt), contentDescription = null)
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp
                    )
            ) {
                Surface(
                    shadowElevation = 5.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = accountingInfo.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                }
            }
            if (infoButt) {
                Text(
                    text = stringResource(id = accountingInfo.text),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp
                        )
                )
            }
        }
    }
}
```

<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/AccountingApp.png">

## Multi-Screen Navigation and Adaptive UI in Android Development

### Multi-Screen Navigation with Jetpack Compose
- **Navigation Component**: Implements multi-screen apps declaratively.
- **NavController**: Manages navigation between different screens (destinations).
- **NavGraph**: Maps out navigation paths between composable destinations.
- **NavHost**: A container composable that displays the current destination based on the NavGraph.

#### Key Concepts
- **Routes**: Strings that identify each destination uniquely, similar to URLs.
- **Composable Destinations**: Defined using the `composable()` function, specifying the route and the content to display.

### Adaptive UI for Different Screen Sizes
- **WindowSizeClass API**: Implements Material Design breakpoints (Compact, Medium, Expanded).
- **Responsive Design**: Changes layout based on screen size to improve user ergonomics.

#### Implementation
- **Navigation Types**: Enum class `ReplyNavigationType` for different navigation elements (bottom navigation, navigation rail, permanent navigation drawer).
- **Adaptive Layouts**:
  - **Preview**: Use `@Preview` annotation to create visualizations for different screen sizes.
  - **Conditional Layouts**: Use `when` statements to switch layouts based on the `WindowWidthSizeClass`.

### Exercise: Milan Recommendations App

#### Features

#### 1.Multi-Screen Navigation
- **Multiple Screens**: Each screen displays a different category of recommendations.
- **Jetpack Navigation Component**: Enables users to seamlessly navigate through the app.

#### Clean Architecture
- **UI Layer and Data Layer Separation**: Maintains a clear distinction between UI and data management.
- **ViewModel**: Utilizes ViewModel for managing UI-related data in a lifecycle-conscious way.
- **Unidirectional Data Flow (UDF)**: Ensures UI updates are handled predictably by the ViewModel.

### Adaptive Layouts
- **Responsive Design**: Adapts layouts to accommodate different screen sizes and orientations.
- **Material Design Guidelines**: Follows best practices for adaptive design and navigation, providing a consistent and intuitive user experience.

<img src="https://github.com/gabrielmiki/Android_Studies/blob/main/MilanApp.png">

<video controls> <source src="https://github.com/gabrielmiki/Android_Studies/blob/main/MilanApp.mp4" type="video/mp4"> </video>



![Milan App](https://github.com/gabrielmiki/Android_Studies/assets/96574190/e504e941-331c-4625-a6b3-e343fb6a695b)

