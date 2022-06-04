package com.traveloka.hotel.utils

import com.traveloka.hotel.R
import com.traveloka.hotel.model.Hotel
import com.traveloka.hotel.model.Review
import org.json.JSONArray
import java.text.SimpleDateFormat

val TRAVEL_PURPOSE_OPTIONS = listOf(
    R.string.culture_sightseeing,
    R.string.family_vacation,
    R.string.holiday_or_leisure,
    R.string.medical_travel,
    R.string.staycation,
    R.string.backpacking,
    R.string.transit,
    R.string.shopping_and_cullinary,
    R.string.business_trip,
    R.string.romantic_vacation
)

fun getHotels(): List<Hotel> {

    val hotels = mutableListOf<Hotel>()
    val hotelsJson = JSONArray(hotelJsonArray)

    for (i in 0 until hotelsJson.length()) {

        val hotel = hotelsJson.getJSONObject(i)
        val hotelModel = Hotel(
            id = hotel["id"].toString(),
            imgUrl = hotel["imgUrl"].toString(),
            name = hotel["name"].toString(),
            city = hotel["city"].toString(),
            price = hotel["price"].toString().toLong(),
            rating = hotel["rating"].toString().toDouble(),
            reviews = hotel["reviews"].toString().toLong(),
            type = hotel["type"].toString(),
        )
        hotels.add(hotelModel)
    }

    return hotels
}

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

const val hotelJsonArray = """
  [
     {
      "city": "Lee's Summit",
      "price": 27648,
      "type": "lion",
      "rating": 8.5,
      "reviews": 61111,
      "imgUrl": "https://loremflickr.com/cache/resized/4142_4927708573_83a7e7ae1f_z_640_480_nofilter.jpg",
      "name": "sunt dolorum et",
      "id": "1"
     },
     {
      "city": "Gulfport",
      "price": 97038,
      "type": "crocodilia",
      "rating": 7,
      "reviews": 98463,
      "imgUrl": "https://loremflickr.com/cache/resized/65535_51909301278_0817277668_z_640_480_nofilter.jpg",
      "name": "tempore voluptatibus et",
      "id": "2"
     },
     {
      "city": "Orange",
      "price": 74437,
      "type": "dog",
      "rating": 8,
      "reviews": 1727,
      "imgUrl": "https://loremflickr.com/cache/resized/65535_51506496339_9b947b995c_b_640_480_nofilter.jpg",
      "name": "eos et vel",
      "id": "3"
     },
     {
      "city": "Abilene",
      "price": 31346,
      "type": "cat",
      "rating": 9,
      "reviews": 61957,
      "imgUrl": "https://loremflickr.com/cache/resized/65535_51753613651_7e4eeca87b_b_640_480_nofilter.jpg",
      "name": "libero ullam sed",
      "id": "4"
     },
     {
      "city": "Murrieta",
      "price": 38140,
      "type": "insect",
      "rating": 9,
      "reviews": 35523,
      "imgUrl": "https://loremflickr.com/cache/resized/65535_51538180961_147cd85f8c_c_640_480_nofilter.jpg",
      "name": "ipsum modi qui",
      "id": "5"
     },
     {
      "city": "Santa Barbara",
      "price": 17751,
      "type": "snake",
      "rating": 9,
      "reviews": 15152,
      "imgUrl": "https://loremflickr.com/cache/resized/111_309009698_47fa4448ed_c_640_480_nofilter.jpg",
      "name": "illum amet ut",
      "id": "6"
     },
     {
      "city": "Altoona",
      "price": 16912,
      "type": "bear",
      "rating": 9,
      "reviews": 30147,
      "imgUrl": "https://loremflickr.com/cache/resized/65535_51429422346_846833d746_c_640_480_nofilter.jpg",
      "name": "nihil aut at",
      "id": "7"
     },
     {
      "city": "Kokomo",
      "price": 44072,
      "type": "snake",
      "rating": 9,
      "reviews": 68922,
      "imgUrl": "https://loremflickr.com/cache/resized/65535_51733775999_095cfc05c7_b_640_480_nofilter.jpg",
      "name": "in harum veniam",
      "id": "8"
     },
     {
      "city": "Coon Rapids",
      "price": 35290,
      "type": "bird",
      "rating": 9,
      "reviews": 15216,
      "imgUrl": "https://loremflickr.com/cache/resized/65535_51640377663_db4c5cf7d9_c_640_480_nofilter.jpg",
      "name": "numquam officiis aut",
      "id": "9"
     },
     {
      "city": "San Jacinto",
      "price": 75560,
      "type": "fish",
      "rating": 9,
      "reviews": 12083,
      "imgUrl": "https://loremflickr.com/cache/resized/65535_51753613651_7e4eeca87b_b_640_480_nofilter.jpg",
      "name": "repellendus vel at",
      "id": "10"
     }
  ]
  """