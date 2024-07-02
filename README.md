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
