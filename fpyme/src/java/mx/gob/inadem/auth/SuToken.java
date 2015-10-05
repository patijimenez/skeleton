package mx.gob.inadem.auth;

import org.apache.shiro.authc.AuthenticationToken;

public class SuToken implements AuthenticationToken {
    private String username;
    private String ldapDn;

    public SuToken(String username, String ldapDn) {
        this.username = username;
        this.ldapDn = ldapDn;
    }

    public String getUsername() {
        return username;
    }

    public Object getPrincipal() {
        return username;
    }

    public Object getCredentials() {
        return ldapDn;
    }

}

