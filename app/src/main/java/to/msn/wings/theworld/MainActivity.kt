package to.msn.wings.theworld

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.media.AudioAttributes
import android.os.Build
import android.view.animation.RotateAnimation
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool
    private var soundOne = 0
    private var soundTwo = 0

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val audioAttributes = AudioAttributes.Builder()
            // USAGE_MEDIA
            // USAGE_GAME
            .setUsage(AudioAttributes.USAGE_GAME)
            // CONTENT_TYPE_MUSIC
            // CONTENT_TYPE_SPEECH, etc.
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            // ストリーム数に応じて
            .setMaxStreams(2)
            .build()

        // one.wav をロードしておく
        soundOne = soundPool.load(this, R.raw.start, 1)

        // two.wav をロードしておく
        soundTwo = soundPool.load(this, R.raw.end, 1)

        // load が終わったか確認する場合
        soundPool.setOnLoadCompleteListener{ soundPool, sampleId, status ->
            Log.d("debug", "sampleId=$sampleId")
            Log.d("debug", "status=$status")
    }

        button1.setOnClickListener{
            // start.wav の再生
            // play(ロードしたID, 左音量, 右音量, 優先度, ループ, 再生速度)
            soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1.0f)
        }

        button2.setOnClickListener {
            // end.wav の再生
            soundPool.play(soundTwo, 1.0f, 1.0f, 1, 0, 1.0f)
        }
    }



}