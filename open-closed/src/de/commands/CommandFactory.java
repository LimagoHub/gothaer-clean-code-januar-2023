package de.commands;

import de.main.Main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

public class CommandFactory {
	private static final String PREFIX = "de.commands.";
	private static final String SUFFIX = "Command";

	public static Command createCommand(String zeile) {
		try {

			String[] tokens = zeile.split(" ");

			Command result = (Command) Class.forName(PREFIX + tokens[0] + SUFFIX).getConstructor().newInstance();
			result.parse(tokens);
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
}

