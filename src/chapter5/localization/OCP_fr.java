package chapter5.localization;

import java.util.ListResourceBundle;

public class OCP_fr extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"hello", "Alo"}};
    }
}