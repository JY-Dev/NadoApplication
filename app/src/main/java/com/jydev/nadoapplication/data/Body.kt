package com.jydev.nadoapplication.data

data class Body(var age : Float,var height : Float , var inBodyData: InBodyData, var fatData: FatData,var muscleFatControll: MuscleFatControll,var hrBp: HrBp)

data class InBodyData(var weight:Float,var fatMass : Float,var muscles : Float , var water : Float,var protein:Float,var mineral : Float)

data class FatData(var bmi:Float,var fatMass:Float,var stomachFat:Float,var bmr : Float)

data class MuscleFatControll(var fat:Float,var muscles: Float,var weight:Float)

data class HrBp(var hp:Float, var conBp:Float ,var relBp:Float)