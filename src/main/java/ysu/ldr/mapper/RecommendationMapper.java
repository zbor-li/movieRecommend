package ysu.ldr.mapper;

import org.apache.ibatis.annotations.Param;

public interface RecommendationMapper {

    public Integer insertUserCFRecommends(@Param("userId") Integer userId, @Param("recommends") String recommends);

    public String getUserCFRecommends(Integer userId);

    public String getItemCFRecommends(Integer userId);

    public Integer insertItemCFRecommends(@Param("userId") Integer userId, @Param("recommends") String recommends);

    public Integer deleteRecommends(Integer userId);
}
