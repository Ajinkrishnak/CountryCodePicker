package com.ak.sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import com.ak.sample.databinding.ActivitySampleBinding
import com.ak.sample.utils.errorSnack

class SampleActivity : AppCompatActivity() {
    private var binding: ActivitySampleBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        init()
    }

    private fun init() {

        handleEvents()
    }

    private fun handleEvents() {
        binding?.btnSubmit?.setOnClickListener {
            val mFirstName = binding?.etFirstName?.text.toString()
            val mLastName = binding?.etLastName?.text.toString()
            val mEmail = binding?.etEmail?.text.toString()
            val mob = binding?.etMobile?.text.toString()
            val phoneCode = binding?.ccpPhone?.selectedCountryCode()
            val mMobile = phoneCode + mob
            if (validation(
                    mFirstName,
                    mLastName,
                    mEmail,
                    mob
                )
            ) {
                alertDialog(
                    "FirstName = $mFirstName" +
                            "\nLastName = $mLastName" +
                            "\nEmail = $mEmail" +
                            "\nMobile = $mMobile"
                )
            }
        }

    }

    private fun validation(
        firstName: String,
        lastName: String,
        email: String,
        mobile: String
    ): Boolean {
        return if (TextUtils.isEmpty(firstName)) {
            binding?.root?.errorSnack("Please enter your first name.")
            false
        } else if (TextUtils.isEmpty(lastName)) {
            binding?.root?.errorSnack("Please enter your last name.")
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding?.root?.errorSnack("Please enter your valid email.")
            false
        } else if (TextUtils.isEmpty(mobile)) {
            binding?.root?.errorSnack("Please enter your valid Phone Number.")
            false
        } else {
            true
        }
    }

    private fun alertDialog(fields: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("....Fields....")
        builder.setMessage(fields)
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->

        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->

        }

        builder.show()
    }
}