import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tmezek.R
import com.example.tmezek.data.Song

class PlayerFragment : Fragment() {

    private lateinit var song: Song
    private lateinit var seekBar: SeekBar
    private lateinit var startTimer: TextView
    private lateinit var endTimer: TextView
    private lateinit var playPauseButton: ImageButton
    private lateinit var backBtn: ImageView

    private val handler = Handler(Looper.getMainLooper())
    private var isPlaying = false
    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            song = it.getParcelable("song")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seekBar = view.findViewById(R.id.seekBar)
        startTimer = view.findViewById(R.id.startTimer)
        endTimer = view.findViewById(R.id.endTimer)
        playPauseButton = view.findViewById(R.id.playPauseButton)
        backBtn = view.findViewById(R.id.backBtn)

        // Set song details
        view.findViewById<TextView>(R.id.song_name).text = song.title
        view.findViewById<TextView>(R.id.artist_name).text = song.artist.joinToString(", ")
        view.findViewById<ImageView>(R.id.song_image).setImageResource(song.coverImage)

        // Set SeekBar max value to song duration
        val songDuration = song.duration // Assuming `duration` is in milliseconds
        seekBar.max = songDuration
        endTimer.text = formatTime(songDuration)

        // Set up play/pause button
        playPauseButton.setOnClickListener {
            togglePlayPause()
        }

        backBtn.setOnClickListener{
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        // Handle SeekBar interactions
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    currentPosition = progress
                    startTimer.text = formatTime(progress)
                    // Update the playback position if using a media player
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                handler.removeCallbacks(updateSeekBarRunnable)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                handler.post(updateSeekBarRunnable)
            }
        })

        // Start SeekBar update loop
        updateSeekBar()
    }

    private fun togglePlayPause() {
        isPlaying = !isPlaying
        if (isPlaying) {
            playPauseButton.setImageResource(R.drawable.pause_circle_outline_24) // Update with your pause icon
            handler.post(updateSeekBarRunnable)
        } else {
            playPauseButton.setImageResource(R.drawable.play_circle_outline_24) // Update with your play icon
            handler.removeCallbacks(updateSeekBarRunnable)
        }
    }

    private fun updateSeekBar() {
        handler.postDelayed(updateSeekBarRunnable, 1000)
    }

    private val updateSeekBarRunnable = object : Runnable {
        override fun run() {
            if (isPlaying) {
                currentPosition += 1000 // Simulate 1 second of playback
                if (currentPosition <= seekBar.max) {
                    seekBar.progress = currentPosition
                    startTimer.text = formatTime(currentPosition)
                    handler.postDelayed(this, 1000)
                } else {
                    isPlaying = false
                    playPauseButton.setImageResource(R.drawable.play_circle_outline_24)
                    handler.removeCallbacks(this)
                }
            }
        }
    }

    private fun formatTime(milliseconds: Int): String {
        val minutes = milliseconds / 1000 / 60
        val seconds = milliseconds / 1000 % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(updateSeekBarRunnable)
    }
}
