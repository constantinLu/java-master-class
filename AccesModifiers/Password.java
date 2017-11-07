package MasterClass.AccesModifiers;

/**
 * Created by LunguC on 22.08.2017.
 */
public class Password {

    private static final int key = 635644;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        return password ^ key;
    }


    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);

    }

    public boolean letMeIn(int password) {
        if (encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Acces denied !");
            return false;
        }

    }
}
