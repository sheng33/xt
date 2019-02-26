package service;

import dao.User;
import dao.UserFile;

import java.util.List;

public interface UploadService {
    void SaveFileName(UserFile userFile, User user);
    UserFile CheckFile(String filename,int role);
    List<UserFile> ShowList(int role);
}
