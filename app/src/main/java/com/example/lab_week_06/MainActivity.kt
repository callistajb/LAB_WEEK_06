package com.example.lab_week_06

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender
import com.example.lab_week_06.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        //Glide is used here to load the images
        //Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        //Setup the layout manager for the recycler view
        //A layout manager is used to set the structure of the item views
        //For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        //Instantiate ItemTouchHelper for the swipe to delete callback and
        //attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        //Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                //1
                CatModel(
                    Gender.Male,
                    breed = CatBreed.Abyssinian,
                    name = "Leon",
                    biography = "Active and affectionate",
                    "https://cdn2.thecatapi.com/images/unPP08xOZ.jpg"
                ),
                //2
                CatModel(
                    Gender.Female,
                    breed = CatBreed.EgyptianMau,
                    name = "Cleopatra",
                    biography = "Shy, but gentle",
                    imageUrl = "https://cdn2.thecatapi.com/images/AH61b9ziS.jpg"
                ),
                //3
                CatModel(
                    Gender.Unknown,
                    breed = CatBreed.YorkChocolate,
                    name = "Coco Chanel",
                    biography = "Chic adventurer",
                    "https://cdn2.thecatapi.com/images/LzVDEMYIv.jpg"
                ),
                //4
                CatModel(
                    Gender.Unknown,
                    breed = CatBreed.Cheetoh,
                    name = "Yves",
                    biography = "Wild at heart",
                    imageUrl = "https://cdn2.thecatapi.com/images/L-aDi29wP.jpg"
                ),
                //5
                CatModel(
                    Gender.Female,
                    breed = CatBreed.Munchkin,
                    name = "Princess",
                    biography = "Short queen",
                    imageUrl = "https://cdn2.thecatapi.com/images/G0JPLrMFg.jpg"
                ),
                //6
                CatModel(
                    Gender.Female,
                    breed = CatBreed.Himalayan,
                    name = "Twilight",
                    biography = "Zen cuddlebug",
                    imageUrl = "https://cdn2.thecatapi.com/images/L-aDi29wP.jpg"
                ),
                //7
                CatModel(
                    Gender.Male,
                    breed = CatBreed.Oriental,
                    name = "Anakin",
                    biography = "Drama master",
                    imageUrl = "https://cdn2.thecatapi.com/images/LutjkZJpH.jpg"
                ),
                //8
                CatModel(
                    Gender.Male,
                    breed = CatBreed.CaliforniaSpangled,
                    name = "Dale",
                    biography = "Acrobat on paws",
                    imageUrl = "https://cdn2.thecatapi.com/images/B1ERTmgph.jpg"
                ),
                //9
                CatModel(
                    Gender.Unknown,
                    breed = CatBreed.Manx,
                    name = "Louis",
                    "Tail-less charm",
                    imageUrl = "https://cdn2.thecatapi.com/images/Rscv6E1c5.jpg"
                ),
                //10
                CatModel(
                    Gender.Female,
                    breed = CatBreed.ChantillyTiffany,
                    name = "Denise",
                    biography = "Velvet diva",
                    imageUrl = "https://cdn2.thecatapi.com/images/TR-5nAd_S.jpg"
                )
            )
        )

    }

    //This will create a pop up dialog when one of the items from the recycler view is clicked.
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            //Set the title of the dialog
            .setTitle("Cat Selected")
            //Set the message fro the dialog
            .setMessage("You have selected cat ${cat.name}")
            //Set if the OK button should be enabled
            .setPositiveButton("OK") {_, _ -> }.show()
    }
}