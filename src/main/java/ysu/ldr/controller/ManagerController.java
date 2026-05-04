package ysu.ldr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ysu.ldr.mapper.CommentMapper;
import ysu.ldr.pojo.Comment;
import ysu.ldr.pojo.Movie;
import ysu.ldr.pojo.ReportComment;
import ysu.ldr.pojo.User;
import ysu.ldr.pojo.rec.CommentSearchRec;
import ysu.ldr.pojo.rec.ReportCommentRec;
import ysu.ldr.pojo.res.*;
import ysu.ldr.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//使用@RequestBody注解将前端传来的对象自动转换成Java对象
@RestController//@Controller和@ResponseBody结合
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ReportCommentService reportCommentService;

    @PostMapping("/managerLogin")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public boolean adminLogin(@RequestParam("managerName")String managerName,
                              @RequestParam("password")String password)
    {
        boolean isLogin = managerService.isLogin(managerName, password);
        System.out.println("<<<<managerName: " + managerName + " " + "password: " + password + ">>>>");
        return isLogin;
    }

    @GetMapping("/allMovies")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public AllMoviesRes findAllMovie(@RequestParam("query") String movieName,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize)
    {
//        System.out.println("pageNum: " + pageNum + " " + "pageSize: " + pageSize);
        AllMoviesRes allMoviesResPage = new AllMoviesRes();

        List<Movie> movieList = movieService.getMovieByNameSearch(movieName);
        //当query--》movieName = "" 时, getMovieByNameSearch(movieName)对应的1=模糊搜索
        //like '%${movieName}%'匹配所有项
//        if(movieName == ""){
//            movieList = movieService.getAllMovie();
//        }
//        else{
//            movieList = movieService.getMovieByNameSearch(movieName);
//        }
//        难受啊，好像多余了，给个movieList.size()就OK了，
//        Integer total = movieService.getCountOfMovie();
        int total = movieList.size();
        int i = (pageNum - 1) * pageSize;
        int max = pageNum * pageSize;
        max = Math.min(max, total);
//        System.out.println("i: " + i + " " + "max: " + max);
        List<Movie> movieListPage = new ArrayList<>(max - i);
        allMoviesResPage.setTotal(total);
        if(i >= max || total == 0) {
            return null;
        }
        for(; i < max; i++){
//            System.out.println("进入循环");
            movieListPage.add(movieList.get(i));
//            System.out.println("执行");
        }
        allMoviesResPage.setMovieList(movieListPage);
        return allMoviesResPage;
    }

    @PutMapping("/movie/{movieId}/state/{show}")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer updateMovieStatue(@PathVariable("movieId") Integer movieId,
                                     @PathVariable("show") Boolean show)
    {
//        System.out.println("接收到更新请求");
        return movieService.updateMovieStatusById(movieId, show);
    }

//    @GetMapping("/searchMovieByName/{movieName}/{pageNum}/{pageSize}")
//    //接收跨域请求
//    @CrossOrigin(origins = "http://localhost:5176")
//    public AllMoviesRes getMovieByNameSearch(@PathVariable("movieName") String movieName,
//                                        @PathVariable("pageNum") Integer pageNum,
//                                        @PathVariable("pageSize") Integer pageSize
//    ){
//        AllMoviesRes allMoviesResPage = new AllMoviesRes();
//        int i = (pageNum - 1) * pageSize;
//        int max = pageNum * pageSize;
//        List<Movie> movieList = movieService.gerMovieByNameSearch(movieName);
//        int total = movieList.size();
//        max = Math.min(max, total);//java警告给还可以优化代码，上面那同样功能改成这样
//        List<Movie> movieListPage = new ArrayList<>(max - i);
//        allMoviesResPage.setTotal(total);
//        if(i >= max || total == 0) {
//            return null;
//        }
//        for(; i < max; i++){
//            movieListPage.add(movieList.get(i));
//        }
//        allMoviesResPage.setMovieList(movieListPage);
//        return allMoviesResPage;
//    }

    @PostMapping("/addMovie")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
