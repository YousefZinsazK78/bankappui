package com.yousefzk.backapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EnergySavingsLeaf
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousefzk.backapp.data.Finance
import com.yousefzk.backapp.ui.theme.blueStart
import com.yousefzk.backapp.ui.theme.greenEnd
import com.yousefzk.backapp.ui.theme.orangeEnd
import com.yousefzk.backapp.ui.theme.orangeStart
import com.yousefzk.backapp.ui.theme.purpleStart

val financeItems = listOf(
    Finance(
        icon = Icons.Default.StarHalf,
        name = "My\nBusiness",
        background = orangeStart,
    ),
    Finance(
        icon = Icons.Default.Wallet,
        name = "My\nWallet",
        background = blueStart,
    ),
    Finance(
        icon = Icons.Default.Savings,
        name = "My\nSavings",
        background = purpleStart,
    ),
    Finance(
        icon = Icons.Default.Money,
        name = "My\nMoney",
        background = greenEnd,
    ),
    Finance(
        icon = Icons.Default.EnergySavingsLeaf,
        name = "My\nTransactions",
        background = orangeEnd,
    )
)

@Composable
fun FinanceSection() {
    Column() {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow() {
            items(financeItems.size) {
                FinanceItem(it)
            }

        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val finance = financeItems[index]
    var lastItemPaddingEnd = 0.dp
    if (index == financeItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    Box(Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(130.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White,
                )
            }

            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }

}