/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.domain

import com.example.androiddevchallenge.R

object PetRepo {
    fun get(): List<Pet> =
        listOf(
            Pet(
                R.drawable.cat1,
                "Tom",
                "5 months",
                Pet.Gender.Male,
                "Japan",
                "Lollipop",
                "Sugar please."
            ),
            Pet(
                R.drawable.cat2,
                "King",
                "2 years",
                Pet.Gender.Male,
                "UK",
                "Canned Cat Food",
                "No comment."
            ),
            Pet(
                R.drawable.cat3,
                "Human Killer",
                "5 years",
                Pet.Gender.Female,
                "USA",
                "Tuna",
                "Leave me alone."
            ),
            Pet(R.drawable.cat4, "Rice", "3 months", Pet.Gender.Female, "China", "Rice", "Meow."),
            Pet(
                R.drawable.cat5,
                "Marshmallow",
                "10 months",
                Pet.Gender.Male,
                "Japan",
                "Sushi",
                "Hungry.."
            ),
            Pet(
                R.drawable.cat6,
                "Peach",
                "3 years",
                Pet.Gender.Male,
                "China",
                "Peach",
                "Scaryyy!!!"
            ),
            Pet(
                R.drawable.cat7,
                "Doraemon",
                "50 years",
                Pet.Gender.Male,
                "Japan",
                "Pancake",
                "Come here."
            ),
        )
}
