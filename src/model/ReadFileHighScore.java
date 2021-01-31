package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFileHighScore {
	private ArrayList<HighScore> listHighScore;

	public ReadFileHighScore() {
		this.listHighScore = new ArrayList<>();
		try {
			FileReader file = new FileReader("src/highscore/HighScore.txt");
			BufferedReader input = new BufferedReader(file); // Read file
			String line;
			while ((line = input.readLine()) != null) {
				String str[] = line.split(":");
				String name = str[0];
				int score = Integer.parseInt(str[1]);
				HighScore highScore = new HighScore(name, score);

			}
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace(); // Erro not found file
		} catch (Exception e) {
			e.printStackTrace(); // Erro not read file
		}
	}

	public ArrayList<HighScore> getListHighScore() {
		return this.listHighScore;
	}

}
