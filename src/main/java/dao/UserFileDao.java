package dao;

import org.apache.ibatis.annotations.Param;

public interface UserFileDao {
    UserFile findfileSrc(String filename);
    void savefile(@Param("filename")String filename,@Param("filesrc")String filesrc,@Param("newfilename")String newfilename);
}
