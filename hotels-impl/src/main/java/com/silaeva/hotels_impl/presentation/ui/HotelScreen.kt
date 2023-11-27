package com.silaeva.hotels_impl.presentation.ui

import Carousel
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.silaeva.common_ui.CardContainer
import com.silaeva.common_ui.PrimaryButton
import com.silaeva.common_ui.Toolbar
import com.silaeva.common_ui.typography.Colors
import com.silaeva.common_ui.typography.Typography
import com.silaeva.hotels_impl.R
import com.silaeva.hotels_impl.domain.entity.Hotel
import com.silaeva.hotels_impl.presentation.viewmodel.HotelViewModel


@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun HotelScreen(viewModel: HotelViewModel) {

    val getHotel: State<Hotel> = viewModel.hotel.collectAsState()

    val hotel = getHotel.value

    Box(
        modifier = Modifier
            .background(color = Colors.backgroundGray)
    ) {
        Toolbar(
            text = "Отель",
            modifier = Modifier
                .background(color = Colors.white)
                .zIndex(1f)
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            CardContainer(
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 49.dp)
                ) {
                    Carousel(
                        imageList = hotel.imageUrls,
                        pagerState = rememberPagerState { hotel.imageUrls.size }
                    )

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Colors.accentTagsGold,
                            containerColor = Colors.accentTagsGold
                        ),
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(vertical = 5.dp),
                        onClick = {}
                    ) {
                        val ratingString = "${hotel.rating} ${hotel.ratingName}"
                        Image(
                            painter = painterResource(id = R.drawable.ic_golden_star),
                            contentDescription = ratingString,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = ratingString,
                            style = Typography.tagsAccent,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
                    }

                    Text(
                        text = hotel.name,
                        style = Typography.title,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Text(
                        text = hotel.address,
                        style = Typography.addressBlue
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Text(
                            text = "От ${hotel.minimalPrice} ₽",
                            style = Typography.priceLarge,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        Text(
                            text = hotel.priceForIt,
                            style = Typography.bodySecondary,
                            modifier = Modifier.padding(
                                start = 8.dp,
                                bottom = 12.dp,
                            )
                        )
                    }
                }
            }

            CardContainer(
                modifier = Modifier
                    .padding(bottom = 90.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Об отеле",
                        style = Typography.title,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        for (peculiarity in hotel.aboutTheHotel.peculiarities) {
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


                    Text(
                        text = hotel.aboutTheHotel.description,
                        style = Typography.description,
                        overflow = TextOverflow.Visible,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(
                                color = Color(0xFFFBFBFC),
                                shape = RoundedCornerShape(size = 15.dp)
                            )
                            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)
                    ) {
                        DetailsItem(text = "Удобства", icon = R.drawable.ic_emoji_happy)
                        DetailsItem(text = "Что включено", icon = R.drawable.ic_tick_square)
                        DetailsItem(text = "Что не включено", icon = R.drawable.ic_close_square)
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .shadow(1.dp)
                .background(Colors.white)
                .align(BottomCenter)
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            PrimaryButton(
                text = "К выбору номера",
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                viewModel.onChooseRoomButtonClick(hotel.name)
            }
        }
    }

}

@Composable
fun DetailsItem(
    text: String,
    icon: Int,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
    ) {
        Image(
            painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.align(CenterVertically)
        )
        Column(
            modifier = Modifier
                .align(CenterVertically)
                .padding(start = 12.dp)
        ) {
            Text(
                text = text,
                style = Typography.aboutButtonTitle
            )
            Text(
                text = "Самое необходимое",
                style = Typography.aboutButtonDescription
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = com.silaeva.common_ui.R.drawable.ic_arrow_forward_black),
            contentDescription = "Open",
            modifier = Modifier.align(CenterVertically)
        )
    }
}