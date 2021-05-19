package ski.uniza.fri.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ski.uniza.fri.hra.Hra;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Escape the Island";
		config.width = 900;
		config.height = 724;
		config.resizable = false;
		config.gles30ContextMinorVersion = 2;
		new LwjglApplication(new Hra(), config);
	}
}