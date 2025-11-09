package com.yousefzk.backapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousefzk.backapp.data.Card
import com.yousefzk.backapp.ui.theme.blueEnd
import com.yousefzk.backapp.ui.theme.blueStart
import com.yousefzk.backapp.ui.theme.greenEnd
import com.yousefzk.backapp.ui.theme.greenStart
import com.yousefzk.backapp.ui.theme.orangeEnd
import com.yousefzk.backapp.ui.theme.orangeStart
import com.yousefzk.backapp.ui.theme.purpleEnd
import com.yousefzk.backapp.ui.theme.purpleStart

val cardItems = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Business",
        balance = 46.234,
        color = getGradient(purpleStart, purpleEnd)
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Savings",
        balance = 99.234,
        color = getGradient(blueStart, blueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Jobs",
        balance = 56.2994,
        color = getGradient(orangeStart, orangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "School",
        balance = 87.554,
        color = getGradient(greenStart, greenEnd)
    )

)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CartSection() {
    LazyRow {
        items(cardItems.size) {
            CardItem(it)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    var lastItemPaddingEnd = 0.dp
    if (index == cardItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(R.drawable.visa)
    if (cardItems[index].cardType == "MASTER CARD") {
        image = painterResource(R.drawable.mastercard)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(cardItems[index].color)
                .width(250.dp)
                .height(170.dp)
                .clickable{}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = image,
                contentDescription = cardItems[index].cardName,
                modifier = Modifier.size(60.dp)
            )

            Text(
                text = cardItems[index].cardName,
                color = Color.White,
                fontSize = 16.sp,
            )

            Text(
                text = "$ ${cardItems[index].balance}",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = cardItems[index].cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }

}