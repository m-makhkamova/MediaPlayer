package uz.itschool.mediaplayer2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.itschool.mediaplayer2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var musicList = mutableListOf<Music>().apply {
            add(Music("Konsta-Odamlar nima deydi?", R.raw.odamlar))
            add(Music("Konsta-Havo", R.raw.havo))
            add(Music("Konsta-Nafas", R.raw.nafas))
            add(Music("Konsta-Boy", R.raw.boy))
            add(Music("Konsta-USA", R.raw.usa))
            add(Music("Konsta-O'zbekistonlik", R.raw.uzbekistonlik))
            add(Music("Konsta-Takoy Lyoxkiy", R.raw.takoy))
        }
        binding.rv.adapter = MusicAdapter(musicList)
          var status = false
        binding.play.setOnClickListener {
            if(!status){
                 mediaPlayer = MediaPlayer.create(this, musicList[0].media)
                mediaPlayer.start()
                status = true
            }
            else{
                mediaPlayer.pause()
                status = false
            }
        }

    }
}