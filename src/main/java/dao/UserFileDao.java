package dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFileDao {
    UserFile findfileSrc(@Param("filename") String filename,@Param("role") int role);
    void savefile(@Param("filename")String filename,@Param("filesrc")String filesrc,@Param("newfilename")String newfilename,@Param("role")Integer role);
    List<UserFile> showfilelist(int role);
}
