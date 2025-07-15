package pages;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TelegramBotSender {

    private static final String TOKEN = "7627142560:AAHV73ovchgTukn4HUdlOQUNSptiXZDiNA8";
    private static final String CHAT_ID = "-1002416412382"; // ← сюда вставь chat_id

    public static void sendMessage(String message) {
        try {
            String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
            String requestUrl = "https://api.telegram.org/bot" + TOKEN
                    + "/sendMessage?chat_id=" + CHAT_ID
                    + "&text=" + encodedMessage;

            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            try (InputStream response = conn.getInputStream()) {
                // читаем и закрываем
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithScreenshot(String message, byte[] screenshot) {
        try {
            String boundary = "===" + System.currentTimeMillis() + "===";
            URL url = new URL("https://api.telegram.org/bot" + TOKEN + "/sendPhoto");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            try (
                    OutputStream outputStream = connection.getOutputStream();
                    PrintWriter writer = new PrintWriter(outputStream, true, StandardCharsets.UTF_8)
            ) {
                // chat_id
                writer.append("--").append(boundary).append("\r\n");
                writer.append("Content-Disposition: form-data; name=\"chat_id\"\r\n\r\n");
                writer.append(CHAT_ID).append("\r\n");

                // caption (весь текст сообщения)
                writer.append("--").append(boundary).append("\r\n");
                writer.append("Content-Disposition: form-data; name=\"caption\"\r\n\r\n");
                writer.append(message).append("\r\n");

                // photo
                writer.append("--").append(boundary).append("\r\n");
                writer.append("Content-Disposition: form-data; name=\"photo\"; filename=\"screenshot.png\"\r\n");
                writer.append("Content-Type: image/png\r\n\r\n");
                writer.flush();

                outputStream.write(screenshot);
                outputStream.flush();

                writer.append("\r\n").flush();
                writer.append("--").append(boundary).append("--\r\n").flush();
            }

            try (InputStream response = connection.getInputStream()) {
                // читаем и закрываем
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
