package service;

import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import pojo.UserFile;

import java.util.List;
@Transactional
public interface UploadService {
    void SaveFileName(UserFile userFile, User user);
    UserFile CheckFile(String filename,int role);
    List<UserFile> ShowList(int role);
}
