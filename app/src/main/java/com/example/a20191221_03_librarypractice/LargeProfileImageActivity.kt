package com.example.a20191221_03_librarypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_large_profile_image.*

class LargeProfileImageActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_large_profile_image)
    }

    override fun setValues() {

    }

    override fun setupEvents() {
        val imageURL=intent.getStringArrayExtra("imgUrl")

        Glide.with(mContext).load(imageURL).into(largeImageView)
    }


}
