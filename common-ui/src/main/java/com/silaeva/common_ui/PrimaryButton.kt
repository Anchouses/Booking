package com.silaeva.common_ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.silaeva.common_ui.typography.Colors
import com.silaeva.common_ui.typography.Typography

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            contentColor = Colors.primaryButton,
            containerColor = Colors.primaryButton
        ),
        shape = RoundedCornerShape(15.dp),
        onClick = onClickListener,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 15.dp)
    ) {
        Text(
            text = text,
            style = Typography.buttonPrimary
        )
    }
}