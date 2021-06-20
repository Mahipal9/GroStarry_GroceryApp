package app.grostarry;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ArharFragment arharFragment = new ArharFragment();
                return arharFragment;
            case 1:
                MoongFragment moongFragment = new MoongFragment();
                return moongFragment;
            case 2:
                UradFragment UradFragment = new UradFragment();
                return UradFragment;
            case 3:
                RajmaFragment RajmaFragment = new RajmaFragment();
                return RajmaFragment;

            case 4:
                MasoorFragment MasoorFragment = new MasoorFragment();
                return MasoorFragment;

            case 5:
                Soya SoyaFragment = new Soya();
                return SoyaFragment;


            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}