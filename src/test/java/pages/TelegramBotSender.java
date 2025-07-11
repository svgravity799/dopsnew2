package pages;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TelegramBotSender {

    private static final String TOKEN = "7627142560:AAHV73ovchgTukn4HUdlOQUNSptiXZDiNA8";
    private static final String CHAT_ID = "6164103463"; // ← сюда вставь chat_id

    public static void sendMessage(String message) {
        try {
            String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
            String requestUrl = "https://api.telegram.org/bot" + TOKEN
                    + "/sendMessage?chat_id=" + CHAT_ID
                    + "&text=" + encodedMessage;

            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream response = conn.getInputStream();
            response.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
