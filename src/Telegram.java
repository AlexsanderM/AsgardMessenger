import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;

import java.io.IOException;

/**
 * Created by Sasha on 10.07.2016.
 */
public class Telegram {
    private TelegramApiBridge bridge;
    private AuthCheckedPhone checkedPhone;
    private AuthSentCode authSentCode;
    private AuthAuthorization authSignIn;
    private AuthAuthorization authSignUp;
    private Boolean checkedNumber;

    Telegram() throws IOException {
        bridge = new TelegramApiBridge("149.154.167.50:443", 31111, "b3c77fcdd3ae7ffbff0fe672347a9f1c");
    }

    public AuthCheckedPhone getCheckedPhone (String number) throws IOException {
        checkedPhone = bridge.authCheckPhone(number);
        return checkedPhone;
    }

    public Boolean isCheckedNumber(String number) throws IOException {
        checkedNumber = getCheckedPhone(number).isRegistered();
        return checkedNumber;
    }

    public AuthSentCode getAuthSendCode(String number) throws IOException {
        authSentCode = bridge.authSendCode(number);
        return authSentCode;
    }

    public AuthAuthorization signIn(String smsCode) throws IOException {
        authSignIn = bridge.authSignIn(smsCode);
        return authSignIn;
    }

    public AuthAuthorization signUp(String smsCode, String firstName, String lastName) throws IOException {
        authSignUp = bridge.authSignUp(smsCode, firstName, lastName);
        return authSignUp;
    }
}
