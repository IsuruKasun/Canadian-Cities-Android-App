package com.example.canadiancities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    private lateinit var image : ImageView
    var places = arrayOf("Ottawa", "Vancouver", "Montreal", "Quebec", "Toronto")
    private var ottawaDescription = "Ottawa, the capital city of Canada, is situated on the Ottawa River in Ontario. It's recognized for its impressive parliamentary buildings, cultural institutions like the National Gallery of Canada, and outdoor attractions, including beautiful parks and the Rideau Canal. Ottawa is a bilingual city with a rich history and serves as the political and administrative center of Canada."
    private var VancouverDescription = "Vancouver, a coastal city in British Columbia, Canada, is renowned for its stunning natural scenery, including mountains and ocean. It's a vibrant multicultural city with diverse neighborhoods, a thriving arts scene, and numerous outdoor recreational opportunities. Vancouver is also a major economic center and consistently ranks high for its quality of life."
    private var MontrealDescription = "Montreal, located in the province of Quebec, Canada, is a dynamic and culturally rich city. Known for its historic architecture, vibrant arts scene, and diverse culinary offerings, Montreal is a bilingual metropolis with a European flair. It hosts numerous festivals, including the renowned Montreal Jazz Festival, and is recognized for its friendly atmosphere and lively street life."
    private var QuebecDescription = "Quebec City, the capital of the province of Quebec in Canada, is a historic gem with cobblestone streets and charming architecture reminiscent of Old Europe. Situated along the St. Lawrence River, Quebec City is famous for its iconic Château Frontenac, fortified city walls, and the bustling Old Town. With a unique blend of French and North American influences, Quebec City offers a distinct cultural experience, celebrated festivals, and a glimpse into Canada's early colonial history."
    private var TorontoDescription = "Toronto, the largest city in Canada and the capital of Ontario, is a dynamic metropolis with a diverse cultural mosaic. Renowned for its iconic skyline, including the CN Tower, Toronto is a global financial and cultural hub. The city boasts world-class museums, theaters, and sports teams, reflecting its vibrant and cosmopolitan character. With numerous neighborhoods offering a mix of modernity and history, Toronto stands as a symbol of multiculturalism and economic prominence in Canada."

    var description = arrayOf(ottawaDescription, VancouverDescription, MontrealDescription, QuebecDescription, TorontoDescription  )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var next = findViewById<ImageButton>(R.id.ButtonNext)
        var back = findViewById<ImageButton>(R.id.ButtonBack)
        var placeName = findViewById<TextView>(R.id.tvPlace)
        var des = findViewById<TextView>(R.id.tvDescription)

        next.setOnClickListener{
            //get the next photo
            var idCurrentImageString = "pic$currentImage" // pic + currentImage
            // get the integer address with each photo
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            // get the next image when button clicked
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f // make image invisible


            currentImage = (5 + currentImage + 1)%5

            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            // get the next image when button clicked
            image = findViewById(idImageToShowInt)
            image.alpha= 1f

            placeName.text = places[currentImage]
            des.text = description[currentImage]



        }

        back.setOnClickListener{
            //get the previous photo
            var idCurrentImageString = "pic$currentImage" // pic + currentImage
            // get the integer address with each photo
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            // get the next image when button clicked
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f // make image invisible


            currentImage = (5 + currentImage - 1)%5

            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            // get the next image when button clicked
            image = findViewById(idImageToShowInt)
            image.alpha= 1f

            placeName.text = places[currentImage]
            des.text = description[currentImage]
        }
    }
}