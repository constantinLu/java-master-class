package MasterClass.AccesModifiers;

/**
 * Created by LunguC on 24.08.2017.
 */
public class ExtendedPassword extends Password {

    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    //@Override
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }


}

