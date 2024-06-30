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
