package com.example.mateusmaia.poccam

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mateusmaia.poccam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mBinding = binding

        binding.acceptButton.setOnClickListener {
            Toast.makeText(this, "To be implemented", Toast.LENGTH_SHORT).show()
        }

        binding.refuseButton.setOnClickListener {
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        mBinding?.camera?.start()
    }

    override fun onPause() {
        mBinding?.camera?.stop()
        super.onPause()
    }
}
