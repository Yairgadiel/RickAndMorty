package com.gy.rickandmorty.ui.composables

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gy.rickandmorty.R
import com.gy.rickandmorty.model.entities.Location
import com.gy.rickandmorty.model.entities.Origin
import com.gy.rickandmorty.model.entities.ShowCharacter

private val primaryTextStile =
    TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)

private val secondaryTextStile =
    TextStyle(fontSize = 14.sp, color = Color.Gray, textAlign = TextAlign.Center)

@Composable
fun ListCharacter(character: ShowCharacter) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = character.image,
            contentDescription = character.name,
            modifier = Modifier
                .size(64.dp)
                .shadow(4.dp, shape = CircleShape)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.morty_ph)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = character.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = primaryTextStile,
                modifier = Modifier.width(250.dp)
            )
            Text(
                text = character.origin.name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = secondaryTextStile
            )
        }
    }
}

@Composable
fun GridCharacter(character: ShowCharacter) {
    Card {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(96.dp)
                    .shadow(4.dp, shape = CircleShape)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.morty_ph)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = character.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = primaryTextStile
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = character.origin.name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = secondaryTextStile,
                modifier = Modifier.height(40.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

private val previewCharacter = ShowCharacter(
    created = "yesterday",
    episode = listOf(),
    gender = "Male",
    id = 1,
    image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
    location = Location("Home", ""),
    name = "Yair Gadiel aa sadsa fs afas fsa f",
    origin = Origin("Beit Gamliel or Rehovot or Yavne", ""),
    species = "Human",
    status = "Alive",
    type = "Unknown",
    url = ""
)

@Preview(name = "Character - List", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ListCharacterPrev() {
    ListCharacter(previewCharacter)
}

@Preview(name = "Character - Grid", uiMode = UI_MODE_NIGHT_NO, showBackground = true, widthDp = 200)
@Composable
fun GridCharacterPrev() {
    GridCharacter(previewCharacter)
}