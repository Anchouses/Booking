package com.silaeva.rooms_impl.ui

import Carousel
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silaeva.common_ui.Toolbar
import com.silaeva.common_ui.typography.Colors
import com.silaeva.common_ui.typography.Typography
import com.silaeva.rooms_impl.R
import com.silaeva.rooms_impl.entity.Room

@Composable
fun RoomsScreen() {
    val roomList = listOf(
        Room(
            id = 1,
            name = "Стандартный номер с видом на бассейн",
            price = 186600,
            pricePer = "За 7 ночей с перелетом",
            peculiarities = listOf(
                "Включен только завтрак",
                "Кондиционер"
            ),
            imageUrls = listOf(
                "https://www.atorus.ru/sites/default/files/upload/image/News/56871/%D1%80%D0%B8%D0%BA%D1%81%D0%BE%D1%81%20%D1%81%D0%B8%D0%B3%D0%B5%D0%B9%D1%82.jpg",
                "https://q.bstatic.com/xdata/images/hotel/max1024x768/267647265.jpg?k=c8233ff42c39f9bac99e703900a866dfbad8bcdd6740ba4e594659564e67f191&o=",
                "https://worlds-trip.ru/wp-content/uploads/2022/10/white-hills-resort-5.jpeg"
            )
        ),
        Room(
            id = 2,
            name = "Люкс номер с видом на море",
            price = 289400,
            pricePer = "За 7 ночей с перелетом",
            peculiarities = listOf(
                "Все включено",
                "Кондиционер",
                "Собственный бассейн"
            ),
            imageUrls = listOf(
                "https://mmf5angy.twic.pics/ahstatic/www.ahstatic.com/photos/b1j0_roskdc_00_p_1024x768.jpg?ritok=65&twic=v1/cover=800x600",
                "https://www.google.com/search?q=%D0%BD%D0%BE%D0%BC%D0%B5%D1%80+%D0%BB%D1%8E%D0%BA%D1%81+%D0%B2+%D0%BE%D1%82%D0%B5%D0%BB%D0%B8+%D0%B5%D0%B3%D0%B8%D0%BF%D1%82%D0%B0+%D1%81+%D1%81%D0%BE%D0%B1%D1%81%D1%82%D0%B2%D0%B5%D0%BD%D0%BD%D1%8B%D0%BC+%D0%B1%D0%B0%D1%81%D1%81%D0%B5%D0%B9%D0%BD%D0%BE%D0%BC&tbm=isch&ved=2ahUKEwilufKp-4KBAxUfJxAIHR4uAToQ2-cCegQIABAA&oq=%D0%BD%D0%BE%D0%BC%D0%B5%D1%80+%D0%BB%D1%8E%D0%BA%D1%81+%D0%B2+%D0%BE%D1%82%D0%B5%D0%BB%D0%B8+%D0%B5%D0%B3%D0%B8%D0%BF%D1%82%D0%B0+%D1%81+%D1%81%D0%BE%D0%B1%D1%81%D1%82%D0%B2%D0%B5%D0%BD%D0%BD%D1%8B%D0%BC+%D0%B1%D0%B0%D1%81%D1%81%D0%B5%D0%B9%D0%BD%D0%BE%D0%BC&gs_lcp=CgNpbWcQAzoECCMQJ1CqAVi6HGDmHWgAcAB4AIABXIgB3wySAQIyNZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=Y3fuZOX7KJ_OwPAPntyE0AM&bih=815&biw=1440#imgrc=Nr2wzh3vuY4jEM&imgdii=zTCXWbFgrQ5HBM",
                "https://tour-find.ru/thumb/2/bsb2EIEFA8nm22MvHqMLlw/r/d/screenshot_3_94.png"
            )
        )
    )// getRoomListFromJson() // Предположим, что у вас есть функция для получения списка комнат из JSON

    Column(
        modifier = Modifier.background(color = Colors.backgroundGray)
    ) {
        Toolbar(
            text = "Steinber Makadi",
            canGoBack = true,
            modifier = Modifier.background(color = Colors.white)
        )
        LazyColumn {
            items(roomList.size) { i ->
                RoomListItem(roomList[i])
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RoomListItem(room: Room) {
    Card(
        colors = cardColors(
            containerColor = Colors.white,
            contentColor = Colors.white
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Карусель фотографий
            Carousel(
                imageList = room.imageUrls,
                pagerState = rememberPagerState { room.imageUrls.size },
            )

            // Название комнаты
            Text(
                text = room.name,
                style = Typography.title,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Row {
                for (peculiarity in room.peculiarities) {
                    Text(
                        text = peculiarity,
                        style = Typography.tagsSecondary,
                        modifier = Modifier
                            .background(
                                color = Colors.secondaryTagsGray,
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
                    )
                }
            }

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Colors.primaryTagsBlue,
                    containerColor = Colors.primaryTagsBlue
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 5.dp)
                ,
                onClick = { /*TODO*/ }
            ) {
                val aboutRoom = stringResource(id = R.string.more_about_the_room)
                Text(
                    text = aboutRoom,
                    style = Typography.tagsPrimary,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .align(Alignment.CenterVertically)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = aboutRoom,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }

            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = "${room.price} ₽",
                    style = Typography.priceLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = room.pricePer,
                    style = Typography.bodySecondary,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        bottom = 12.dp,
                    )
                )

            }

            // Кнопка "Выбрать комнату"
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Colors.primaryButton,
                    containerColor = Colors.primaryButton
                ),
                shape = RoundedCornerShape(15.dp),
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 15.dp)
            ) {
                Text(
                    text = "Выбрать комнату",
                    style = Typography.buttonPrimary
                )
            }
        }
    }
}

@Preview
@Composable
fun RoomScreenPreview() {
    RoomsScreen()
}