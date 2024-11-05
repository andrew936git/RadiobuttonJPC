package com.example.radiobutton

class Equipment(val name: String, val price: Int) {
    companion object{
        val listEquipment = listOf(
            Equipment("Classic", 2104900),
            Equipment("Comfort", 2174900),
            Equipment("Luxe", 2289900),
            Equipment("Style", 2329900),
        )
    }
}