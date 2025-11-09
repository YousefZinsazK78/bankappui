package com.yousefzk.backapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousefzk.backapp.data.Currency
import com.yousefzk.backapp.ui.theme.greenStart

val currencyItems = listOf(
    Currency(
        name = "USD", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "EUR", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "YEN", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "XUD", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "USD", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "EUR", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "YEN", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "XUD", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "USD", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "EUR", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "YEN", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    ), Currency(
        name = "XUD", buy = 23.23f, sell = 23.21f, icon = Icons.Rounded.AttachMoney
    )
)

@Preview(showBackground = true)
@Composable
fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 32.dp), contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .clickable {
                            isVisible = !isVisible
                            if (isVisible) {
                                iconState = Icons.Rounded.KeyboardArrowUp
                            } else {
                                iconState = Icons.Rounded.KeyboardArrowUp
                            }
                        }) {
                    Icon(
                        imageVector = iconState,
                        contentDescription = "currencies",
                        modifier = Modifier.size(25.dp),
                        tint = MaterialTheme.colorScheme.onSecondary,

                        )
                }

                Spacer(Modifier.width(20.dp))

                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold,
                )
            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )

            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstraint = this
                    val width = boxWithConstraint.maxWidth / 3

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                        Row(
                            Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Currency",
                                modifier = Modifier.width(width),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                            Text(
                                text = "Buy",
                                modifier = Modifier.width(width),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End,
                            )
                            Text(
                                text = "Sell",
                                modifier = Modifier.width(width),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End,

                                )

                        }

                        Spacer(Modifier.height(16.dp))

                        LazyColumn() {
                            items(currencyItems.size) {
                                CurrencyItem(it, width)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val currency = currencyItems[index]
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(greenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = currency.icon,
                    contentDescription = "currency",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Text(
                text = currency.name,
                modifier = Modifier
                    .padding(start = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End,

                )
        }

        Text(
            text = "$ ${currency.buy}",
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End,

            )

        Text(
            text = "$ ${currency.sell}",
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End,

            )

    }
}