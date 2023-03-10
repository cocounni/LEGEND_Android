@file:Suppress("DEPRECATION")

package com.example.map_dp

import android.Manifest.permission.*
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.checkSelfPermission
import com.example.map_dp.BuildConfig.API_KEY
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.*
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.activity_maps.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.text.SimpleDateFormat
import java.util.*

class MapsActivity : AppCompatActivity(), ConnectionCallbacks,
    OnConnectionFailedListener, OnMapReadyCallback {
    private lateinit var providerClient: FusedLocationProviderClient
    private lateinit var apiClient: GoogleApiClient

    var googleMap: GoogleMap? = null
    var itemname: String = "0"
    private var searchday: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // ???????????? ?????? ?????????

        val getintent = intent
        itemname = getintent.getStringExtra("ItemName").toString()

        searchday = getMonth()

        cardview.visibility = View.INVISIBLE //????????? ???????????? ????????? ????????????

        mapfun() //?????? ??????

        Mylocbtn.setOnClickListener {
            this@MapsActivity.googleMap?.clear() //?????? ???????????? ????????? ?????????
            cardview.visibility = View.GONE //????????? ???????????? ???
            onConnected(Bundle())
        } //????????? ???????????? ???????????? ?????? ?????????

        mapSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextChange(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(newText: String?): Boolean {
                    mapSearch.setQuery("", false) //????????? ?????????
                    mapSearch.clearFocus() //????????? ?????????
                    this@MapsActivity.googleMap?.clear() //?????? ???????????? ????????? ?????????
                    cardview.visibility = View.GONE //????????? ???????????? ???

                    val geocoder = Geocoder(this@MapsActivity)
                    val cor = geocoder.getFromLocationName(newText, 1)
                    try {
                        moveMap(cor[0].latitude, cor[0].longitude, itemname)
                    } catch (e: IndexOutOfBoundsException) {
                        Log.d("Map_location", "??????")
                        Toast.makeText(this@MapsActivity, "?????? ????????? ????????????.", Toast.LENGTH_LONG).show()
                    }
                    return true
                }
            }) //???????????? ?????? ?????????

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean { //???????????? ??????
        return when (item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    //??????
    private fun mapfun() {
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (it.all { permission -> permission.value == true }) {
                apiClient.connect()
            } else {
                Toast.makeText(this, "????????? ?????????????????????.", Toast.LENGTH_SHORT).show()
            }
        }
        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)

        providerClient = LocationServices.getFusedLocationProviderClient(this)
        apiClient = Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build()

        @Suppress("DEPRECATED_IDENTITY_EQUALS")
        if (checkSelfPermission(this, ACCESS_FINE_LOCATION) !== PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) !== PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(this, ACCESS_NETWORK_STATE) !== PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(
                arrayOf(
                    ACCESS_FINE_LOCATION,
                    WRITE_EXTERNAL_STORAGE,
                    ACCESS_NETWORK_STATE
                )
            )
        } else {
            apiClient.connect()
        }
    }

    private fun moveMap(latitude: Double, longitude: Double, itemname: String): Int {
        Log.d("Map_location", "$latitude, $longitude")

        val distance_list = Marketlist().marketdist(latitude, longitude)

        val dist_list = distance_list.first
        val for_addr = distance_list.second
        val geocoder = Geocoder(this@MapsActivity)

        for (i in dist_list.indices){
            val marketlatLng = LatLng(for_addr[i].lati, for_addr[i].longi)
            val addr = geocoder.getFromLocation(for_addr[i].lati, for_addr[i].longi, 10)[0].getAddressLine(0).toString() //??????
            val market_distance = for_addr[i].dist //??????

            callApi(dist_list[i], itemname, searchday, marketlatLng, addr, market_distance)
        }

        val latLng = LatLng(latitude, longitude)
        val position: CameraPosition = CameraPosition.Builder()
            .target(latLng)
            .zoom(15f)
            .build()

        googleMap!!.moveCamera(CameraUpdateFactory.newCameraPosition(position))

        val markerOptions = MarkerOptions()
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        markerOptions.position(latLng)
        markerOptions.title("??? ??????")

        googleMap?.addMarker(markerOptions)

        return 0
    }

    override fun onConnected(p0: Bundle?) {
        @Suppress("DEPRECATED_IDENTITY_EQUALS")
        if (checkSelfPermission(this, ACCESS_FINE_LOCATION) === PackageManager.PERMISSION_GRANTED) {
            providerClient.lastLocation.addOnSuccessListener(
                this,
                object : OnSuccessListener<Location> {
                    override fun onSuccess(p0: Location?) {
                        p0?.let {
                            val latitude = p0.latitude
                            val longitude = p0.longitude
                            Log.d("map_location", "$latitude, $longitude")
                            moveMap(latitude, longitude, itemname)
                        }
                    }
                }
            )
            apiClient.disconnect()
        }
    }

    override fun onConnectionSuspended(p0: Int) {
        Log.d("onConnectionSuspended", p0.toString())
        Toast.makeText(this@MapsActivity, "????????? ??????????????? ??????????????????. ?????? ??? ?????? ????????? ?????????.", Toast.LENGTH_LONG).show()
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.d("onConnectionFailed", p0.toString())
        Toast.makeText(this@MapsActivity, "????????? ??????????????? ??????????????????. ?????? ??? ?????? ????????? ?????????.", Toast.LENGTH_LONG).show()
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0
    }

    ///API///
    @SuppressLint("SimpleDateFormat")
    fun getMonth(): String {
        val calendar = Calendar.getInstance()

        calendar.add(Calendar.DAY_OF_WEEK, -1)
        calendar.firstDayOfWeek = Calendar.SATURDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)

        val TimeToDate = calendar.time
        val formatter  = SimpleDateFormat("yyyy-MM")
        val Strnow = formatter.format(TimeToDate)

        Log.d("??????", Strnow.toString())
        return Strnow
    } // ????????? ????????? ?????? ????????? ?????????????????? ?????? ????????? ???????????? ????????? ?????????


    private fun callApi(
        marketname: String,
        itemname: String,
        searchday: String,
        marketlatLng: LatLng,
        addr: String,
        market_distance: Float
    ){
        val tmp_name = marketname.replace(" ", "") // ???????????? ???????????? ?????????

        val call = ApiObject.retrofitService.GetPrice(1, 10, tmp_name, itemname, searchday)
        call.enqueue(object : retrofit2.Callback<DataClass.market> {
            @SuppressLint("SetTextI18n", "InflateParams")
            override fun onResponse(
                call: Call<DataClass.market>,
                response: Response<DataClass.market>
            ) {
                if (response.isSuccessful) {
                    try{
                        //// ???????????? ?????? ??? ?????? ?????? ?????? ////
                        val ex_day = response.body()?.ListNecessariesPricesService?.row!![0].P_DATE //??????
                        val printyear = ex_day.substring(0 until 4)
                        val printmonth = ex_day.substring(5 until 7)
                        val printday = ex_day.substring(8 until 10)

                        info.text = """${printyear}??? ${printmonth}??? ${printday}??? ?????? ??? ?????? ${itemname}??? ??????????"""

                        //// ????????? ?????? ?????? ////
                        val layoutInflater = this@MapsActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                        val marketLayout = layoutInflater.inflate(R.layout.marker_layout, null)

                        val market_marker_name: TextView = marketLayout.findViewById(R.id.market_marker_name)
                        val market_marker_price: TextView = marketLayout.findViewById(R.id.market_marker_price)

                        market_marker_name.text = response.body()!!.ListNecessariesPricesService.row[0].M_NAME
                        market_marker_price.text = response.body()!!.ListNecessariesPricesService.row[0].A_PRICE + " ???"

                        val markerOptions_market = MarkerOptions()
                        markerOptions_market.position(marketlatLng)
                        markerOptions_market.icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(marketLayout)))

                        val marker = googleMap?.addMarker(markerOptions_market)
                        marker?.tag = listOf(response.body()!!.ListNecessariesPricesService.row[0].M_NAME,
                            response.body()!!.ListNecessariesPricesService.row[0].A_PRICE,
                            response.body()!!.ListNecessariesPricesService.row[0].A_UNIT,
                            addr, market_distance.toString()) // ????????? ?????????????????? ?????? ??? ????????? ??????????????? ???????????? ????????? ??????

                        //// ???????????? ?????? ?????? ?????? ////
                        googleMap?.setOnMarkerClickListener(object :GoogleMap.OnMarkerClickListener{
                            override fun onMarkerClick(marker: Marker): Boolean {
                                if(marker.tag == null){
                                    return false
                                } // ??? ?????? ???????????? ?????????????????? ??????

                                cardview.visibility = View.VISIBLE //????????? ????????? ???????????? ?????????

                                val detail_list = marker.tag.toString().split(",")

                                market_name.text = detail_list[0].replace("[", "")
                                price.text = detail_list[1] + " ???"
                                weight.text = detail_list[2]
                                address.text = detail_list[3]
                                distance.text = detail_list[4].replace("]", "") + "km"

                                return false
                            }
                        }) //?????? ???????????? ????????? ????????? ?????? ????????????

                        googleMap!!.setOnMapClickListener(object : GoogleMap.OnMapClickListener {
                            override fun onMapClick(latLng: LatLng) {
                                cardview.visibility = View.GONE
                            }
                        }) //?????? ???????????? ????????? ?????????
                    }catch (e: NullPointerException){
                        Toast.makeText(this@MapsActivity, "?????? ????????? ??????????????? ??????????????????. ?????? ??? ?????? ????????? ?????????.", Toast.LENGTH_LONG).show()
                    }


                }
            }
            override fun onFailure(call: Call<DataClass.market>, t: Throwable) {
                Toast.makeText(this@MapsActivity, "?????? ????????? ??????????????? ??????????????????. ?????? ?????? ????????? ?????????.", Toast.LENGTH_LONG).show()
                Log.d("?????????", t.message.toString())
            }
        })

    }

    private fun createDrawableFromView(view: View): Bitmap {
        val displayMetrics = DisplayMetrics() // ??????????????? ????????? ??????
        (this@MapsActivity as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.buildDrawingCache()
        val bitmap =
            Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    } // view??? bitmap?????? ????????? market icon?????? ??????

    ///API///
    interface ApiInterface {
        @GET("${API_KEY}/json/ListNecessariesPricesService/{startRow}/{endRow}/{Mname}/{Pname}/{yearmonth}")
        fun GetPrice(
            @Path("startRow", encoded = true) startRow: Int,
            @Path("endRow", encoded = true) endRow: Int,
            @Path("Mname", encoded = true) Mname: String,
            @Path("Pname", encoded = true) Pname: String,
            @Path("yearmonth", encoded = true) yearmonth: String
        ): Call<DataClass.market>
    }
}

val retrofit = Retrofit.Builder()
    .baseUrl("http://openapi.seoul.go.kr:8088/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ApiObject {
    val retrofitService: MapsActivity.ApiInterface by lazy {
        retrofit.create(MapsActivity.ApiInterface::class.java)
    }
}
