package com.example.mysuperheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.supeheroes.model.Hero
import com.example.mysuperheroes.model.HeroesRepository.heroes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroApp() {
    Scaffold(
        topBar = {
            HeroTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                HeroItem(
                    hero = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {

   Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                HeroInformation(heroName = hero.nameRes, heroDescription = hero.descriptionRes)
                Spacer(Modifier.weight(1f))
                HeroIcon(hero.imageRes)
            }
        }
    }
}

@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.width(250.dp)
        )
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop,
            painter = painterResource(heroIcon),
            contentDescription = null
        )
    }
}
