package cse213.group24badc;

public class PW {
    private String userName, passWord;
    private String EncodedPassword;

    public PW(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public void Save() {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : passWord.toCharArray()) {
            encrypted.append((char) (ch + 3));
        }
        setPassword(encrypted.toString());
    };

    public String getPassword() {
        StringBuilder decrypted = new StringBuilder();

        // Reverse the shift to get the original characters
        for (char ch : passWord.toCharArray()) {
            decrypted.append((char) (ch - 3));
        }
        return decrypted.toString();
    };
    public void setPassword(String password) {
        this.passWord = password;
    }
    public String ShowPassword() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }
}
