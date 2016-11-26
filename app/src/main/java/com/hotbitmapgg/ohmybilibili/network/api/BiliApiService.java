package com.hotbitmapgg.ohmybilibili.network.api;

import com.hotbitmapgg.ohmybilibili.entity.attention.AttentionDynamicInfo;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiDetailsCommentInfo;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.SpecialTopic;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.SpecialTopicIResult;
import com.hotbitmapgg.ohmybilibili.entity.discover.ActivityCenterInfo;
import com.hotbitmapgg.ohmybilibili.entity.discover.TopicCenterInfo;
import com.hotbitmapgg.ohmybilibili.entity.user.UserFavoritesInfo;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoCommentInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 21:08
 * 100332338@qq.com
 */
public interface BiliApiService
{

    /**
     * 视频评论
     *
     * @param aid
     * @param page
     * @param pageSize
     * @param ver
     * @return
     */
    @GET("feedback")
    Observable<VideoCommentInfo> getVideoComment(@Query("aid") int aid, @Query("page") int page, @Query("pagesize") int pageSize, @Query("ver") int ver);

    /**
     * 专题详情
     *
     * @param spid
     * @param title
     * @return
     */
    @GET("sp")
    Observable<SpecialTopic> getSpInfo(@Query("spid") int spid, @Query("title") String title);

    /**
     * 专题视频
     *
     * @param spid
     * @param season_id
     * @param bangumi
     * @return
     */
    @GET("spview")
    Observable<SpecialTopicIResult> getSpItemList(@Query("spid") int spid, @Query("season_id") int season_id, @Query("bangumi") int bangumi);


    /**
     * 话题中心
     *
     * @return
     */
    @GET("topic/getlist?device=phone&mobi_app=iphone&page=1&pagesize=137")
    Observable<TopicCenterInfo> getTopicCenterList();


    /**
     * 话题中心
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GET("event/getlist?device=phone&mobi_app=iphone")
    Observable<ActivityCenterInfo> getActivityCenterList(@Query("page") int page, @Query("pagesize") int pageSize);


    /**
     * 用户收藏夹
     *
     * @param mid
     * @return
     */
    @GET("x/app/favourite/folder?")
    Observable<UserFavoritesInfo> getUserFavorites(@Query("mid") int mid);


    /**
     * 首页关注
     *
     * @return
     */
    @GET("x/feed/pull?access_key=9afd8a2836e5948e84e037ca5b33309c&actionKey=appkey&appkey=27eb53fc9058f8c3&build=4000&device=phone&mobi_app=iphone&platform=ios&pn=1&ps=30&sign=8d5f090c70b3743a6a7d899d885061f0&ts=1480131936&type=0")
    Observable<AttentionDynamicInfo> getAttentionDynamic();

    /**
     * 番剧详情评论
     *
     * @return
     */
    @GET("x/v2/reply?_device=iphone&_hwid=c84c067f8d99f9d3&_ulv=10000&access_key=19946e1ef3b5cad1a756c475a67185bb&appkey=27eb53fc9058f8c3&appver=3940&build=3940&nohot=0&oid=5189987&platform=ios&pn=1&ps=20&sign=c3b059e907f5c1d3416daa9fcc6396bf&sort=0&type=1")
    Observable<BangumiDetailsCommentInfo> getBangumiDetailsComments();
}