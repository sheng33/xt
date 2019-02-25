package service;

import dao.UserFile;

public interface UploadService {
    void SaveFileName(UserFile userFile);
    UserFile CheckFile(String filename);
}
