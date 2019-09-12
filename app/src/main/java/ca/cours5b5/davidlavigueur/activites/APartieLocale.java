package ca.cours5b5.davidlavigueur.activites;

import ca.cours5b5.davidlavigueur.R;
import ca.cours5b5.davidlavigueur.global.GLog;

public class APartieLocale extends Activite {
    @Override
    protected int getLayoutId() {
        GLog.appel(this);
        return R.layout.page_partie_locale;
    }
}
