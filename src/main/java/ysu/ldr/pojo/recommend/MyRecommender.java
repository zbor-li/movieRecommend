package ysu.ldr.pojo.recommend;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MyRecommender {
    public int[] userCF(int userId, int size) throws ClassNotFoundException, TasteException, IOException {
        //连接数据库
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setServerName("localhost");
//        dataSource.setUser("root");
//        dataSource.setPassword("123456");
//        dataSource.setDatabaseName("test3");


        //设置数据库推荐对应项
        //数据库构建的数据模型，一个词：太慢了
//        JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "movie_comment", "user_id", "movie_id", "rating", "time_stamp");
        //构造基于文件的数据模型
        File file = new File("/home/zbor/IdeaProjects/movie_recommendation_ldr/src/main/resources/recommendData.txt");
        //获取模型
//        DataModel model = dataModel;
        //
        DataModel dataModel = new FileDataModel(file);
        //计算相似度
        UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
        //计算阈值,选择邻近的6个用户
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(6, userSimilarity, dataModel);
        //推荐集合
        Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, userSimilarity);
        //推荐数量 为size的一个合集,这里数量可以修改
        List<RecommendedItem> recommendedItemList = recommender.recommend(userId, size);
        int[] moviesId = new int[recommendedItemList.size()];
        for (int i=0; i<recommendedItemList.size(); i++)
            moviesId[i] = (int) recommendedItemList.get(i).getItemID();
        return moviesId;
    }
    public int[] itemCF(int userId, int size) throws ClassNotFoundException, TasteException, IOException {
//        //连接数据库
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setServerName("localhost");
//        dataSource.setUser("root");
//        dataSource.setPassword("123456");
//        dataSource.setDatabaseName("test3");
//
//        //设置数据库推荐对应项
//        JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "movie_comment", "user_id", "movie_id", "rating", "time_stamp");
        //数据库构建的数据模型，一个词：太慢了
        //构造基于文件的数据模型
        File file = new File("/home/zbor/IdeaProjects/movie_recommendation_ldr/src/main/resources/recommendData.txt");
        //获取模型
//        DataModel model = dataModel;
        //
        DataModel dataModel = new FileDataModel(file);
        //计算相似度
        ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
        //构造推荐引擎
        Recommender recommender = new GenericItemBasedRecommender(dataModel,itemSimilarity);
        //获取推荐结果
        List<RecommendedItem> recommendedItemList = recommender.recommend(userId, size);
        int[] moviesId = new int[recommendedItemList.size()];
        for (int i=0; i<recommendedItemList.size(); i++)
            moviesId[i] = (int) recommendedItemList.get(i).getItemID();
        return moviesId;
    }


}