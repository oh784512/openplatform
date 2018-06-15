package openplatform.openplatform_finalproject;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class Item {

    private final String uUid;
    private final String UserId;
    private String Title;
    private String Context;
    private final String Username;

    public Item(String uUid, String UserId, String Title, String Context, String Username) {
        this.uUid = uUid;
        this.UserId = UserId;
        this.Title = Title;
        this.Context = Context;
        this.Username = Username;
    }

    public String getuUid() {
        return uUid;
    }

    public String UserId() {
        return UserId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String newTitle) {
        Title = newTitle;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String newContext) {
        Context = newContext;
    }

    public String getUsername() {
        return Username;
    }
}
