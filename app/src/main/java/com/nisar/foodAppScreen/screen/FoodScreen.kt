package com.nisar.foodAppScreen.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nisar.foodAppScreen.R
import com.nisar.foodAppScreen.data.foodItems
import com.nisar.foodAppScreen.navigation.NavScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FoodHomeUI() {

    val items= listOf(
        foodItems(painterResource(id = R.drawable.coffee),"Coffee","Freshly brewed coffee"),
        foodItems(painterResource(id = R.drawable.breakfast),"BreakFast","Hearty, hot & fresh"),
        foodItems(painterResource(id = R.drawable.munichies),"Munchies","Perfectly Baked Goodies"),
        foodItems(painterResource(id = R.drawable.lunch),"Lunch","Hearty, hot & fresh"),
        foodItems(painterResource(id = R.drawable.fries),"Fries","Fresh & Crisp"),
        foodItems(painterResource(id = R.drawable.drinks),"Drinks","Healthy & Fresh"),
    )

    Scaffold(
        topBar = {
                 TopBar()
        },
        bottomBar = {
            BottomNavigationBar()
        },
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White,
                                Color(0xFFebebeb)
                            )
                        )
                    ).padding(top=50.dp, bottom = 50.dp)
            )
            {
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(10.dp)
                )
                {
                    itemsIndexed(items){ index, item ->
                        CardItems(item = item)

                    }
                }
            }
        }
    )


}


@Composable
fun BottomNavigationBar() {
    val navitems = listOf(
        NavScreens.Home, NavScreens.Favourite, NavScreens.Cart, NavScreens.Profile
    )
    var selectedScreen by remember {
        mutableStateOf("home")
    }

    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 80.dp, topEnd = 80.dp))
    ) {
        navitems.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon, contentDescription = null,
                        tint = if (selectedScreen == screen.route) {
                            Color.Green
                        } else {
                            Color.Gray
                        }
                    )
                },
                selected = selectedScreen == screen.route,
                onClick = { selectedScreen = screen.route },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Composable
fun TopBar() {
    TopAppBar(
        modifier= Modifier.padding(10.dp),
        backgroundColor = Color.White,
        elevation = 0.dp,
        title = {
            Row(modifier= Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center)
            { Text("MENU",color= Color.Black, fontWeight = FontWeight.Bold,
                modifier=Modifier.offset(x= (-10).dp)) } },

        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.drawable.menu),contentDescription=null,
                    colorFilter = ColorFilter.tint(Color.Black)) } },

        actions = {
            IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Filled.Search, contentDescription =null, tint = Color.Black) } })
}


@Composable
fun CardItems(item:foodItems
) {
    Card(
        modifier= Modifier
            .width(150.dp)
            .height(240.dp)
            .padding(10.dp),
        shape=RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(Color.White),
        content = {
            Column()
            {
                Image( painter=item.image,contentDescription = null,modifier= Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                    contentScale = ContentScale.FillBounds)
                Column(Modifier.padding(start=20.dp,end=20.dp,top=10.dp, bottom = 10.dp))
                {
                    Text(text=item.foodCategory, fontWeight = FontWeight.Bold,color=Color.Black)
                    Spacer(modifier = Modifier.size(3.dp))
                    Text(text=item.foodDetails,color=Color.Gray, fontSize = 10.sp)
                }

            }
        }
    )
}


