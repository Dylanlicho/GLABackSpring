package fr.univlorraine.apde.securityJWT.payloads;

/**
 *
 * @author DylanLICHO
 */
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private int id;
    private String login;

    public JwtResponse(String accessToken, int id, String login) {
        this.token = accessToken;
        this.id = id;
        this.login = login;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
