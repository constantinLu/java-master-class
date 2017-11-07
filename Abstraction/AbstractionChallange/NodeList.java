package MasterClass.Abstraction.AbstractionChallange;

/**
 * Created by LunguC on 21.08.2017.
 */
public interface NodeList {

    ListItem getRoot();

    boolean addItem(ListItem item);

    boolean removeItem(ListItem item);

    void traverse(ListItem root);


}
