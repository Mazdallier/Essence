package net.essence.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class RegistryFile {

	protected String         fileName;
	protected String[]       paths;
	protected BufferedWriter writer;

	public RegistryFile(String fileName, String... paths) {
		this.fileName = fileName;
		this.paths = paths;
		File file = null;
		boolean exists = false;
		for (int i = 0; i < paths.length; i++) {
			file = new File(paths[i]);
			exists = file.exists();
			if (exists) {
				LogHelper.debug("Registry directory found at index " + i + ": " + paths[i]);
				file = new File(paths[i] + fileName);
				break;
			}
			LogHelper.debug("Registry directory expected but not found at index " + i + ": " + paths[i] + " ... Moving on to next potential directory");
		}
		if (!exists) {
			LogHelper.debug("No provided registry directory in the array was found, creating default file at base project directory");
			file = new File("." + fileName);
		}

		try {
			if (file.exists()) {
				LogHelper.debug("Overriding registry file: " + file.getAbsolutePath());
				file.delete();
			}
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract void addNames();

	public void localizeName(String prefixOfLine, String unlocalizedName) {
		String name = unlocalizedName.substring(5);
		char firstLetter = name.charAt(0);
		int numChars = 0;
		if (Character.isLowerCase(firstLetter))
			firstLetter = Character.toUpperCase(firstLetter);

		String inGame = name.substring(1);
		String temp = inGame;
		for (int p = 1; p < temp.length(); p++) {
			char c = inGame.charAt(p);
			int code = (int) c;

			if (inGame.charAt(p - 1) != ' ') {
				for (int n = 65; n < 90; n++) {
					if (code == n)
						inGame = new StringBuffer(inGame).insert(p, " ").toString();
				}
			}
		}
		String finalName = firstLetter + inGame;
		addToFile(prefixOfLine + "." + name + ".name=" + finalName, name);
	}

	public void addName(String prefix, String keyName, String inGameName){
		addToFile(prefix + '.' + keyName + '=' + inGameName, keyName);
	}

	public String readFile(String path) {
		StringBuilder source = new StringBuilder();
		BufferedReader reader = null;
		File file = new File(path);
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				source.append(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return source.toString();
	}

	public void addToFile(String inGame, String oldName) {
		try {
			String temp = inGame;
			LogHelper.dev("Registered new name, " + oldName + " became: " + temp.substring(temp.indexOf('=') + 1));
			writer.write(inGame + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addToFile(String text){
		try {
			writer.write(text + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeFile() {
		try {
			writer.close();
			LogHelper.debug("Registry file: " + fileName + " closed");
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.debug("Unable to close registry file: " + fileName);
		}
	}
}