package openplatform.openplatform_finalproject;

//import com.yarolegovich.discretescrollview.sample.App;
//import com.yarolegovich.discretescrollview.sample.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class Shop {

    private static final String STORAGE = "shop";

    public static Shop get() {
        return new Shop();
    }

    private Shop() {
    }

    public List<Item> getData() {
        return Arrays.asList(
                new Item("111","dd1","test1","11","87"),
                new Item("222","dd2","test2","22","877"),
                new Item("333","dd3","test3","33","8777"),
                new Item("444","dd4","test4","44","8877"),
                new Item("555","dd5","test5","55","887"),
                new Item("666","dd6","test6","66","8887"));
    }
}
