package com.pereyrarg11.instagramcomposable.recyclerview

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pereyrarg11.instagramcomposable.R
import com.pereyrarg11.instagramcomposable.recyclerview.model.Superhero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    val names =
        listOf("Gabriel", "Miguel", "Israel", "Kenia", "Uriel", "Noelia", "Francisco", "Efrain")
    LazyColumn {
        item {
            Text(text = "Header")
        }
        items(names) {
            Text(text = "Hola, me llamo $it")
        }
        item {
            Text(text = "Footer")
        }
    }
}

@Composable
fun SuperHeroRecyclerView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroList()) { superheroItem ->
            SuperheroViewHolder(superhero = superheroItem) {
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyHeaderRecyclerView() {
    val context = LocalContext.current
    val publishers = getSuperheroList().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        publishers.forEach { (name, superheroList) ->
            stickyHeader {
                Text(
                    text = name,
                    color = Color.Black,
                    modifier = Modifier
                        .background(Color.Yellow)
                        .fillMaxWidth()
                )
            }

            items(superheroList) { superheroItem ->
                SuperheroViewHolder(superhero = superheroItem) {
                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SuperHeroStateRecyclerView() {
    val context = LocalContext.current
    val lazyColumnState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(
            state = lazyColumnState,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(getSuperheroList()) { superheroItem ->
                SuperheroViewHolder(superhero = superheroItem) {
                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val showButton by remember { derivedStateOf { lazyColumnState.firstVisibleItemIndex > 0 } }

        if (showButton) {
            Button(
                onClick = {
                    coroutineScope.launch { lazyColumnState.animateScrollToItem(0) }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Scroll Up")
            }
        }
    }
}

@Composable
fun SuperheroViewHolder(superhero: Superhero, onItemClick: (Superhero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(superhero) }
    ) {
        SuperheroCardContent(superhero = superhero)
    }
}

@Composable
fun SuperheroGrid() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(all = 8.dp),
        content = {
            items(getSuperheroList()) { superheroItem ->
                SuperheroGridCard(superhero = superheroItem) {
                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                }
            }
        })
}

@Composable
fun SuperheroGridCard(superhero: Superhero, onItemClick: (Superhero) -> Unit) {
    Card(
        border = BorderStroke(1.5.dp, Color.Green),
        modifier = Modifier
            .clickable { onItemClick(superhero) }
            .padding(8.dp)
    ) {
        SuperheroCardContent(superhero = superhero)
    }
}

@Composable
fun SuperheroCardContent(superhero: Superhero) {
    Column {
        Image(
            painter = painterResource(id = superhero.photo),
            contentDescription = superhero.name,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(text = superhero.name, modifier = Modifier.align(Alignment.CenterHorizontally))
        Text(
            text = superhero.realName,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 12.sp
        )
        Text(
            text = superhero.publisher,
            modifier = Modifier
                .align(Alignment.End)
                .padding(4.dp),
            fontSize = 10.sp
        )
    }
}

fun getSuperheroList(): List<Superhero> {
    return listOf(
        Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
    )
}