//    @RequestParam 注解用于获取 HTTP 请求中的请求参数，因此它只能用于获取单个参数值。
//    如果要获取一个对象的所有属性，需要使用 @ModelAttribute 或 @RequestBody 注解。
//    且@RequestBody接收前端数据时前端不能使用{params:},应该直接传输参数🙏
//    感谢ai！！！原因是，当你使用 params 参数名称时，实际上是将整个请求体作为一个字符串参数进行传递。
//    因此，你需要使用 @RequestParam 来接收这个参数，然后在方法内部将其转换为你需要的对象类型。
    public Integer addMovie(@RequestBody Movie addMovie){

//        System.out.println("接收到添加请求");
//        System.out.println(addMovie.toString());
        return movieService.addMovie(addMovie);
    }

    @PutMapping("/updateMovie")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer updateMovie(@RequestBody Movie movie)
    {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer deleteMovie(@PathVariable("movieId") Integer movieId )
    {

        return movieService.deleteMovie(movieId);
    }

    //获取allUsers或模糊搜索用户根据userName(这两项根据query是否为空来定)
    @GetMapping("/allUsers")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public AllUsersRes getAllUser(@RequestParam("query") String userName,
                                  @RequestParam("pageNum") Integer pageNum,
                                  @RequestParam("pageSize") Integer pageSize)
    {
//        System.out.println("userName: " + userName + "pageNum: " + pageNum + " " + "pageSize: " + pageSize);
        AllUsersRes allUsersRes = new AllUsersRes();
        List<User> userList = userService.getUserByNameSearch(userName);
//        userList.forEach(System.out::println);
        int total = userList.size();
//        System.out.println(total);
        int i = (pageNum - 1) * pageSize;
        int max = pageNum * pageSize;
        max = Math.min(max, total);
        allUsersRes.setTotal(total);
//        System.out.println("i: " + i + " " + "max: " + max);
        List<User> userListPage = new ArrayList<>(max - i);
        if(i >= max || total == 0) {
            return null;
        }
        for(; i < max; i++){
            userListPage.add(userList.get(i));
        }
        allUsersRes.setUserList(userListPage);
        return allUsersRes;
    }

    @PutMapping("/user/{userId}/state/{commentStatus}")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer updateUserStatue(@PathVariable("userId") Integer userId,
                                    @PathVariable("commentStatus") Boolean commentStatus)
    {
//        System.out.println("接收到更新请求");
//        System.out.println("userId: " + userId + " " + "commentStatus" + commentStatus);
        return userService.updateUserStatusById(userId, commentStatus);
    }

    @PostMapping("/addUser")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer addUser(@RequestBody User addUser){
        return userService.addUser(addUser);
    }

    @PutMapping("/updateUser")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer deleteUser(@PathVariable("userId") Integer userId )
    {
        return userService.deleteUser(userId);
    }

    @PostMapping("/allReportComments")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public AllReportCommentsRes getAllReportComments(@RequestBody ReportCommentRec reportCommentRec){

        AllReportCommentsRes allReportCommentsRes = new AllReportCommentsRes();
        List<CommentShowRow> commentShowRowList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        List<User> reportorUserList = new ArrayList<>();
        int userId, reportorId;
        List<Comment> commentList = new ArrayList<>();
        int commentId;
        List<String> reportType = reportCommentRec.getQuery();
        Integer pageNum = reportCommentRec.getPageNum();
        Integer pageSize = reportCommentRec.getPageSize();
        Boolean all = reportCommentRec.getAll();
        int total;
        List<ReportComment> reportCommentList = new ArrayList<>();
        if(all){
            reportCommentList = reportCommentService.getAllReportComment(reportType);
        }
        else{
            reportCommentList = reportCommentService.getNoHandleReportComment(reportType);
        }
        total = reportCommentList.size();
        System.out.println(total);
        System.out.println();
        System.out.println();
        for(int i = 0; i < total ; i++){
            userId = reportCommentList.get(i).getUserId();
            commentId = reportCommentList.get(i).getCommentId();
            reportorId = reportCommentList.get(i).getReportorId();
            userList.add(i, userService.getUserById(userId));
            reportorUserList.add(i, userService.getUserById(reportorId));
            commentList.add(i, commentService.getCommentById(commentId));
        }
        //分页前的整数据到此获取完毕
        //下面开始分页
        int i = (pageNum - 1) * pageSize;
        int initialI = i;
        int max = pageNum * pageSize;
        max = Math.min(max, total);
        if(i >= max || total == 0) {
            return null;
        }

        for(; i < max; i++){
            CommentShowRow commentShowRow = new CommentShowRow();
            commentShowRow.setReportId(reportCommentList.get(i).getReportId());
            commentShowRow.setCommentId(commentList.get(i).getCommentId());
            commentShowRow.setContent(commentList.get(i).getContent());
            commentShowRow.setUserName(userList.get(i).getUserName());
            commentShowRow.setUserStatus(userList.get(i).getCommentStatus());
            commentShowRow.setUserId(userList.get(i).getUserId());
            commentShowRow.setReportorName(reportorUserList.get(i).getUserName());
            commentShowRow.setReportorStatus(reportorUserList.get(i).getCommentStatus());
            commentShowRow.setReportorId(reportorUserList.get(i).getUserId());
            commentShowRow.setReason(reportCommentList.get(i).getReason());
            commentShowRow.setReportCommentStatus(reportCommentList.get(i).getHandled());
            commentShowRow.setReportType(reportCommentList.get(i).getReportType());
            commentShowRowList.add(i - initialI, commentShowRow);
            System.out.println();
            commentShowRowList.forEach(System.out::println);
            System.out.println();
        }
        commentShowRowList.forEach(System.out::println);
        allReportCommentsRes.setTotal(total);
        allReportCommentsRes.setCommentShowRow(commentShowRowList);
        return allReportCommentsRes;
    }

    @PutMapping("/report/{reportId}/state/{reportCommentStatus}")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer updateReportCommentStatue(@PathVariable("reportId") Integer reportId,
                                             @PathVariable("reportCommentStatus") Boolean reportCommentStatus)
    {
//        System.out.println("接收到更新请求");
//        System.out.println("userId: " + userId + " " + "commentStatus" + commentStatus);
        return reportCommentService.updateReportCommentStatusById(reportId, reportCommentStatus);
    }

    @DeleteMapping("/deleteReportComment/{reportId}")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer deleteReportComment(@PathVariable("reportId") Integer reportId )
    {
        return reportCommentService.deleteReportCommentById(reportId);
    }

    @PostMapping("/allComments")
    @CrossOrigin(origins = "http://localhost:5176")
    public CommentSearchRes getAllComments(@RequestBody CommentSearchRec commentSearchRec)
    {
        CommentSearchRes commentSearchRes = new CommentSearchRes();//返回结果
        List<CommentManageRes> commentManageResList = new ArrayList<>();//分页中间量
        int total = 0;
        //搜索类型为null则在下述所有类型查询
        if(commentSearchRec.getQuery() == null){
            commentManageResList = commentService.searchCommentByAll(commentSearchRec.getQueryMessage());
        }
        //搜索用户名
        else if(commentSearchRec.getQuery() == 0){
            commentManageResList = commentService.searchCommentByUserName(commentSearchRec.getQueryMessage());
        }
        //搜索电影名
        else if(commentSearchRec.getQuery() == 1){
            commentManageResList = commentService.searchCommentByMovieName(commentSearchRec.getQueryMessage());
        }
        //搜索评论内容
        else{
            commentManageResList = commentService.searchCommentByContent(commentSearchRec.getQueryMessage());
        }
        total = commentManageResList.size();
        if(total > 0){
            commentSearchRes.setTotal(total);
//            分页操作
            int i = (commentSearchRec.getPageNum() - 1) * commentSearchRec.getPageSize();
            int max = commentSearchRec.getPageNum() * commentSearchRec.getPageSize();
            if(i >= max ) {
                return null;
            }
            List<CommentManageRes> commentManageResListPage = new ArrayList<>(max - i);//分页结果量
            max = Math.min(max, total);
            for(; i < max; i++){
                commentManageResListPage.add(commentManageResList.get(i));
            }
            commentSearchRes.setCommentManageResList(commentManageResListPage);
            return commentSearchRes;
        }
        return null;
    }
    @DeleteMapping("/deleteComment/{commentId}")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer deleteCommentById(@PathVariable("commentId") Integer commentId){
        return commentService.deleteCommentById(commentId);
    }

    @GetMapping("/allShowMovies")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public AllMoviesRes findAllShowMovie(@RequestParam("query") String movieName,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize)
    {
        AllMoviesRes allMoviesResPage = new AllMoviesRes();

        List<Movie> movieList = movieService.getMovieByNameSearch(movieName);
        int total = movieList.size();
        int i = (pageNum - 1) * pageSize;
        int max = pageNum * pageSize;
        max = Math.min(max, total);
        List<Movie> movieListPage = new ArrayList<>(max - i);
        allMoviesResPage.setTotal(total);
        if(i >= max || total == 0) {
            return null;
        }
        for(; i < max; i++){
            if(movieList.get(i).getShow()){
                movieListPage.add(movieList.get(i));
            }
        }
        allMoviesResPage.setMovieList(movieListPage);
        return allMoviesResPage;
    }


}
