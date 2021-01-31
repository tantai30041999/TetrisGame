package sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	private Clip clip;
	private long clipTimePosition;

	public void play(String musicLocation) {
		File musicPath = new File(musicLocation);
		if (musicPath.exists()) {
			try {
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicPath);
				AudioFormat format = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(audioStream);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
				ex.printStackTrace();
			}
			
		}
	}

	public void pause() {
		if (clip.isRunning()) {
			clipTimePosition = clip.getMicrosecondPosition();
			clip.stop();
		} else {
			clip.setMicrosecondPosition(clipTimePosition);
			clip.start();
		}
	}

	public void stop() {
		clip.stop();
	}
	public static void main(String[] args) {
		Music music = new Music();
		music.play("music\\GameAudio.wav");
	}
}
