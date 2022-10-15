package com.johnlewis.test.presentation.products.compose

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.johnlewis.test.R
import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.presentation.CurrencyUtils
import com.johnlewis.test.presentation.productdetails.ProductDetailsActivity
import com.johnlewis.test.presentation.products.mvvm.ProductsViewModel
import kotlinx.coroutines.flow.StateFlow
import java.util.*

object ProductListScreen {

    @Composable
    fun initialise(
        currentUIStateFlow: StateFlow<ProductsViewModel.CurrentUIState>,
        intentionListener: ProductActionListener
    ) {
        currentUIStateFlow.collectAsState().value.let { currentUIState ->
            when (currentUIState) {
                is ProductsViewModel.CurrentUIState.Loading -> {
                    displayLoadingView()
                }
                is ProductsViewModel.CurrentUIState.ShowProductList -> {
                    showProductsList(data = currentUIState.data, listener = intentionListener)
                }
                is ProductsViewModel.CurrentUIState.ShowProductDetails -> {
                    //TODO : It's not good idea to lunch an activity -> Need to use the Navigation components
                    val productDetailsActivity = Intent(
                        LocalContext.current,
                        ProductDetailsActivity::class.java
                    ).apply {
                        putExtra(ProductDetailsActivity.EXTRA_PRODUCT_ID, currentUIState.productId)
                    }
                    LocalContext.current.startActivity(productDetailsActivity)
                }
                is ProductsViewModel.CurrentUIState.Error -> {
                    displayErrorView(errorMessage = currentUIState.errorMessages)
                }
                is ProductsViewModel.CurrentUIState.NotLoaded -> {
                    displayEmptyView()
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun showProductsList(data: List<DomainProductsModel>, listener: ProductActionListener) {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(200.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(data.size) { item ->
                Card(
                    elevation = 5.dp,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(5.dp)
                        .clickable {
                            listener.acceptNewIntention(
                                ProductsViewModel.ProductIntention.RequestProductDetails(
                                    productId = data[item].productId
                                )
                            )
                        },
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        AsyncImage(
                            model = Uri.parse("https:${data[item].image}"),
                            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = data[item].title,
                            contentScale = ContentScale.Inside,
                            modifier = Modifier
                                .size(120.dp)
                              ,
                            alignment = Alignment.CenterEnd
                        )

                        Text(
                            text = data[item].title,
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(start = 5.dp, bottom = 5.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = if (data[item].outOfStock)
                                stringResource(id = R.string.message_out_of_stock) else
                                "${CurrencyUtils.getCurrencySymbol(data[item].price.currency)}${data[item].price.now}",
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(start = 5.dp, bottom = 5.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun displayEmptyView() {
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

    @Composable
    fun displayLoadingView() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.label_loading))
        }
    }

    @Composable
    fun displayErrorView(errorMessage: String?) {
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