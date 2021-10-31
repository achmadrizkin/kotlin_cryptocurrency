package com.example.cyptocurrencyapp.presentasion.coin_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cyptocurrencyapp.presentasion.coin_details.component.CoinTag
import com.example.cyptocurrencyapp.presentasion.coin_details.component.TeamListItem
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin ->
            LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)) {
                // top section
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )

                        Text(
                            text = if (coin.is_active) "active" else "inactive",
                            color = if (coin.is_active) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier.align(CenterVertically).weight(2f)
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    // description text
                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    // tags
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    // its bassicaly row, but more responsive
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    // Team member
                    Text(
                        text = "Team member",
                        style = MaterialTheme.typography.h3
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                }
                // List Team member
                items(coin.team) { teamMember ->
                    TeamListItem(teamMember = teamMember, modifier = Modifier.fillMaxWidth().padding(10.dp))
                    Divider()
                }
            }
        }


        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}