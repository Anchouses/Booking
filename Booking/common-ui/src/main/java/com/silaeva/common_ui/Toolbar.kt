package com.silaeva.common_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Toolbar(
    text: String,
    modifier: Modifier = Modifier,
    canGoBack: Boolean = false,
    onGoBackClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
    ) {
        if (canGoBack) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Go back",
                modifier = Modifier.size(32.dp)
                    .padding(6.dp)
                    .align(Alignment.CenterStart)
                    .clickable { onGoBackClick.invoke() }
            )
        }
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}