import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch
import kotlin.math.abs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(
    imageList: List<String>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    dotsActiveColor: Color = Color.Black,
    dotsSize: Dp = 7.dp,
    imageCornerRadius: Dp = 16.dp,
) {
    val scope = rememberCoroutineScope()
    Box(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp
        ) { page ->
            Image(
                modifier = Modifier
                    .aspectRatio(4f / 3f)
                    .clip(
                        RoundedCornerShape(imageCornerRadius)
                    ),
                painter = rememberAsyncImagePainter(model = imageList[page]),
                contentDescription = "Hotel photo",
                contentScale = ContentScale.Crop,
            )
        }

        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(size = 5.dp)
                    )
                    .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(imageList.size) { pageIndex ->
                    val pageDistance = pagerState.currentPage - pageIndex
                    val alpha =  1f - (0.95f * abs(pageDistance) / imageList.lastIndex)
                    Box(modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .size(dotsSize)
                        .alpha(alpha)
                        .background(dotsActiveColor)
                        .clickable {
                            scope.launch {
                                pagerState.animateScrollToPage(pageIndex)
                            }
                        }
                    )
                }

            }
        }
    }
}