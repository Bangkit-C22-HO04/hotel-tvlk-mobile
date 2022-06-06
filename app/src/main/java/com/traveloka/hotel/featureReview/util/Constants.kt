package com.traveloka.hotel.featureReview.util

import com.traveloka.hotel.featureReview.data.model.Review
import org.json.JSONArray
import java.text.SimpleDateFormat

fun getReviews(): List<Review> {

    val reviews = mutableListOf<Review>()
    val reviewsJson = JSONArray(reviewJsonArray)
    val formatter = SimpleDateFormat("dd-MM-yyyy")

    for (i in 0 until reviewsJson.length()-1) {

        val review = reviewsJson.getJSONObject(i)
        val reviewModel = Review(
            id = review["id"].toString(),
            name = review["name"].toString(),
            rating = review["rating"].toString().toDouble(),
            date = formatter.parse(review["date"].toString()),
            tag = review["tag"].toString(),
            content = review["content"].toString()
        )

        reviews.add(reviewModel)
    }

    return reviews
}

const val reviewJsonArray = """
    [
        {
            "id": "1",
            "name": "Bangkit 2022",
            "rating": 7.3,
            "date": "2019-04-16 12:18:06.018950",
            "tag": "One-night stay",
            "content": "A really great hotel!"
        },
        {
            "id": "2",
            "name": "Bangkit 2023",
            "rating": 8.9,
            "date": "2020-04-16 12:18:06.018950",
            "tag": "Family vacation",
            "content": "A really great hotel!"
        },
    ]
"""