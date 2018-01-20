package cn.nju.lee.walked.view.recordlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.model.vopo.RecordVO;
import cn.nju.lee.walked.view.recordlist.adapter.RecordListAdapter;

import static com.baidu.mapapi.BMapManager.getContext;

/**
 * Created by 果宝 on 2018/1/20.
 */

public class RecordListActivity extends AppCompatActivity {
    @BindView(R.id.recordlist_rcl_list)
    RecyclerView mRecyclerView;

    private List<RecordVO> recordVOList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordlist);
        ButterKnife.bind(this);
        initRecordList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new RecordListAdapter(getContext(), recordVOList));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(new RecordListAdapter(getContext(), recordVOList));
    }

    private void initRecordList() {
        recordVOList = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            recordVOList.add(new RecordVO("周围子", "2017年9月7日",
                    "一个专拍表情包的伪文青\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "我对韩寒并不是很了解，小时候忠于漫画却不是很爱小说。第一次接触到跟韩寒有关的是《后会无期》这部电影。我喜欢那里面的人物那种没有结局的结局，人生不到最后一刻，哪有结局。\n" +
                            "\n" +
                            "告别一定要多用一点力，因为任何多看一眼，都有可能成为最后一眼，多说一句，都有可能成为最后一句。我们不断在赶路，遇到很多人很多事，最后能留下一个人，珍藏一件事，就够了。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "听说哈尔滨也有了韩寒开的餐厅，于是我们搜索了一下，发现在哈尔滨中央大街的金安国际有一家，于是我们就赶赴到了这家店。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "进门随处可见餐厅的名字，很高兴遇见你，Nice Meeting You ~！ 从灯光的投影到摆放餐具的桌台。看着这名字，配上桌上的花束，小有情侣用餐的情调。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "然而这么有情调的餐厅\n" +
                            "\n" +
                            "我们是俩男生去吃的...\n" +
                            "\n" +
                            "中间还插了两朵玫瑰花\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "走进店后\n" +
                            "\n" +
                            "我当时的表情是这样的↓↓↓\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "在整个用餐过程中\n" +
                            "\n" +
                            "店里弥漫着恋爱的酸臭味...\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "餐桌上摆放了韩寒的照片，此外餐厅点菜比较人性化，是用平板点餐，下单后厨房就开始制作。甜品的还有先上和后上的选项，非常人性化。（请忽略我忘记拍他家的平板菜单了）接下来我们就来介绍一下菜品吧。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "你没吃过我的豆腐\n" +
                            "\n" +
                            "这道菜选用的是内酯豆腐，上面浇上了泰式辣酱，口味酸甜，撒上了芝麻，泰椒，香菜和虾仁。豆腐很嫩，至于吃豆腐这件事嘛？你猜我吃没吃过呢？\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "黑胡椒意面 海鲜番茄意面\n" +
                            "\n" +
                            "黑胡椒意面里配了彩椒和肉丝，黑胡椒味道不浓，感觉刚刚好；海鲜番茄意面番茄味道很浓，里面放了黑橄榄，所谓海鲜里面只有虾仁而已。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "纸牌屋肋排BBQ\n" +
                            "\n" +
                            "肋排我们选择的小份的，有3个肋排，肉质比较软烂，烤制稍有些焦，肋排有些薄。配菜有沙拉，酸黄瓜和绿叶菜（生菜和苦菊），搭配起来颜值不错。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "寒之寒\n" +
                            "\n" +
                            "两块奶砖，里面融入了坚果碎，底部放了巧克力酱，奶砖上淋了两种果酱。个人不太喜欢上面淋的果酱，因为是酸味的，与奶砖的甜味融合有些相撞，当然这和个人口味有所影响。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "此外，还点了香脆鸡排和一杯饮品，但是不是特别推荐，所以在菜品里我就没有做介绍。6个菜一杯果汁消费205，美团代金券2张，一共消费161，人均80。最后走的时候还送了一张满150减50的代金券供下次使用。个人感觉，约妹纸来这里还是很合适的，哈哈哈哈哈。\n" +
                            "\n" +
                            "饭后天色还挺早的，转悠了一圈跑到索菲亚教堂喂鸽子，这应该是每次来哈尔滨的一个习惯。旁边卖饲料5块钱一包，这里我们偷偷喂了面包，感觉鸽子更喜欢面包，喂饲料的时候感觉都没有鸽子到你跟前来。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "小学时，三八节小编也是非常高兴的日子，因为学校会放半天假。记得小编第一次送玫瑰也是在小学，送的地点是在自己家楼下。那天那个女人跟平日一样坐在那个位置，手里忙活着。我拉了拉她的裙角，却没有反应，旁边的人跟她示意我来了，她才回头看了我一下。我将手里捧着的粉色玫瑰递给她，你猜她的反应是什么？\n" +
                            "\n" +
                            "我可是她的亲儿子啊！她却不愿放下手中的麻将接一下我的玫瑰QAQ...让我乖乖把花拿回家，说现在没工夫拿打着牌呢QAQ...\n" +
                            "\n" +
                            "今天就是女神节了，小编在这里祝愿所有女神光吃不胖的心愿都能够实现。您过往的岁月里，3月8日发生过什么趣事呢？欢迎在评论区留言分享。", "100"));
        }
    }
}
