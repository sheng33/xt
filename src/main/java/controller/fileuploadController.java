package controller;

import pojo.User;
import pojo.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.UploadService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("file")
public class fileuploadController {

    @Autowired
    private UploadService uploadService;
    @RequestMapping("/fileupload")
    public @ResponseBody String upload(MultipartFile file, HttpServletRequest request, UserFile userFile, HttpSession session) throws IOException{
        User user = (User)session.getAttribute("user");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String src =simpleDateFormat.format(new Date());

        //upload文件夹位置
        String rootPath = "D://";
        //原始名称
        String originaFileName = file.getOriginalFilename();
        //新文件名
        String newFileName = "sliver" + src + originaFileName.substring(originaFileName.lastIndexOf("."));
        //创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) +  File.separator + (date.get(Calendar.MONTH)+1));

        //新文件
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        //判断文件是否存在
        if( !newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile+"111");
        System.out.println(newFile.toString());
        System.out.println(newFile.getName());
        System.out.println(newFile.getPath());
        // 将内存中的数据写入磁盘
        file.transferTo(newFile);
        // 完整的url
        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;

        userFile.setFilename(originaFileName);
        userFile.setFilesrc(newFile.getPath());
        userFile.setNewfilename(newFileName);

        uploadService.SaveFileName(userFile,user);

        return  fileUrl;
    }

    @RequestMapping("/download")
    public void CheckFile(HttpServletResponse response, UserFile userFile,HttpServletRequest request)throws IOException{
        //得到要下载的文件
        HttpSession session = request.getSession();
        System.out.println("session:"+session);
        User user = (User)session.getAttribute("user");
        System.out.println("user:"+user);
        System.out.println(user.getRole());
        System.out.println(userFile.getFilename());
        userFile = uploadService.CheckFile(userFile.getFilename(),user.getRole());
        System.out.println(userFile.getFilename());

        String filename = userFile.getFilename();
        filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
        if(userFile!=null){
            String Path = userFile.getFilesrc();
            System.out.println(Path);
          //  File file = new File(Path);
//            if (!file.exists()) {
//                response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
//                response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></html>");
//                response.getWriter().close();
//                System.out.println("您要下载的资源已被删除！！");
//                return;
//            }
            //转码，免得文件名中文乱码

            //设置文件下载头
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            // 读取要下载的文件，保存到文件输入流
            FileInputStream in = new FileInputStream(Path);
            // 创建输出流
            OutputStream out = response.getOutputStream();

            // 创建缓冲区
            byte[] buffer = new byte[1024]; // 缓冲区的大小设置是个迷  我也没搞明白
            int len = 0;
            //循环将输入流中的内容读取到缓冲区当中
            while((len = in.read(buffer)) > 0){
                out.write(buffer, 0, len);
            }
            //关闭文件输入流
            in.close();
            // 关闭输出流
            out.close();
        }else {
            response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
            response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></html>");
            response.getWriter().close();
            System.out.println("您要下载的资源已被删除！！");
            return;
        }

    }


}
