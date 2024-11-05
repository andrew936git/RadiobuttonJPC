package com.example.radiobutton

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AppView {

    @Composable
    fun ShowCar(){

        val list = listOf(
            Cars(Color.Red, painterResource(id = R.drawable.red)),
            Cars(Color.Blue, painterResource(id = R.drawable.blue)),
            Cars(Color.Black, painterResource(id = R.drawable.black)),
            Cars(Color.White, painterResource(id = R.drawable.white)),
            Cars(Color.LightGray, painterResource(id = R.drawable.metal))
        )

        val equipments = Equipment.listEquipment

        val (equipment, setEquipment) = remember {
            mutableStateOf(equipments[0])
        }

        val (selectedOption, onOptionSelected) = remember{
            mutableStateOf(list[0])
        }
        
        var price = remember {
            mutableIntStateOf(equipments[0].price)
        }

        Surface {
            Column {
                Box(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = Color.LightGray)
                ) {
                    Image(painter = selectedOption.image, contentDescription = "preview")
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(start = 80.dp)
                ) {
                    list.forEach {option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            RadioButton(
                                colors = RadioButtonDefaults
                                    .colors(selectedColor = selectedOption.color),
                                selected = (option == selectedOption),
                                onClick = { onOptionSelected(option) })
                        }

                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = Color.LightGray)
                ) {
                    Column {
                        equipments.forEach {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                RadioButton(
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Black,
                                        unselectedColor = Color.Black
                                    ),
                                    selected = (it == equipment),
                                    onClick = {
                                        setEquipment(it)
                                        price.intValue = it.price
                                    })

                                Text(
                                    text = it.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp
                                )
                            }
                            Spacer(modifier = Modifier.padding(top = 8.dp))
                        }
                    }
                    
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = Color.DarkGray))
                {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()){
                        Text(
                            text = "Стоимость: от ${price.intValue} рублей",
                            color = Color.White,
                            fontSize = 26.sp,
                            textAlign = TextAlign.Center
                        )
                    }

                }
            }

        }

    }
}