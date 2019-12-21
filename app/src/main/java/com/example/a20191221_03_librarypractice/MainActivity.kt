package com.example.a20191221_03_librarypractice

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()
    }
    override fun setValues() {
        Glide.with(mContext).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRi07RFq6QrjZQFA7CG6HAkaDYpTVeUV0QvJ8szgAPDi6osYa1w").into(iuImgView)
    }

    override fun setupEvents() {
        callBtn.setOnClickListener {
//        전화 권한 (3) 요청 => 획득 완료 되면(1) => 인텐트를 이용해서 전화걸기(2)

            val permissionListener = object : PermissionListener{
                override fun onPermissionGranted() {
//                    권한 획득 성공 상태
                    val uri = Uri.parse("tel:01051123237")
                    val intent = Intent(Intent.ACTION_CALL,uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext,"전화 권한을 허용해야 걸 수 있습니다.",Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext).setPermissionListener(permissionListener).setDeniedMessage("권한 설정이 필요합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE).check()  // 쓸데없이 임포트된 클래스 제거 단축키
        }
    }


}
