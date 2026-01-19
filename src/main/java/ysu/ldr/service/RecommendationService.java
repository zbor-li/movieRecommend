package ysu.ldr.service;

public interface RecommendationService {

    public Integer insertUserCFRecommends(Integer userId, String recommends);

    public String getUserCFRecommends(Integer userId);

    public String  getItemCFRecommends(Integer userId);

    public Integer insertItemCFRecommends(Integer userId, String recommends);

    public Integer deleteRecommends(Integer userId);
}
