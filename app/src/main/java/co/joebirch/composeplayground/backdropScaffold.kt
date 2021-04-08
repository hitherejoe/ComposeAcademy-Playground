package co.joebirch.composeplayground

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

object BackdropScaffoldView : ComposableLayout {

    @ExperimentalMaterialApi
    @Composable
    override fun build() {
        val coroutineScope = rememberCoroutineScope()
        val backdropState = rememberBackdropScaffoldState(BackdropValue.Concealed)
        BackdropScaffold(
            frontLayerScrimColor = Color.Black,
            appBar = {
            TopAppBar {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Backdrop Scaffold",
                        modifier = Modifier.padding(16.dp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                }
            }
        }, backLayerContent = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            backdropState.conceal()
                        }
                    },
                    colors = buttonColors(
                        contentColor = MaterialTheme.colors.primary,
                        backgroundColor = Color.White
                    )
                ) {
                    Text(text = "Back Content")
                }
            }
        },
            scaffoldState = backdropState,
            frontLayerContent = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        coroutineScope.launch {
                            backdropState.reveal()
                        }
                    }) {
                        Text(text = "Front Content")
                    }
                }
            }
        )
    }

    @ExperimentalMaterialApi
    @Composable
    fun Props() {
        val coroutineScope = rememberCoroutineScope()
        val backdropState = rememberBackdropScaffoldState(BackdropValue.Concealed)
        BackdropScaffold(
            frontLayerShape = RectangleShape,
            frontLayerElevation = 12.dp,
            frontLayerContentColor = Color.DarkGray,
            frontLayerBackgroundColor = Color.LightGray,
            appBar = {
                TopAppBar {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Backdrop Scaffold",
                            modifier = Modifier.padding(16.dp),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        )
                    }
                }
            }, backLayerContent = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                backdropState.conceal()
                            }
                        },
                        colors = buttonColors(
                            contentColor = MaterialTheme.colors.primary,
                            backgroundColor = Color.White
                        )
                    ) {
                        Text(text = "Back Content")
                    }
                }
            },
            scaffoldState = backdropState,
            frontLayerContent = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        coroutineScope.launch {
                            backdropState.reveal()
                        }
                    }) {
                        Text(text = "Front Content")
                    }
                }
            }
        )
    }
}