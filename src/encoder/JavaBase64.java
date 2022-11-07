package encoder;

import java.util.Base64;

public class JavaBase64 {
    public String encodePassword(String originalPassword){
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(originalPassword.getBytes());
        return  encodedString;
    }

    public String decodePassword(String encodedPassword){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(encodedPassword);

        return  new String(bytes);
    }

}
