package com.johnlewis.test.presentation.productdetails.compose

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.johnlewis.test.R
import com.johnlewis.test.domain.model.DomainProductDetails
import com.johnlewis.test.presentation.CurrencyUtils
import com.johnlewis.test.presentation.productdetails.mvvm.ProductDetailsViewModel
import kotlinx.coroutines.flow.StateFlow

object ProductDetailsScreen {

    @Composable
    fun initialise(
        currentUIStateFlow: StateFlow<ProductDetailsViewModel.CurrentUIState>,
        intentionListener: ProductDetailsActionListener
    ) {
        currentUIStateFlow.collectAsState().value.let { currentUIState ->
            when (currentUIState) {
                is ProductDetailsViewModel.CurrentUIState.Loading -> {
                    displayLoadingView()
                }
                is ProductDetailsViewModel.CurrentUIState.ShowProductDetails -> {
                    println("*** Data received in UI ${currentUIState.data}")
                    showProductsList(data = currentUIState.data, listener = intentionListener)
                }
                is ProductDetailsViewModel.CurrentUIState.Error -> {
                    displayErrorView(errorMessage = currentUIState.errorMessages)
                }
                is ProductDetailsViewModel.CurrentUIState.NotLoaded -> {
                    displayEmptyView()
                }
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun showProductsList(data: DomainProductDetails, listener: ProductDetailsActionListener) {
        Scaffold(topBar = { topBar(title = data.title) }) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            )
            {
                item {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .height(300.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        val pagerState = rememberPagerState()
                        HorizontalPager(
                            count = data.images.urls.size,
                            state = pagerState,
                        )
                        { page ->
                            AsyncImage(
                                model = Uri.parse("https:${data.images.urls[page]}"),
                                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = data.images.urls[page],
                                contentScale = ContentScale.Inside,
                                modifier = Modifier
                                    .padding(
                                        vertical = 5.dp,
                                        horizontal = 5.dp
                                    ),
                                alignment = Alignment.CenterEnd
                            )
                        }
                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            modifier = Modifier
                                .padding(16.dp),
                        )
                    }
                }
                //Second card
                item {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "${CurrencyUtils.getCurrencySymbol(data.price.currency)}${data.price.now}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        LazyColumn(
                            modifier = Modifier
                                .height(30.dp)
                        ) {
                            items(data.additionalServices.includedServices.size) { index ->
                                Text(
                                    text = data.additionalServices.includedServices[index]
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Text(
                            text = "Product information",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Light
                        )
                        Spacer(
                            modifier = Modifier
                                .size(5.dp)
                        )
                        Text(
                            text = HtmlCompat.fromHtml(
                                data.productInformation,
                                HtmlCompat.FROM_HTML_MODE_COMPACT
                            ).toString(),
                            fontSize = 12.sp,
                            color = Color.Gray,
                        )
                        Spacer(
                            modifier = Modifier
                                .size(10.dp)
                        )
                        Text(
                            text = "Product code: ${data.code}"
                        )
                        Spacer(
                            modifier = Modifier
                                .size(10.dp)
                        )
                        Divider(color = Color.LightGray, thickness = 0.5.dp)
                    }
                }
                items(data.attributes.size) { index ->
                    Row(horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = data.attributes[index].name,
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier
                                .weight(1f)
                                .padding(5.dp)
                        )
                        Text(
                            text = data.attributes[index].value,
                            textAlign = TextAlign.End,
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier
                                .weight(1f)
                                .padding(5.dp)
                        )
                    }
                    Divider(color = Color.LightGray, thickness = 0.5.dp)

                }
            }
        }

    }

    @Composable
    fun displayEmptyView() {
        Scaffold(topBar = { topBar(title = "Producr details") }) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_perm_device_information_24),
                    contentDescription = stringResource(id = R.string.message_not_loaded),
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = stringResource(id = R.string.message_not_loaded))
            }
        }

    }

    @Composable
    fun displayLoadingView() {
        Scaffold(topBar = { topBar(title = "Producr details") }) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(id = R.string.label_loading))
            }
        }
    }

    @Composable
    fun displayErrorView(errorMessage: String?) {
        Scaffold(topBar = {
            topBar(title = "Producr details")
        }) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_error_24),
                    contentDescription = stringResource(id = R.string.message_not_loaded),
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))

                errorMessage?.let { Text(text = it) }
            }
        }
    }

    @Composable
    fun topBar(title: String) {
        TopAppBar(title = {
            Text(
                text = title,
                textAlign = TextAlign.Start,
                fontSize = 15.sp
            )
        })
    }

}