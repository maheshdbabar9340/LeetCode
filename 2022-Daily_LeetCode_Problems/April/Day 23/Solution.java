// https://leetcode.com/problems/encode-and-decode-tinyurl/

public class Codec {
    Map<String, String> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        sb.append((char) Math.floor(Math.random() * 100));
        while (map.containsKey(sb.toString())) {
            sb.append((char) Math.floor(Math.random() * 100));
        }
        map.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}