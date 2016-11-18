# secondfragment
Material Design风   第一话(Fragment +ViewPager+TabLayout)
```

**先看下效果!**
------

----------

XML文件
-----

带有侧滑栏。。。（必须用到android:layout_gravity="start"，必须把xml分成两个模块，左边---右边）

TabLayout。。。（要用            app:tabGravity="fill" 如果写成“center”会挤在中间，
            app:tabMode="fixed"如果写成“Scrollable”会靠在左边

）

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#ffffff"
    >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <!--
           android design library提供的TabLayout控件
           tabIndicatorColor：菜单下方移动的横线的颜色
           tabSelectedTextColor ：菜单被选中之后的颜色
           tabTextColor : 菜单正常的颜色
           app:tabTextAppearance : 添加样式，这里加了样式主要是为了在文字前面加一个图所用，就是把textAllCaps设置成false
       -->
        <android.support.design.widget.TabLayout
            android:id="@+id/tablayout"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:layout_marginTop="30dp"
            android:background="@color/blue_words"
            app:tabGravity="fill"
            app:tabIndicatorColor="@color/white"
            app:tabMode="fixed"
            app:tabSelectedTextColor="@color/white"
            app:tabTextAppearance="@style/MyLayoutTextAp"
            app:tabTextColor="@color/black">
        </android.support.design.widget.TabLayout>

        <android.support.v4.view.ViewPager
            android:id="@+id/vp"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_marginBottom="50dp"
            android:background="@color/Cb3b3b3">

        </android.support.v4.view.ViewPager>

    </LinearLayout>

    <LinearLayout
        android:layout_width="200dp"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:background="@color/blue_words">

    </LinearLayout>
</android.support.v4.widget.DrawerLayout>

```
 -----------------------------------------------------------------------------------

这个用来设置title里的字体
```
 <style name="MyLayoutTextAp" parent="TextAppearance.AppCompat.Widget.ActionBar.Title">
        <item name="android:textColor"> @color/blue_words</item>
        <item name="android:textSize">15dp</item>
        <item name="android:gravity">center</item>
        <item name="android:paddingLeft">20dp</item>
        <item name="android:textAllCaps">false</item>
    </style>
```
## Activity ##

```

public class MainActivity extends FragmentActivity {
    private FragmentTransaction ft;
    private MainFragment mainFragment;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private ArrayList<Fragment> fragments;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.vp);

        //viewpager每次切换的时候， 会重新创建当前界面及左右界面三个界面，
        // 每次切换都要重新oncreate, 所以只要设置viewPager setOffscreenPageLimit即可避免这个问题。
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),fragments,titles));
        tabLayout.setupWithViewPager(viewPager);

    }


    public void getData() {
        fragments =new ArrayList<>();
        mainFragment = new MainFragment();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragments.add(mainFragment);
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        titles = new ArrayList<>();
        titles.add("第一话");
        titles.add("第二话");
        titles.add("第三话");
        titles.add("第四话");
    }
}
```
