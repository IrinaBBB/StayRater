package ru.aurorahost.stayraterapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import ru.aurorahost.stayraterapp.domain.model.Hotel
import ru.aurorahost.stayraterapp.util.Constants.BASE_URL
import ru.aurorahost.stayraterapp.R
import ru.aurorahost.stayraterapp.navigation.Screen
import ru.aurorahost.stayraterapp.presentation.components.RatingBar
import ru.aurorahost.stayraterapp.ui.theme.HOTEL_ITEM_HEIGHT
import ru.aurorahost.stayraterapp.ui.theme.LARGE_PADDING
import ru.aurorahost.stayraterapp.ui.theme.MEDIUM_PADDING
import ru.aurorahost.stayraterapp.ui.theme.SMALL_PADDING
import ru.aurorahost.stayraterapp.ui.theme.topAppBarContentColor


@Composable
fun ListContent(
    hotels: LazyPagingItems<Hotel>,
    navController: NavHostController
) {

}

@ExperimentalCoilApi
@Composable
fun HotelItem(
    hotel: Hotel,
    navController: NavHostController
) {
    val painter = rememberImagePainter(data = "$BASE_URL${hotel.image}") {
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_placeholder)
    }

    Box(
        modifier = Modifier
            .height(HOTEL_ITEM_HEIGHT)
            .clickable {
                navController.navigate(Screen.Details.passHotelId(hotelId = hotel.id))
            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = stringResource(R.string.hotel_image),
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING)
            ) {
                Text(
                    text = hotel.name,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = hotel.description,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingBar(
                        modifier = Modifier.padding(end = SMALL_PADDING),
                        rating = hotel.rating
                    )
                    Text(
                        text = "(${hotel.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
@Preview
fun HotelItemPreview() {
    HotelItem(
        hotel = Hotel(
            id = 1,
            name = "Luxury Palace",
            image = "/images/palace_hotel.jpg",
            description = "A luxurious hotel with stunning views",
            rating = 4.5,
            numberOfRooms = 100,
            checkInTime ="3:00 PM",
            checkOutTime = "12:00 PM",
            amenities = listOf(),
            roomTypes = listOf(),
            services = listOf(),
            location = "City Center"
        ),
        navController = rememberNavController()
    )
}

@ExperimentalCoilApi
@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HotelItemDarkPreview() {
    HotelItem(
        hotel = Hotel(
            id = 1,
            name = "Luxury Palace",
            image = "/images/palace_hotel.jpg",
            description = "A luxurious hotel with stunning views",
            rating = 4.5,
            numberOfRooms = 100,
            checkInTime ="3:00 PM",
            checkOutTime = "12:00 PM",
            amenities = listOf(),
            roomTypes = listOf(),
            services = listOf(),
            location = "City Center"
        ),
        navController = rememberNavController()
    )
}