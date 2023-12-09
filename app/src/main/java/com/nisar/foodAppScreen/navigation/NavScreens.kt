package com.nisar.foodAppScreen.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavScreens(var route:String,var icon:ImageVector)
{
    object Home: NavScreens("home", Icons.Filled.Home)
    object Favourite:NavScreens("favourite",Icons.Filled.Favorite)
    object Cart:NavScreens("cart",Icons.Filled.ShoppingCart)
    object Profile:NavScreens("profile",Icons.Filled.Person)
}

