package com.example.hackidc2021

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import kotlinx.android.synthetic.main.activity_recorder.*
import kotlinx.android.synthetic.main.activity_recorder.button3
import java.lang.Exception

class recorder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recorder)
        // Allow for speech-to-text.
        btnSpeak.setOnClickListener(View.OnClickListener {
            getSpeechInput()
        })

        button3.setOnClickListener{
            val intent = Intent(this, FinishActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getSpeechInput() {
        try {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            );
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech recognition demo");
            startActivityForResult(intent, 10)
        } catch (e: ActivityNotFoundException) {
            val appPackageName: String = "com.google.android.googlequicksearchbox";
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + appPackageName)
                    )
                );
            } catch (anfe: Exception) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)
                    )
                );
            }
        }

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode, data
        )
        when (requestCode) {
            10 -> if (resultCode == RESULT_OK &&
                data != null
            ) {
                val result =
                    data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS
                    )
                txvResult.text = result?.get(0)
            }
        }
    }
}