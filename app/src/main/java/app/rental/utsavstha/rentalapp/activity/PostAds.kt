package app.rental.utsavstha.rentalapp.activity

import android.app.Activity
import android.content.ContentUris
import android.content.Context
import android.content.ContextWrapper
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.ImageView

import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.ArrayList

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.Utils.CheckPermission
import app.rental.utsavstha.rentalapp.Utils.ShowMessage
import app.rental.utsavstha.rentalapp.Utils.Utility
import app.rental.utsavstha.rentalapp.adapters.PostAdsViewPager
import app.rental.utsavstha.rentalapp.interfaces.CallBacks
import kotlinx.android.synthetic.main.activity_post_ads.*
import me.relex.circleindicator.CircleIndicator

class PostAds : AppCompatActivity() {

    private lateinit var postAdsViewPager: PostAdsViewPager
    private lateinit var viewPager: ViewPager
    private lateinit var indicator: CircleIndicator
    private val PICK_GALLEY_REQUEST = 10
    private val PICK_CAMERA_REQUEST = 11
    private lateinit var imageView: ImageView
    private var image_url: String? = null
    private lateinit var resources: MutableList<Bitmap>
    internal var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_ads)
        viewPager = findViewById(R.id.vp_images)
        indicator = findViewById(R.id.indicator)

        resources = ArrayList()

        resources.add(Utility.drawableToBitmap(ContextCompat.getDrawable(this, R.drawable.image)))
        resources.add(Utility.drawableToBitmap(ContextCompat.getDrawable(this, R.drawable.image)))
        resources.add(Utility.drawableToBitmap(ContextCompat.getDrawable(this, R.drawable.image)))
        resources.add(Utility.drawableToBitmap(ContextCompat.getDrawable(this, R.drawable.image)))
        resources.add(Utility.drawableToBitmap(ContextCompat.getDrawable(this, R.drawable.image)))


        postAdsViewPager = PostAdsViewPager(this, resources, (object: CallBacks.PostAdsCallBack{
            override fun onImageClicked(position1: Int, imageView1: ImageView) {
                selectImage()
                position = position1
                imageView = imageView1
            }

        }))

        viewPager.adapter = postAdsViewPager
        indicator.setViewPager(viewPager)
        postAdsViewPager.registerDataSetObserver(indicator.dataSetObserver)
    }

    private fun selectImage() {
        val items = arrayOf<CharSequence>("Take Photo", "Choose from Library", "Cancel")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add Photo!")
        builder.setItems(items) { dialog, item ->
            val result = CheckPermission.checkAndRequestPermissions(this@PostAds)
            if (items[item] == "Take Photo") {
                if (result)
                    cameraIntent()
            } else if (items[item] == "Choose from Library") {
                if (result)
                    galleryIntent()
            } else if (items[item] == "Cancel") {
                dialog.dismiss()
            }
        }
        builder.show()
    }

    private fun cameraIntent() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, PICK_CAMERA_REQUEST)
    }

    private fun galleryIntent() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT//
        startActivityForResult(Intent.createChooser(intent, "Select File"), PICK_GALLEY_REQUEST)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_GALLEY_REQUEST)
                onSelectFromGalleryResult(data)
            else if (requestCode == PICK_CAMERA_REQUEST)
                onCaptureImageResult(data)
        }
    }

    private fun onSelectFromGalleryResult(data: Intent?) {
        if (data != null && data.data != null) {

            val uri = data.data

            try {
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                if (bitmap != null) {
                    image_url = Utility.getRealPathFromURI(this, uri)
                    val inputStream = contentResolver.openInputStream(uri)

                    resources[position] = Utility.changeBitmapToThumbnail(this@PostAds, bitmap, 1000)
                    postAdsViewPager.notifyDataSetChanged()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    private fun onCaptureImageResult(data: Intent) {

        val bmp = data.extras.get("data") as Bitmap
        Log.e("width and height", bmp.width.toString() + "/" + bmp.height)
        val filePath = storeImageInternalStorage(bmp)

        val file = File(filePath, "menuImage.png")
        var fis: FileInputStream
        try {
            fis = FileInputStream(file)
            val b = BitmapFactory.decodeStream(fis)
            resources[position] = Utility.changeBitmapToThumbnail(this@PostAds, b, 1000)
            postAdsViewPager.notifyDataSetChanged()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        image_url = file.absolutePath
    }

    private fun storeImageInternalStorage(bmp: Bitmap): String {
        val cw = ContextWrapper(applicationContext)
        // path to /data/data/yourapp/app_data/imageDir

        val directory = cw.getDir("imageDir", Context.MODE_PRIVATE)

        //byte[] byteArray = stream.toByteArray();

        val file = File(directory, "menuImage.png")

        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(file)
            // Use the compress method on the BitMap object to write image to the OutputStream
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                fos!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        return directory.absolutePath
    }


}
