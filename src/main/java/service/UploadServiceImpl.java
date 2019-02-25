package service;

import dao.UserFile;
import dao.UserFileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UserFileDao userFileDao;
    @Override
    public void SaveFileName(UserFile userFile) {
        userFileDao.savefile(userFile.getFilename(),userFile.getFilesrc(),userFile.getNewfilename());
    }

    @Override
    public UserFile CheckFile(String filename) {
        UserFile userFile = userFileDao.findfileSrc(filename);
        if (userFile !=null){
            return userFile;
        }
        return null;
    }
}
